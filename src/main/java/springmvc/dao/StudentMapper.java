package springmvc.dao;

import springmvc.entity.Admin;
import springmvc.entity.Course;
import springmvc.entity.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    Integer getStudentTotal();

    List<Student> studentList(int start, int count);

    List<Map> selectByStudent(Integer sId);

    List<Map> selectScoreByStudent(Integer sId);

    int updateCaptchaByPrimaryKey(Integer sId);

    Student selectStudentByMail(String sMail);
}