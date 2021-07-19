package com.example.springboot.doamin;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/07/19
 */
public class ExtendableBean {
    private String name;
    private Map<String,String> properties;

    public ExtendableBean() {
    }
    @JsonAnySetter
    public void add(String key, String value) {
        properties.put(key, value);
    }
    public ExtendableBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 使用map 字段进行注入
     * @return
     */
    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }


    @Override
    public String toString() {
        return "ExtendableBean{" +
                "name='" + name + '\'' +
                ", properties=" + properties +
                '}';
    }
}
