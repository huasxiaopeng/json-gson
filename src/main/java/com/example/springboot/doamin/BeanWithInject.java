package com.example.springboot.doamin;

import com.fasterxml.jackson.annotation.JacksonInject;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/07/19
 */
public class BeanWithInject {
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

    @JacksonInject
    public int id;

    public String name;

    @Override
    public String toString() {
        return "BeanWithInject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
