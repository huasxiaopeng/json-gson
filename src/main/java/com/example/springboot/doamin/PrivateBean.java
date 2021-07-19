package com.example.springboot.doamin;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/07/19
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PrivateBean {
    private int id;
    private String name;

    public PrivateBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PrivateBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
