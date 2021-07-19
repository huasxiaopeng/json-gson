package com.example.springboot.doamin;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/07/19
 */
public class EventWithFormat {
    public String name;

    public EventWithFormat(String name, Date eventDate) {
        this.name = name;
        this.eventDate = eventDate;
    }

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy hh:mm:ss")
    public Date eventDate;

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
