package com.byteteacher.library.aidlbus.entity;

/**
 * Created by cj on 2019/11/28.
 */
public class RequestBean {

    private String mainCode;
    private String methodName;
    private String paramJson;
    private String packageName;

    public RequestBean() {
    }

    public RequestBean(Builder builder) {
        this.mainCode = builder.mainCode;
        this.methodName = builder.methodName;
        this.paramJson = builder.paramJson;
        this.packageName = builder.packageName;
    }

    public String getMainCode() {
        return mainCode;
    }

    public void setMainCode(String mainCode) {
        this.mainCode = mainCode;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getParamJson() {
        return paramJson;
    }

    public void setParamJson(String paramJson) {
        this.paramJson = paramJson;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }


    public static final class Builder {

        String mainCode;
        String methodName;
        String paramJson;
        String packageName;


        public Builder() {
        }

        public Builder mainCode(String mainCode) {
            this.mainCode = mainCode;
            return this;
        }

        public Builder methodName(String methodName) {
            this.methodName = methodName;
            return this;
        }

        public Builder paramJson(String paramJson) {
            this.paramJson = paramJson;
            return this;
        }

        public Builder packageName(String packageName) {
            this.packageName = packageName;
            return this;
        }


        public RequestBean build() {
            return new RequestBean(this);
        }
    }

}
