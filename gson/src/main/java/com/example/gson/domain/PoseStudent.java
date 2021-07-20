package com.example.gson.domain;

import com.google.gson.annotations.Expose;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/07/20
 */
public class PoseStudent {
    @Expose
    private int rollNo;
    @Expose
    private String name;
    private boolean verified;
    private int id;
    public static String className;

    public int getRollNo() {
        return rollNo;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setVerified(boolean verified) {
        this.verified = verified;
    }
    public boolean isVerified() {
        return verified;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PoseStudent{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", verified=" + verified +
                ", id=" + id +
                '}';
    }

}
