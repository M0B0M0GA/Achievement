package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import springmvc.entity.Score;
import springmvc.entity.Teacher;
import springmvc.service.ScoreService;
import springmvc.service.StudentService;
import springmvc.service.TeacherService;
import springmvc.util.Page;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ScoreService scoreService;

    // 获取分页参数
    int start = 0;
    int count = 10;
    Page page = new Page(start, count);

    @RequestMapping("BaseTeacherPage")
    public String returnTeacherIndexPage(){
        return "listTeacher";
    }

    @RequestMapping("TeacherInfo")
    public ModelAndView TeacherInfo(@RequestParam("teacherId")int id){
        ModelAndView modelAndView = new ModelAndView("teacherInfo");
        Teacher teacher = teacherService.selectByPrimaryKey(id);
        modelAndView.addObject("tea_info",teacher);
        return modelAndView;
    }

    @RequestMapping(value = "/addTeacherPage")
    public String addTeacherPage(){
        return "addTeacher";
    }

    @RequestMapping(value = "/addTeacher")
    public String addTeacher(HttpServletRequest request){
        Teacher teacher = new Teacher();
        Date birthday = null;
        // String 类型按照 yyyy-MM-dd 的格式转换为 java.util.Date 类
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = simpleDateFormat.parse(request.getParameter("teacher-birth"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        teacher.settAddress(request.getParameter("teacher-addr"));
        teacher.settBirthday(birthday);
        teacher.settNum(request.getParameter("teacher-IDC"));
        teacher.settPassword(request.getParameter("teacher-pwd"));
        teacher.settAge(Integer.parseInt(request.getParameter("teacherAge")));
        teacher.settSex(request.getParameter("teacher-sex"));
        teacher.settTel(Integer.parseInt(request.getParameter("teacher-tel")));
        teacher.settName(request.getParameter("teacher-name"));
        teacher.settMail(request.getParameter("mail"));
        teacher.settCaptcha("00000");
        teacherService.insertSelective(teacher);
        return "addTeacher";
    }

    @RequestMapping(value = "/listTeacher")
    public ModelAndView listTeacher(@RequestParam("pageStart")int pageStart, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("listTeacher");

        try {
            start = pageStart;
            count = Integer.parseInt(request.getParameter("page.count"));
        } catch (Exception e) {
        }
        page.setStart(start);
        List<Teacher> teachers = teacherService.teacherList(page.getStart(), page.getCount());
        int total = teacherService.getTeacherTotal();
        page.setTotal(total-2);
        modelAndView.addObject("page", page);
        modelAndView.addObject("teachers", teachers);
        return modelAndView;
    }

    @RequestMapping("/deleteTeacher")
    public String deleteTeacher(@RequestParam("deleteId")int id) {
        teacherService.deleteByPrimaryKey(id);
        return "listTeacher";
    }

    @RequestMapping("/editTeacherPage")
    public ModelAndView editTeacherPage() {
        ModelAndView modelAndView = new ModelAndView("editTeacherPage");
        Teacher teacher = teacherService.selectByPrimaryKey(0);
        modelAndView.addObject("update_Teacher", teacher);
        return modelAndView;
    }

    @RequestMapping("/editTeacher")
    public ModelAndView editTeacher(@RequestParam("edit_id")int id) {
        ModelAndView modelAndView = new ModelAndView("editTeacher");
        Teacher teacher = teacherService.selectByPrimaryKey(id);
        modelAndView.addObject("update_Teacher", teacher);
        return modelAndView;
    }

    @RequestMapping(value = "/updateTeacherPage", method = RequestMethod.POST)
    public ModelAndView updateTeacherPage(HttpServletRequest request) {
        Teacher teacher = new Teacher();
        int id = Integer.parseInt(request.getParameter("teacher-id"));
        int tel = Integer.parseInt(request.getParameter("teacher-tel"));
        String name = request.getParameter("teacher-name");
        int age = Integer.parseInt(request.getParameter("teacherAge"));
        String sex = request.getParameter("teacher-sex");
        String pass = request.getParameter("teacher-pwd");
        String num =request.getParameter("teacher-IDC");
        String address =request.getParameter("teacher-addr");
        String mail =request.getParameter("teacherMail");
        Date birthday = null;
        // String 类型按照 yyyy-MM-dd 的格式转换为 java.util.Date 类
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = simpleDateFormat.parse(request.getParameter("teacher-birth"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        teacher.settId(id);
        teacher.settName(name);
        teacher.settAge(age);
        teacher.settSex(sex);
        teacher.settBirthday(birthday);
        teacher.settPassword(pass);
        teacher.settTel(tel);
        teacher.settNum(num);
        teacher.settAddress(address);
        teacher.settMail(mail);
        teacher.settCaptcha("00000");
        teacherService.updateByPrimaryKeySelective(teacher);
        ModelAndView modelAndView = new ModelAndView("editTeacherPage");
        modelAndView.addObject(teacher);
        modelAndView.addObject("userId",id);
        return modelAndView;

    }

    @RequestMapping(value = "/updateTeacher", method = RequestMethod.POST)
    public ModelAndView updateTeacher(@RequestParam("teacherId")int teacherId,HttpServletRequest request) {
        Teacher teacher = new Teacher();
        int id = Integer.parseInt(request.getParameter("teacher-id"));
        int tel = Integer.parseInt(request.getParameter("teacher-tel"));
        String name = request.getParameter("teacher-name");
        int age = Integer.parseInt(request.getParameter("teacherAge"));
        String sex = request.getParameter("teacher-sex");
        String pass = request.getParameter("teacher-pwd");
        String num =request.getParameter("teacher-IDC");
        String address =request.getParameter("teacher-addr");
        String mail =request.getParameter("teacherMail");
        Date birthday = null;
        // String 类型按照 yyyy-MM-dd 的格式转换为 java.util.Date 类
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = simpleDateFormat.parse(request.getParameter("teacher-birth"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        teacher.settId(id);
        teacher.settName(name);
        teacher.settAge(age);
        teacher.settSex(sex);
        teacher.settBirthday(birthday);
        teacher.settPassword(pass);
        teacher.settTel(tel);
        teacher.settNum(num);
        teacher.settAddress(address);
        teacher.settMail(mail);
        teacher.settCaptcha("00000");
        teacherService.updateByPrimaryKeySelective(teacher);
        ModelAndView modelAndView = new ModelAndView("editTeacher");
        modelAndView.addObject(teacher);
        modelAndView.addObject("userId",teacherId);
        return modelAndView;

    }

    @RequestMapping(value = "/searchTeacher", method = RequestMethod.POST)
    public ModelAndView searchTeacher(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("listTeacher");

        int ind=Integer.parseInt(request.getParameter("searchTeacher"));
        List<Teacher> teachers = new LinkedList<Teacher>();
        Teacher teacher=teacherService.selectByPrimaryKey(ind);
        teachers.add(teacher);
        modelAndView.addObject("teachers", teachers);
        return modelAndView;
    }

    @RequestMapping(value = "/listScoreTeacher")
    public ModelAndView listScoreByTeacher(@RequestParam("pageStart")int pageStart, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("listScore");

        try {
            start = pageStart;
            count = Integer.parseInt(request.getParameter("page.count"));
        } catch (Exception exception) {
        }
        page.setStart(start);
        int teacherId = Integer.parseInt(request.getParameter("teacherId"));
        List<Teacher> scores = teacherService.selectStudentByTeacher(teacherId);
        int total = scoreService.getScoreTotal();
        page.setTotal(total-2);
        modelAndView.addObject("page", page);
        modelAndView.addObject("scores", scores);
        return modelAndView;
    }

//    @RequestMapping("TeacherCourse")
//    public ModelAndView teacherCourse(@RequestParam("teacherId")int pageStart,HttpServletRequest request){
//        ModelAndView modelAndView = new ModelAndView();
//        try {
//            start = pageStart;
//            count = Integer.parseInt(request.getParameter("page.count"));
//        } catch (Exception e) {
//        }
//        page.setStart(start);
//        List<Teacher> courses = new LinkedList<Teacher>();
//        int teacherId = Integer.parseInt(request.getParameter("teacherId"));
//        courses = teacherService.selectCourseByTeacher(teacherId);
//        int total = studentService.getStudentTotal();
//        page.setTotal(total-2);
//        modelAndView.addObject("page", page);
//        modelAndView.addObject("courses",courses);
//        return modelAndView;
//    }
//
//    @RequestMapping("TeacherScorePage")
//    public ModelAndView teacherScore(@RequestParam("teacherId")int pageStart,HttpServletRequest request){
//        ModelAndView modelAndView = new ModelAndView();
//        try {
//            start = pageStart;
//            count = Integer.parseInt(request.getParameter("page.count"));
//        } catch (Exception e) {
//        }
//        page.setStart(start);
//        List<Teacher> scores = new LinkedList<Teacher>();
//        int teacherId = Integer.parseInt(request.getParameter("teacherId"));
//        scores = teacherService.selectStudentByTeacher(teacherId);
//        int total = studentService.getStudentTotal();
//        page.setTotal(total-2);
//        modelAndView.addObject("page", page);
//        modelAndView.addObject("scores",scores);
//        return modelAndView;
//
//    }
}
