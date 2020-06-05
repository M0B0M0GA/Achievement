package springmvc.entity;

import java.util.List;

public class Score {
    private Integer id;

    private Integer sid;

    private Integer cid;

    private Float score;

    private List<Score> list;

    private Course course;

    private Student student;

    private List<Score> select_by_student_List;

    private List<Score> select_by_teacher_List;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Score> getList() {
        return list;
    }

    public List<Score> getSelect_by_student_List() {
        return select_by_student_List;
    }

    public List<Score> getSelect_by_teacher_List() {
        return select_by_teacher_List;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}