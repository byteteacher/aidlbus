package com.byteteacher.library.aidlbus;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import com.byteteacher.library.aidlbus.entity.RequestBean;
import com.byteteacher.library.aidlbus.entity.ResponseBean;
import com.google.gson.Gson;


/**
 * Created by cj on 2019/12/2.
 * aidl操作类，外部调用统一使用此类。
 */
public class AIDLServiceImpl {

    private static final String SERVICE_ACTION = "com.byteteacher.library.aidlbus.service";
    private static AIDLServiceImpl instance;
    private boolean isBind = false;

    /**
     * 统一AIDL接口
     */
    private ILTAidl aidlManager;

    /**
     * 绑定回调
     */
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            aidlManager = ILTAidl.Stub.asInterface(iBinder);
            isBind = aidlManager != null;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            aidlManager = null;
            isBind = false;
        }
    };

    public boolean isBind() {
        return isBind;
    }


    // 私有静态内部类，该类在加载时只会执行一次
    private static class SingletonHolder {
        private static final AIDLServiceImpl INSTANCE = new AIDLServiceImpl();
    }

    // 私有构造函数，防止外部类创建实例
    private AIDLServiceImpl() {}

    // 提供一个静态方法获取实例
    public static AIDLServiceImpl getInstance() {
        return SingletonHolder.INSTANCE;
    }


    /**
     * 原生应用绑定服务
     *
     * @param context:     application上下文
     * @param packageName: 服务所在包名
     */
    public boolean bindService(Context context, String packageName) {
        Intent intent = new Intent(SERVICE_ACTION);
        intent.setPackage(packageName);
        boolean isBind = context.bindService(intent, connection, Context.BIND_AUTO_CREATE);
        return isBind;
    }

    /**
     * 原生应用解绑服务
     *
     * @param context: application上下文
     */
    public void unbindService(Context context) {
        context.unbindService(connection);
        aidlManager = null;
        isBind = false;
    }

    /**
     * 插件化应用绑定Binder
     */
    public boolean bindBinder(IBinder binder) {
        if (isBind) {
            return isBind;
        } else {
            if (binder != null) {
                aidlManager = AIDLBinder.Stub.asInterface(binder);
                isBind = aidlManager != null;
            }
            return isBind;
        }
    }


    /**
     * 插件化应用解绑Binder
     */
    public void unbindBinder() {
        this.isBind = false;
        this.aidlManager = null;
    }


    /**
     * 统一接口post方法。
     */
    public String post(String data, ILTAidlCallback callback) {
        try {
            return aidlManager.post(data, callback);
        } catch (Exception e) {
            e.printStackTrace();
            callbackFail(callback, e.getMessage());
            return fail(e.getMessage());
        }
    }

    /**
     * 统一接口重载
     */
    public String post(RequestBean requestBean, ILTAidlCallback callback) {
        return post(new Gson().toJson(requestBean), callback);
    }


    /**
     * 生成返回数据ResponseBean
     *
     * @param retCode 返回码
     * @param msgJson 返回数据json格式
     */
    private static ResponseBean createResponseBean(int retCode, String msgJson) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setRetCode(retCode);
        responseBean.setMsgJson(msgJson);
        return responseBean;
    }

    private static String fail(String msgJson) {
        ResponseBean responseBean = createResponseBean(0, msgJson);
        return new Gson().toJson(responseBean);
    }

    private static String success(String msgJson) {
        ResponseBean responseBean = createResponseBean(1, msgJson);
        return new Gson().toJson(responseBean);
    }

    private static String progress(String msgJson) {
        ResponseBean responseBean = createResponseBean(2, msgJson);
        return new Gson().toJson(responseBean);
    }


    /**
     * 回调返回失败结果
     */
    public static void callbackFail(ILTAidlCallback callback, String msgJson) {
        try {
            if (callback != null) {
                callback.callback(fail(msgJson));
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回调返回正确结果
     */
    public static void callbackSuccess(ILTAidlCallback callback, String msgJson) {
        try {
            if (callback != null) {
                callback.callback(success(msgJson));
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回调返回过程信息
     */
    public static void callbackProgress(ILTAidlCallback callback, String msgJson) {

        try {
            if (callback != null) {
                callback.callback(progress(msgJson));
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
