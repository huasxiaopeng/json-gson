package com.example.gson.test;

import java.util.List;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/07/20
 */
public class ResultBean {
    private int code;
    private String msg;
    private List<UserBean> muser;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<UserBean> getMuser() {
        return muser;
    }

    public void setMuser(List<UserBean> muser) {
        this.muser = muser;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", muser=" + muser +
                '}';
    }
}
