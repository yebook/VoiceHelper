package com.huimin.voicedemo;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.huimin.iflylib.IflySpeechManager;
import com.huimin.iflylib.listener.IRecognizerListener;
import com.huimin.iflylib.listener.ISpeakListener;
import com.tbruyelle.rxpermissions2.RxPermissions;

public class MainActivity extends AppCompatActivity implements ISpeakListener, IRecognizerListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private boolean isRec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPermission();
//        BaiduSpeechManager.getInstance().init(this);

//        BaiduSpeechManager.getInstance().setRecogListener(this);
//        BaiduSpeechManager.getInstance().setSpeakListener(this);


      /*  IflySpeechManager.getInstance().initStart(this);
        IflySpeechManager.getInstance().setRecognizerListener(this);
        IflySpeechManager.getInstance().setSpeakListener(this); //全局
        IflySpeechManager.getInstance().startReco();*/
    }

    @Override
    protected void onStart() {
        super.onStart();

//        BaiduSpeechManager.getInstance().startRecog();
    }

    @Override
    protected void onStop() {
        super.onStop();
//        IflySpeechManager.getInstance().stopReco();
//        BaiduSpeechManager.getInstance().stopRecog();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        BaiduSpeechManager.getInstance().destory();
    }

    private void initPermission() {
        /*new RxPermissions(this).request(Manifest.permission.RECORD_AUDIO,
                Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_WIFI_STATE, Manifest.permission.ACCESS_NETWORK_STATE)
                .subscribe(granted -> {
                    if (granted) {
//                        Toast.makeText(this, "获取权限成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "请先获取权限后使用", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });*/

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
//        if (!BaiduSpeechManager.getInstance().isSpeaking()) {
//            BaiduSpeechManager.getInstance().startSpeak("你叫什么名字");
//        }

    }


    public void start1(View view) {
//        BaiduSpeechManager.getInstance().startSpeak("你叫什么名字", true);
    }

    @Override
    public void onVolumeChanged(int volume) {
        Log.e(TAG, "onVolumeChanged: " + volume);
    }

    @Override
    public void onResult(String result) {
        Log.e(TAG, "onResult: " + result);
    }

    @Override
    public void onError(String msg) {
        Log.e(TAG, "onError: " + msg);
    }

    @Override
    public void onSpeakBegin(String text) {
        Log.e(TAG, "onSpeakBegin: " + text);
    }

    @Override
    public void onSpeakOver(String msg) {
        Log.e(TAG, "onSpeakOver: " + msg);
    }

    @Override
    public void onInterrupted() {
        Log.e(TAG, "onInterrupted: ");
    }
}
