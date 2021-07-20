package com.example.gson.domain;

/**
 * @Description 忽略字段的序列化
 * @Author lktbz
 * @Date 2021/07/20
 */
public class ExtStudent {
    private int rollNo;
    private String name;
    private boolean verified;
    private transient int id;
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
}
