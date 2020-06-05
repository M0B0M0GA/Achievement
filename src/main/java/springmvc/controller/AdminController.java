package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import springmvc.entity.Admin;
import springmvc.entity.Student;
import springmvc.service.AdminService;
import springmvc.util.Page;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("")
public class AdminController {
    @Autowired
    private AdminService adminService;

    int start = 0;
    int count = 10;
    Page page = new Page(start,count);

    @RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
    public String addAdmin(HttpServletRequest request) {
        Admin admin = new Admin();

        String name = request.getParameter("a_name");
        String password = request.getParameter("a_password");
        String mail = request.getParameter("a_mail");
        String captcha = request.getParameter("a_captcha");

        admin.setaName(name);
        admin.setaPassword(password);
        admin.setaMail(mail);
        admin.setaCaptcha(captcha);

        adminService.insert(admin);

        return "addAdmin";
    }

    @RequestMapping(value = "/addAdminPage")
    public String addAdminPage(){
        return "addAdmin";
    }

    @RequestMapping("/editAdmin")
    public ModelAndView editAdmin(@RequestParam("adminId")int id) {
        int adminId = id;
        ModelAndView modelAndView = new ModelAndView("editAdmin");
        Admin admin = adminService.selectByPrimaryKey(adminId);
        modelAndView.addObject("update_Admin", admin);
        return modelAndView;
    }

    @RequestMapping(value = "/updateAdmin", method = RequestMethod.POST)
    public ModelAndView updateAdmin(@RequestParam("adminId")int adminId, HttpServletRequest request) {
        Admin admin = new Admin();
        String name = request.getParameter("name");
        String pass = request.getParameter("password");
        String mail =request.getParameter("mail");

        admin.setaId(adminId);
        admin.setaName(name);
        admin.setaPassword(pass);
        admin.setaMail(mail);
        admin.setaCaptcha("00000");
        adminService.updateByPrimaryKeySelective(admin);
        ModelAndView modelAndView = new ModelAndView("editAdmin");
        modelAndView.addObject("userId",adminId);
        return modelAndView;

    }

    @RequestMapping(value = "/listAdmin")
    public ModelAndView listAdmin(@RequestParam("pageStart")int pageStart,HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("listAdmin");

        try {
            start = pageStart;
            count = Integer.parseInt(request.getParameter("page.count"));
        }catch (Exception exception){
        }

        page.setStart(start);
        List<Admin> admin = adminService.adminList(page.getStart(),page.getCount());
        int total = adminService.getAdminTotal();
        page.setTotal(total-2);
        modelAndView.addObject("page",page);//        设置需要的返回值
        modelAndView.addObject("admin",admin);//        设置需要的返回值
        return modelAndView;
    }
}
