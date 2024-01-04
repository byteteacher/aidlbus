package com.byteteacher.library.aidlbus.entity;

/**
 * Created by cj on 2019/11/28.
 */
public class RequestBean {

    private String mainCode;
    private String methodName;
    private String paramJson;
    private String packageName;
    private String tag;

    public RequestBean() {
    }

    public RequestBean(Builder builder) {
        this.mainCode = builder.mainCode;
        this.methodName = builder.methodName;
        this.paramJson = builder.paramJson;
        this.packageName = builder.packageName;
        this.tag = builder.tag;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public static final class Builder {

        String mainCode;
        String methodName;
        String paramJson;
        String packageName;
        String tag;


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

        public Builder tag(String tag) {
            this.tag = tag;
            return this;
        }

        public RequestBean build() {
            return new RequestBean(this);
        }
    }

}
