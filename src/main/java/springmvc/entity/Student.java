package springmvc.entity;

import java.util.Date;
import java.util.List;

public class Student {
    private Integer sId;

    private String sName;

    private String sPassword;

    private String sSex;

    private Integer sAge;

    private String sNum;

    private Integer sTel;

    private String sAddress;

    private Date sBirthday;

    private String sMail;

    private String sCaptcha;

    private Integer sTotal;

    private List<Student> sList;

    private List<Score> scoreList;

    private List<Course> courseList;

    public Integer getsTotal() {
        return sTotal;
    }

    public List<Student> getsList() {
        return sList;
    }

    public List<Score> getScoreList() {
        return scoreList;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public Integer getsAge() {
        return sAge;
    }

    public void setsAge(Integer sAge) {
        this.sAge = sAge;
    }

    public String getsNum() {
        return sNum;
    }

    public void setsNum(String sNum) {
        this.sNum = sNum;
    }

    public Integer getsTel() {
        return sTel;
    }

    public void setsTel(Integer sTel) {
        this.sTel = sTel;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public Date getsBirthday() {
        return sBirthday;
    }

    public void setsBirthday(Date sBirthday) {
        this.sBirthday = sBirthday;
    }

    public String getsMail() {
        return sMail;
    }

    public void setsMail(String sMail) {
        this.sMail = sMail;
    }

    public String getsCaptcha() {
        return sCaptcha;
    }

    public void setsCaptcha(String sCaptcha) {
        this.sCaptcha = sCaptcha;
    }
}