package com.example.springboot.doamin;

import com.example.springboot.config.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/07/19
 */
public class EventWithSerializer {
    public String name;
    /**
     * 自定义序列化格式
     */
    @JsonSerialize(using = CustomDateSerializer.class)
    public Date eventDate;

    public EventWithSerializer(String name, Date eventDate) {
        this.name = name;
        this.eventDate = eventDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
}
