package com.byteteacher.library.aidlbus.entity;

/**
 * Created by cj on 2019/11/28.
 */
public class ResponseBean {
    /**
     * 0 失败
     * 1 成功
     * 2 执行过程回调
     */
    private int retCode;
    /**
     * 返回数据
     */
    private String msgJson;


    public ResponseBean() {
        // AIDL接口响应实体的构造函数
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getMsgJson() {
        return msgJson;
    }

    public void setMsgJson(String msgJson) {
        this.msgJson = msgJson;
    }

}
