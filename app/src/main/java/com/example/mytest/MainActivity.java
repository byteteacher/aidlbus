package com.example.mytest;

import android.view.View;

import com.byteteacher.library.aidlbus.AIDLServiceImpl;
import com.byteteacher.library.base.BaseActivity;
import com.example.my.R;



public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "cj";


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_start:

                break;
        }
    }


}
