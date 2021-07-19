package com.example.springboot.doamin;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @Description调整序列化字段顺序
 * @Author lktbz
 * @Date 2021/07/19
 */
@JsonPropertyOrder({"name","id"})
public class MyBeanOrder {
    public int id;
    private String name;
    public MyBeanOrder(int id, String name) {
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
}
