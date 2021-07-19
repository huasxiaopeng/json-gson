package com.example.springboot.doamin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/07/19
 */
public class BeanWithCreator {
    public int id;
    public String name;

    /**
     * json 串与实体类不匹配解决方案
     * @param id
     * @param name
     */
    @JsonCreator
    public BeanWithCreator(
            @JsonProperty("id") int id,
            @JsonProperty("theName") String name) {
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
        return "BeanWithCreator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
