package com.example.springboot.doamin;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/07/19
 */
@JsonRootName(value ="user")
public class UserWithRoot {
    public int id;
    public String name;

    public UserWithRoot(int id, String name) {
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
        return "UserWithRoot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
