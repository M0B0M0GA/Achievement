package springmvc.entity;

import java.util.List;

public class Course {
    private Integer cId;

    private String cName;

    private Integer cTid;

    private Integer cTotal;

    private Teacher teacher;

    private List<Course> cList;

    private List<Score> scoreList;

    public List<Score> getScoreList() {
        return scoreList;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Integer getcTotal() {
        return cTotal;
    }

    public List<Course> getcList() {
        return cList;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Integer getcTid() {
        return cTid;
    }

    public void setcTid(Integer cTid) {
        this.cTid = cTid;
    }
}