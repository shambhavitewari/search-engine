package com.springboot.project.searchengine;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private int userid;
    private String Fname;
    private String skill;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        this.Fname = fname;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String l) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "user{" +
                "userid=" + userid +
                ", fname='" + Fname + '\'' +
                ", skill='" + skill + '\'' +
                '}';
    }

}
