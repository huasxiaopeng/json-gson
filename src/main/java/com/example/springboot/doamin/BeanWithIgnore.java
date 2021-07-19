package com.example.springboot.doamin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/07/19
 */

/**
 *  字段的忽略
 */
//@JsonIgnoreProperties({ "id" }) 这个忽略粒度较大
public class BeanWithIgnore {
    @JsonIgnore //直接属性忽略
    public int id;
    public String name;

    public BeanWithIgnore(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public BeanWithIgnore() {
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
        return "BeanWithIgnore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
