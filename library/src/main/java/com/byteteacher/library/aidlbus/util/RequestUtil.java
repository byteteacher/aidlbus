package com.byteteacher.library.aidlbus.util;

import android.text.TextUtils;

import com.byteteacher.library.aidlbus.entity.RequestBean;
import com.google.gson.Gson;

/**
 * 请求工具类，组装解析统一接口
 */
public class RequestUtil {

    private static Gson gson;

    static {
        gson = new Gson();
    }

    /**
     * 解析入参为对应的RequestBean
     *
     * @param post 请求参数
     * @return RequestBean对象
     */
    public static RequestBean getRequestBean(String post) {
        try {
            if (!TextUtils.isEmpty(post)) {
                return gson.fromJson(post, RequestBean.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解析paramJson参数为对应的bean
     *
     * @param requestBean 请求实体
     * @param classType   要转成的Type
     * @return 转换后的实体对象
     */
    public static <T> T getParamBean(RequestBean requestBean, Class<T> classType) {
        return getParamBean(requestBean.getParamJson(), classType);
    }

    /**
     * 解析请求参数为对应的bean
     *
     * @param paramJson 请求实体中的paramJson字段
     * @param classType 要转成的Type
     * @return 转换后的实体对象
     */
    public static <T> T getParamBean(String paramJson, Class<T> classType) {
        try {
            if (!TextUtils.isEmpty(paramJson)) {
                return gson.fromJson(paramJson, classType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
