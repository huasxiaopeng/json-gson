package com.example.springboot.doamin;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/07/19
 */
public class AliasBean {
    /**
     * 别名处理
     */
    @JsonAlias({ "fName", "f_name" })
    private String firstName;
    private String lastName;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "AliasBean{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
