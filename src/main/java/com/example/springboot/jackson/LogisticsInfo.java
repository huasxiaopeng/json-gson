package com.example.springboot.jackson;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/07/19
 */
@Data
public class LogisticsInfo implements Serializable {

    private static final long serialVersionUID = 6951873346591540974L;

    /**
     * 快递公司识别码
     */
    private String comCode;

    /**
     * 快递单号
     */
    private String postNo;

    /**
     * 快递物流信息查询是否成功
     */
    private boolean success;

    /**
     * 快递查询失败原因
     */
    private String failReason;

    /**
     * 快递物流状态
     */
    private int state;

    /**
     * 快递物流轨迹信息
     */
    List<LogisticsTrace> logisticsTraceList;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getPostNo() {
        return postNo;
    }

    public void setPostNo(String postNo) {
        this.postNo = postNo;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<LogisticsTrace> getLogisticsTraceList() {
        return logisticsTraceList;
    }

    public void setLogisticsTraceList(List<LogisticsTrace> logisticsTraceList) {
        this.logisticsTraceList = logisticsTraceList;
    }
}
