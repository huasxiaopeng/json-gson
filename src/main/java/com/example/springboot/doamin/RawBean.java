package com.example.springboot.doamin;

import com.fasterxml.jackson.annotation.JsonRawValue;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/07/19
 */
public class RawBean {
    public String name;
    /**
     * json 转换成string
     */
    @JsonRawValue
    public String json;

    public RawBean(String name, String json) {
        this.name = name;
        this.json = json;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
