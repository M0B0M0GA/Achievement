package springmvc.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springmvc.dao.CourseMapper;
import springmvc.entity.Course;
import springmvc.service.CourseService;

import java.util.List;

@Repository
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;

    @Override
    public int deleteByPrimaryKey(Integer cId) {
        return courseMapper.deleteByPrimaryKey(cId);
    }

    @Override
    public int insert(Course record) {
        return courseMapper.insert(record);
    }

    @Override
    public int insertSelective(Course record) {
        return courseMapper.insertSelective(record);
    }

    @Override
    public Course selectByPrimaryKey(Integer cId) {
        return courseMapper.selectByPrimaryKey(cId);
    }

    @Override
    public int updateByPrimaryKeySelective(Course record) {
        return courseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Course record) {
        return courseMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer getCourseTotal() {
        return courseMapper.getCourseTotal();
    }

    @Override
    public List<Course> courseList(int start, int count) {
        return courseMapper.courseList(start,count);
    }

    @Override
    public Course selectByTeacher(Integer teacherId) {
        return courseMapper.selectByTeacher(teacherId);
    }


}
