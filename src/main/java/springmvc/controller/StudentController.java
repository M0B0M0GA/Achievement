package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import springmvc.entity.Student;
import springmvc.service.StudentService;
import springmvc.util.Page;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class StudentController {
    @Autowired
    private StudentService studentService;

    // 获取分页参数
    int start = 0;
    int count = 10;
    Page page = new Page(start, count);

    @RequestMapping("BaseStudentPage")
    public String returnStudentIndexPage(){
        return "listStudent";
    }

    @RequestMapping("StudentInfo")
    public ModelAndView stuInfo(@RequestParam("studentId")int id){
        ModelAndView modelAndView = new ModelAndView("StudentInfo");
        Student student = studentService.selectByPrimaryKey(id);
        modelAndView.addObject("stu_info",student);

        return modelAndView;
    }

    @RequestMapping("StudentScore")
    public ModelAndView studentScore(@RequestParam("pageStart")int pageStart,@RequestParam("studentId")int studentId, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("StudentScore");
        try {
            start = pageStart;
            count = Integer.parseInt(request.getParameter("page.count"));
        } catch (Exception e) {
        }
        page.setStart(start);
        List<Map> scores = studentService.selectScoreByStudent(studentId);
        int total = studentService.getStudentTotal();
        page.setTotal(total-2);
        modelAndView.addObject("page", page);
        modelAndView.addObject("studentId",studentId);
        modelAndView.addObject("scores",scores);
        return modelAndView;
    }

    @RequestMapping("StudentCourse")
    public ModelAndView studentCourse(@RequestParam("pageStart")int pageStart,@RequestParam("studentId")int studentId, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("StudentCourse");
        try {
            start = pageStart;
            count = Integer.parseInt(request.getParameter("page.count"));
        } catch (Exception e) {
        }
        page.setStart(start);
        List<Map> courses = studentService.selectByStudent(studentId);
        int total = studentService.getStudentTotal();
        page.setTotal(total-2);
        modelAndView.addObject("page", page);
        modelAndView.addObject("studentId",studentId);
        modelAndView.addObject("courses",courses);
        return modelAndView;

    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(HttpServletRequest request) {
        Student student = new Student();

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = request.getParameter("student_sex");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        String num = request.getParameter("IDCard");
        int tel = Integer.parseInt(request.getParameter("tel"));
        String mail = request.getParameter("mail");
        Date birthday = null;
        // String 类型按照 yyyy-MM-dd 的格式转换为 java.util.Date 类
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = simpleDateFormat.parse(request.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        student.setsName(name);
        student.setsAge(age);
        student.setsSex(sex);
        student.setsBirthday(birthday);
        student.setsPassword(password);
        student.setsAddress(address);
        student.setsNum(num);
        student.setsTel(tel);
        student.setsMail(mail);
        student.setsCaptcha("00000");

        studentService.insert(student);

        return "addStudent";
    }

    @RequestMapping(value = "/listStudent")
    public ModelAndView listStudent(@RequestParam("pageStart")int pageStart,HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("listStudent");


        try {
            start = pageStart;
            count = Integer.parseInt(request.getParameter("page.count"));
        } catch (Exception e) {
        }
        page.setStart(start);
        List<Student> students = studentService.studentList(page.getStart(), page.getCount());
        int total = studentService.getStudentTotal();
        page.setTotal(total-2);
        modelAndView.addObject("page", page);
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    @RequestMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("del_id")int id) {
        studentService.deleteByPrimaryKey(id);
        return "listStudent";
    }

    @RequestMapping("/editStudentPage")
    public ModelAndView editStudentPage() {
        ModelAndView modelAndView = new ModelAndView("editStudentPage");
        Student student = studentService.selectByPrimaryKey(0);
        modelAndView.addObject("update_student", student);
        return modelAndView;
    }

    @RequestMapping("/editStudent")
    public ModelAndView editStudent(@RequestParam("edit_id")int id) {
        ModelAndView modelAndView = new ModelAndView("editStudent");
        Student student = studentService.selectByPrimaryKey(id);
        modelAndView.addObject("update_student", student);
        return modelAndView;
    }

    @RequestMapping(value = "/updateStudentPage", method = RequestMethod.POST)
    public ModelAndView updateStudentPage(HttpServletRequest request) {
        Student student=new Student();
        String id = request.getParameter("student_id");
        String tel = request.getParameter("tel");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String pass = request.getParameter("password");
        String num =request.getParameter("IDCard");
        String address =request.getParameter("address");
        String mail =request.getParameter("mail");
        Date birthday = null;
        // String 类型按照 yyyy-MM-dd 的格式转换为 java.util.Date 类
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = simpleDateFormat.parse(request.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Integer i_age=Integer.parseInt(age);
        student.setsId(Integer.parseInt(id));
        student.setsName(name);
        student.setsAge(i_age);
        student.setsSex(sex);
        student.setsBirthday(birthday);
        student.setsPassword(pass);
        student.setsTel(Integer.parseInt(tel));
        student.setsNum(num);
        student.setsAddress(address);
        student.setsMail(mail);
        student.setsCaptcha("00000");
        studentService.updateByPrimaryKeySelective(student);
        ModelAndView modelAndView = new ModelAndView("editStudentPage");
        modelAndView.addObject("userId",id);
        return modelAndView;

    }

    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    public ModelAndView updateStudent(@RequestParam("studentId")int studentId, HttpServletRequest request) {
        Student student=new Student();
        String id = request.getParameter("student_id");
        String tel = request.getParameter("tel");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String pass = request.getParameter("password");
        String num =request.getParameter("IDCard");
        String address =request.getParameter("address");
        String mail =request.getParameter("mail");
        Date birthday = null;
        // String 类型按照 yyyy-MM-dd 的格式转换为 java.util.Date 类
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = simpleDateFormat.parse(request.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Integer i_age=Integer.parseInt(age);
        student.setsId(Integer.parseInt(id));
        student.setsName(name);
        student.setsAge(i_age);
        student.setsSex(sex);
        student.setsBirthday(birthday);
        student.setsPassword(pass);
        student.setsTel(Integer.parseInt(tel));
        student.setsNum(num);
        student.setsAddress(address);
        student.setsMail(mail);
        student.setsCaptcha("00000");
        studentService.updateByPrimaryKeySelective(student);
        ModelAndView modelAndView = new ModelAndView("editStudent");
        modelAndView.addObject("userId",studentId);
        return modelAndView;

    }

    @RequestMapping(value = "/addStudentPage")
    public String addStudentPage(){
        return "addStudent";
    }

    @RequestMapping(value = "/searchStudent", method = RequestMethod.POST)
    public ModelAndView searchStudent(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("listStudent");

        int id=Integer.parseInt(request.getParameter("searchStudent"));
        List<Student> students = new LinkedList<Student>();
        Student student=studentService.selectByPrimaryKey(id);
        students.add(student);
        modelAndView.addObject("students", students);
        return modelAndView;
    }
}
