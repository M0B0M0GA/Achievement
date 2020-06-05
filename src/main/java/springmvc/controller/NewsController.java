package springmvc.controller;


import springmvc.entity.Admin;
import springmvc.entity.Student;
import springmvc.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import springmvc.service.AdminService;
import springmvc.service.StudentService;
import springmvc.service.TeacherService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("")
public class NewsController {
    @Autowired()
    private AdminService adminService;
    @Autowired()
    private StudentService studentService;
    @Autowired()
    private TeacherService teacherService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request){
        String uName; String pwd;
        ModelAndView modelAndView = new ModelAndView();
        String loginType;
        uName = request.getParameter("account");
        pwd = request.getParameter("password");
        loginType = request.getParameter("loginType");

        if(loginType.equals("管理员")){
            int aId = Integer.parseInt(uName);
            Admin admin = adminService.selectByPrimaryKey(aId);
            if (admin != null && admin.getaPassword().equals(pwd)){
                modelAndView.setViewName("basePage");
                modelAndView.addObject("adminId",uName);
                return modelAndView;
            }else{
                modelAndView.addObject("message","账号或密码错误");
                modelAndView.setViewName("test");
            }

        }else if(loginType.equals("教师")){
            int tId=Integer.parseInt(uName);
            Teacher teacher = teacherService.selectByPrimaryKey(tId);
            if(teacher != null && teacher.gettPassword().equals(pwd)) {
                modelAndView.setViewName("basePageTeacher");
                modelAndView.addObject("teacherId",uName);
                return modelAndView;
            }else{
                modelAndView.addObject("message","账号或密码错误");
                modelAndView.setViewName("test");
            }

        } else if(loginType.equals("学生")){
            int sId=Integer.parseInt(uName);
            Student student = studentService.selectByPrimaryKey(sId);
            if(student != null && student.getsPassword().equals(pwd)) {
                modelAndView.setViewName("basePageStudent");
                modelAndView.addObject("studentId", uName);
                return modelAndView;
            }else{
                modelAndView.addObject("message","账号或密码错误");
                modelAndView.setViewName("test");
            }
        }else {

            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/findPasswordPage")
    public String findPasswordPage(){
        return "findPassword";
    }

    @RequestMapping(value = "/findPassword")
    public ModelAndView findPassword(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        String email = request.getParameter("email");
        String forgetType = request.getParameter("forgetType");

        if(forgetType.equals("管理员")){
            Admin admin = adminService.selectAdminByMail(email);
            if (admin == null){
                modelAndView.addObject("password","邮箱错误或账号不存在");
                modelAndView.setViewName("test2");
            }else {
                    admin.setaPassword("000000");
                    adminService.updateByPrimaryKeySelective(admin);
                    modelAndView.addObject("password","密码为：000000");
                    modelAndView.setViewName("test2");
            }
            return modelAndView;
        }else if(forgetType.equals("教师")){
            Teacher teacher = teacherService.selectTeacherByMail(email);
            if(teacher == null) {
                modelAndView.addObject("password","邮箱错误或账号不存在");
                modelAndView.setViewName("test2");
            }else {

                    teacher.settPassword("000000");
                    teacherService.updateByPrimaryKeySelective(teacher);
                modelAndView.addObject("password","密码为：000000");
                    modelAndView.setViewName("test2");
            }
            return modelAndView;
        } else if(forgetType.equals("学生")){
            Student student = studentService.selectStudentByMail(email);
            if(student == null) {
                modelAndView.addObject("password","邮箱错误或账号不存在");
                modelAndView.setViewName("test2");
            }else {
                    student.setsPassword("000000");
                    studentService.updateByPrimaryKeySelective(student);
                    modelAndView.addObject("password","密码为：000000");
                    modelAndView.setViewName("test2");
             }
            return modelAndView;
        }
        return null;
    }

    @RequestMapping(value = "/login/page")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/loginOutPage")
    public String loginOUtPage(){
        return "login";
    }

}
