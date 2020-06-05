package springmvc.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springmvc.dao.AdminMapper;
import springmvc.entity.Admin;
import springmvc.service.AdminService;

import java.util.List;

@Repository
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int deleteByPrimaryKey(Integer aId) {
        return adminMapper.deleteByPrimaryKey(aId);
    }

    @Override
    public int insert(Admin record) {
        return adminMapper.insert(record);
    }

    @Override
    public int insertSelective(Admin record) {
        return adminMapper.insertSelective(record);
    }

    @Override
    public Admin selectByPrimaryKey(Integer aId) {
        return adminMapper.selectByPrimaryKey(aId);
    }

    @Override
    public int updateByPrimaryKeySelective(Admin record) {
        return adminMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        return updateByPrimaryKey(record);
    }

    @Override
    public int updateCaptchaByPrimaryKey(Integer aId) {
        return adminMapper.updateCaptchaByPrimaryKey(aId);
    }

    @Override
    public Admin selectAdminByMail(String aMail) {
        return adminMapper.selectAdminByMail(aMail);
    }

    @Override
    public List<Admin> adminList(int start, int count) {
        return adminMapper.adminList(start,count);
    }

    @Override
    public Integer getAdminTotal() {
        return adminMapper.getAdminTotal();
    }
}
