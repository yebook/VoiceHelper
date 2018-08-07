package com.huimin.voicedemo;

import android.app.Application;

import com.huimin.iflylib.IflySpeechManager;
import com.huimin.iflylib.WakeUpHelper;


/**
 * Created by kermitye
 * Date: 2018/5/23 17:16
 * Desc:
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        WakeUpHelper.getInstance().init(this);
//        IflySpeechManager.getInstance().init(this);
    }
}
