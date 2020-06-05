package springmvc.dao;

import springmvc.entity.Score;
import springmvc.entity.Teacher;

import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer tId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer tId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    Integer getTeacherTotal();

    List<Teacher> teacherList(int start, int count);

    int updateCaptchaByPrimaryKey(Integer tId);

    List<Teacher> selectStudentByTeacher(Integer tId);

    List<Teacher> selectCourseByTeacher(Integer tId);

    Teacher selectTeacherByMail(String tMail);
}