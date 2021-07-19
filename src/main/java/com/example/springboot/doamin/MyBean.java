package com.example.springboot.doamin;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/07/19
 */
//空字段不映射
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyBean {
    public int id;
    private String name;

    /**
     * 标记方法为getter方法
     * 并可以修改返回值属性名
     * @return
     */
    @JsonGetter("j_name")
    public String getTheName() {
        return name;
    }

    public MyBean(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
