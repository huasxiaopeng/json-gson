package com.example.springboot.jackson;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/07/19
 */
@Data
public class LogisticsTrace implements Serializable {

    private static final long serialVersionUID = -5152487306550447774L;

    /**
     * 接收时间
     */
    private String acceptTime;

    /**
     * 物流描述
     */
    private String acceptStation;

    /**
     * 备注信息
     */
    private String remark;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getAcceptStation() {
        return acceptStation;
    }

    public void setAcceptStation(String acceptStation) {
        this.acceptStation = acceptStation;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
