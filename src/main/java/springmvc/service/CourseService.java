package springmvc.service;

import springmvc.entity.Course;

import java.util.List;

public interface CourseService {
    int deleteByPrimaryKey(Integer cId);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    Integer getCourseTotal();

    List<Course> courseList(int start, int count);

    Course selectByTeacher(Integer teacherId);

}
