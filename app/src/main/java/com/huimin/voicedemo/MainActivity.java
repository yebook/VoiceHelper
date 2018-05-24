package com.huimin.voicedemo;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.huimin.iflylib.IflySpeechManager;
import com.huimin.iflylib.Logger;
import com.huimin.iflylib.RecognizerHelper;
import com.huimin.iflylib.TtsHelper;
import com.huimin.iflylib.listener.IRecognizerListener;
import com.huimin.iflylib.listener.ISpeakLisstener;
import com.huimin.iflylib.listener.SpeakListener;
import com.iflytek.cloud.thirdparty.I;
import com.iflytek.cloud.thirdparty.L;
import com.tbruyelle.rxpermissions2.RxPermissions;

public class MainActivity extends AppCompatActivity implements IRecognizerListener, ISpeakLisstener {

    private boolean isRec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPermission();
        IflySpeechManager.getInstance().initStart(this);
        IflySpeechManager.getInstance().setRecognizerListener(this);
//        IflySpeechManager.getInstance().setSpeakListener(this);
    }

    private void initPermission() {
        new RxPermissions(this).request(Manifest.permission.RECORD_AUDIO,
                Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.CHANGE_NETWORK_STATE, Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.ACCESS_NETWORK_STATE)
                .subscribe(granted -> {
                    if (granted) {
//                        Toast.makeText(this, "获取权限成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "请先获取权限后使用", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
    }

    public void start(View view) {

        IflySpeechManager.getInstance().startSpeak("你叫什么名字");


        /*if (isRec) {
            isRec = false;
            IflySpeechManager.getInstance().stopReco();
        } else {
            isRec = true;
            IflySpeechManager.getInstance().startReco();
        }*/
    }


    public void start1(View view) {
        IflySpeechManager.getInstance().startSpeak("今天星期几", new ISpeakLisstener() {
            @Override
            public void onSpeakBegin(String text) {
                Logger.error("====speak: onSpeakBegin1111  " + text);
            }

            @Override
            public void onSpeakOver(String msg) {
                Logger.error("====speak: onSpeakOver11111 / " + msg);
            }

            @Override
            public void onInterrupted() {
                Logger.error("====speak: onInterrupted1111");
            }
        });
    }


    @Override
    public void onVolumeChanged(int volume) {

    }

    @Override
    public void onResult(String result) {

    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public void onSpeakBegin(String text) {
        Logger.error("====speak: onSpeakBegin  " + text);
    }

    @Override
    public void onSpeakOver(String msg) {
        Logger.error("====speak: onSpeakOver / " + msg);
    }

    @Override
    public void onInterrupted() {
        Logger.error("====speak: onInterrupted");
    }
}
