package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import springmvc.entity.Course;
import springmvc.service.CourseService;
import springmvc.util.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("")
public class CourseController{
   @Autowired
    private CourseService courseService;

   int start = 0;
   int count = 10;
   Page page = new Page(start,count);

   @RequestMapping("BaseCoursePage")
    public String returnCourseIndexPage(){
       return "listCourse";
   }

   @RequestMapping(value = "/addCoursePage")
    public String addCoursePage(){
    return "addCourse";
   }

   @RequestMapping(value = "/addCourse",method = RequestMethod.POST)
    public String addCourse(HttpServletRequest request) {
       Course course = new Course();
       String courseName = request.getParameter("course_name");
       int teacherId = Integer.parseInt(request.getParameter("course_teacher"));

       course.setcName(courseName);
       course.setcTid(teacherId);
       courseService.insert(course);
       return "addCourse";
   }

   @RequestMapping(value = "/listCourse")
    public ModelAndView listCourse(@RequestParam("pageStart")int pageStart,HttpServletRequest request){
      ModelAndView modelAndView = new ModelAndView("listCourse");

      try {
         start = pageStart;
         count = Integer.parseInt(request.getParameter("page.count"));
      }catch (Exception exception){
      }

      page.setStart(start);
      List<Course> courses = courseService.courseList(page.getStart(),page.getCount());
      int total = courseService.getCourseTotal();
      page.setTotal(total);
      modelAndView.addObject("page",page);//        设置需要的返回值
      modelAndView.addObject("courses",courses);//        设置需要的返回值
      return modelAndView;
   }

   @RequestMapping(value = "/deleteCourse")
   public String deleteCourse(@RequestParam("deleteId")int id){
      courseService.deleteByPrimaryKey(id);
      return "listCourse";
   }

   @RequestMapping(value = "/editCourse")
   public ModelAndView editCourse(){
      ModelAndView modelAndView = new ModelAndView("editCourse");
      Course course = courseService.selectByPrimaryKey(0);
      modelAndView.addObject("updateCourse",course);
      return modelAndView;
   }

   @RequestMapping(value = "/updateCourse",method = RequestMethod.POST)
   public String updateCourse(HttpServletRequest request){
      Course course = new Course();
      int courseId = Integer.parseInt(request.getParameter("course_id"));
      String courseName = request.getParameter("course_name");
      int teacherId = Integer.parseInt(request.getParameter("course_teacher"));

      course.setcId(courseId);
      course.setcName(courseName);
      course.setcTid(teacherId);
      courseService.updateByPrimaryKeySelective(course);
      return "editCourse";
   }

   @RequestMapping(value = "/searchCourse", method = RequestMethod.POST)
   public ModelAndView searchCourse(HttpServletRequest request){
      ModelAndView modelAndView = new ModelAndView();

      int id = Integer.parseInt(request.getParameter("searchCourse"));
      List<Course> courses = new LinkedList<Course>();
      Course course = courseService.selectByPrimaryKey(id);
      courses.add(course);
      modelAndView.addObject("courses",courses);
      return modelAndView;
   }

   @RequestMapping(value = "/searchCourseByTeacher", method = RequestMethod.POST)
   public ModelAndView searchCourseByTeacher(HttpServletRequest request){
      ModelAndView modelAndView = new ModelAndView();

      int id = Integer.parseInt(request.getParameter("searchCourse"));
      List<Course> courses = new LinkedList<Course>();
      Course course = courseService.selectByTeacher(id);
      courses.add(course);
      modelAndView.addObject("courses",courses);
      return modelAndView;
   }
}