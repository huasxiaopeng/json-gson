package com.example.gson.domain;

import com.google.gson.annotations.Since;

/**
 * @Description gson 版本支持
 * @Author lktbz
 * @Date 2021/07/20
 */
public class VersionStudent {
    @Since(1.0)
    private int rollNo;

    @Since(1.0)
    private String name;

    @Since(1.1)
    private boolean verified;

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

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    @Override
    public String toString() {
        return "VersionStudent{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", verified=" + verified +
                '}';
    }
}
