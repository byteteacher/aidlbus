package com.byteteacher.library.aidlbus;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;


/**
 * Created by cj on 2019/12/2.
 * 原生继承service实现。
 */
public abstract class AIDLService extends Service {
    public static final String TAG = "AIDLService";


    public abstract String post(String data, ILTAidlCallback callback);


    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private ILTAidl.Stub mBinder = new ILTAidl.Stub() {
        @Override
        public String post(String data, ILTAidlCallback callback) throws RemoteException {
            return AIDLService.this.post(data, callback);
        }


    };


}