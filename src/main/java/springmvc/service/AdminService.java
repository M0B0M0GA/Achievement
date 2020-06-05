package springmvc.service;

import springmvc.entity.Admin;

import java.util.List;

public interface AdminService {
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
