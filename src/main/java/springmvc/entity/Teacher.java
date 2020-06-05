package springmvc.entity;

import java.util.Date;
import java.util.List;

public class Teacher {
    private Integer tId;

    private String tName;

    private String tPassword;

    private String tSex;

    private Integer tAge;

    private String tNum;

    private Integer tTel;

    private String tAddress;

    private Date tBirthday;

    private String tMail;

    private String tCaptcha;

    private Integer tatol;

    private List<Teacher> list;

    private List<Score> scoreList;

    private List<Course> courseList;

    public List<Course> getCourseList() {
        return courseList;
    }

    public Integer getTatol() {
        return tatol;
    }

    public List<Teacher> getList() {
        return list;
    }

    public List<Score> getScoreList() {
        return scoreList;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettPassword() {
        return tPassword;
    }

    public void settPassword(String tPassword) {
        this.tPassword = tPassword;
    }

    public String gettSex() {
        return tSex;
    }

    public void settSex(String tSex) {
        this.tSex = tSex;
    }

    public Integer gettAge() {
        return tAge;
    }

    public void settAge(Integer tAge) {
        this.tAge = tAge;
    }

    public String gettNum() {
        return tNum;
    }

    public void settNum(String tNum) {
        this.tNum = tNum;
    }

    public Integer gettTel() {
        return tTel;
    }

    public void settTel(Integer tTel) {
        this.tTel = tTel;
    }

    public String gettAddress() {
        return tAddress;
    }

    public void settAddress(String tAddress) {
        this.tAddress = tAddress;
    }

    public Date gettBirthday() {
        return tBirthday;
    }

    public void settBirthday(Date tBirthday) {
        this.tBirthday = tBirthday;
    }

    public String gettMail() {
        return tMail;
    }

    public void settMail(String tMail) {
        this.tMail = tMail;
    }

    public String gettCaptcha() {
        return tCaptcha;
    }

    public void settCaptcha(String tCaptcha) {
        this.tCaptcha = tCaptcha;
    }
}