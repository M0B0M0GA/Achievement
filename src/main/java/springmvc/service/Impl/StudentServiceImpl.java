package springmvc.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springmvc.dao.StudentMapper;
import springmvc.entity.Course;
import springmvc.entity.Student;
import springmvc.service.StudentService;

import java.util.List;
import java.util.Map;

@Repository
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public int deleteByPrimaryKey(Integer sId) {
        return studentMapper.deleteByPrimaryKey(sId);
    }

    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    @Override
    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }

    @Override
    public Student selectByPrimaryKey(Integer sId) {
        return studentMapper.selectByPrimaryKey(sId);
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer getStudentTotal() {
        return studentMapper.getStudentTotal();
    }

    @Override
    public List<Student> studentList(int start, int count) {
        return studentMapper.studentList(start,count);
    }

    @Override
    public List<Map> selectByStudent(Integer sId) {
        return studentMapper.selectByStudent(sId);
    }

    @Override
    public List<Map> selectScoreByStudent(Integer sId) {
        return studentMapper.selectScoreByStudent(sId);
    }

    @Override
    public int updateCaptchaByPrimaryKey(Integer sId) {
        return studentMapper.updateCaptchaByPrimaryKey(sId);
    }

    @Override
    public Student selectStudentByMail(String sMail) {
        return studentMapper.selectStudentByMail(sMail);
    }
}
