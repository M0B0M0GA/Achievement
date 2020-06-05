package springmvc.entity;

import java.util.List;

public class Admin {
    private Integer aId;

    private String aName;

    private String aPassword;

    private String aMail;

    private String aCaptcha;

    private Integer aTotal;

    private List<Admin> adminList;

    public Integer getaTotal() {
        return aTotal;
    }

    public List<Admin> getAdminList() {
        return adminList;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword;
    }

    public String getaMail() {
        return aMail;
    }

    public void setaMail(String aMail) {
        this.aMail = aMail;
    }

    public String getaCaptcha() {
        return aCaptcha;
    }

    public void setaCaptcha(String aCaptcha) {
        this.aCaptcha = aCaptcha;
    }
}