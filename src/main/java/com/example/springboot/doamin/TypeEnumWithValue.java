package com.example.springboot.doamin;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/07/19
 */
public enum TypeEnumWithValue {
    TYPE1(1, "Type A"), TYPE2(2, "Type 2");

    private Integer id;
    private String name;

    TypeEnumWithValue(int id, String name) {
        this.id=id;
        this.name=name;
    }

    // standard constructors

    @JsonValue
    public String getName() {
        return name;
    }
}
