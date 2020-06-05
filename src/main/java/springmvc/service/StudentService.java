package springmvc.service;

import springmvc.entity.Course;
import springmvc.entity.Score;
import springmvc.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    int deleteByPrimaryKey(Integer sId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    Integer getStudentTotal();

    List<Student> studentList(int start, int count);

    List<Map> selectByStudent(Integer studentId);

    List<Map> selectScoreByStudent(Integer studentId);

    int updateCaptchaByPrimaryKey(Integer sId);

    Student selectStudentByMail(String sMail);
}
