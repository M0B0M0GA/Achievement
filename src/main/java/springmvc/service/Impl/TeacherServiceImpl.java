package springmvc.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springmvc.dao.TeacherMapper;
import springmvc.entity.Score;
import springmvc.entity.Teacher;
import springmvc.service.TeacherService;

import java.util.List;

@Repository
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public int deleteByPrimaryKey(Integer tId) {
        return teacherMapper.deleteByPrimaryKey(tId);
    }

    @Override
    public int insert(Teacher record) {
        return teacherMapper.insert(record);
    }

    @Override
    public int insertSelective(Teacher record) {
        return teacherMapper.insertSelective(record);
    }

    @Override
    public Teacher selectByPrimaryKey(Integer tId) {
        return teacherMapper.selectByPrimaryKey(tId);
    }

    @Override
    public int updateByPrimaryKeySelective(Teacher record) {
        return teacherMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Teacher record) {
        return teacherMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer getTeacherTotal() {
        return teacherMapper.getTeacherTotal();
    }

    @Override
    public List<Teacher> teacherList(int start, int count) {
        return teacherMapper.teacherList(start,count);
    }

    @Override
    public int updateCaptchaByPrimaryKey(Integer tId) {
        return teacherMapper.updateCaptchaByPrimaryKey(tId);
    }

    @Override
    public List<Teacher> selectStudentByTeacher(Integer tId) {
        return teacherMapper.selectStudentByTeacher(tId);
    }

    @Override
    public List<Teacher> selectCourseByTeacher(Integer tId) {
        return teacherMapper.selectCourseByTeacher(tId);
    }

    @Override
    public Teacher selectTeacherByMail(String tMail) {
        return teacherMapper.selectTeacherByMail(tMail);
    }
}
