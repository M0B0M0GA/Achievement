package springmvc.dao;

import springmvc.entity.Admin;
import springmvc.entity.Course;
import springmvc.entity.Student;

import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer aId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer aId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    int updateCaptchaByPrimaryKey(Integer aId);

    Admin selectAdminByMail(String aMail);

    List<Admin> adminList(int start, int count);

    Integer getAdminTotal();
}