package com.pull.csd;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.pull.csd.manager.ActivityManager;

/**
 * 安卓开发由一个APP拉起另一个APP的方法总结
 * 转载请标明出处：http://blog.csdn.net/zang_chen/article/details/76677846
 * 本文出自陈小二来巡山的博客：https://blog.csdn.net/zang_chen
 */
public class SplashActivity extends AppCompatActivity {

    private final int SWITCH_TOMAIN = 1;
    private MyHandler mHandler = new MyHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initIntent();
    }

    private void initIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            Uri uri = intent.getData();
            Log.i("CSD", "uri=" + uri);
            if (uri != null) {
                String scheme = uri.getScheme();//csd
                String host = uri.getHost();//pull.csd.demo
                String path = uri.getPath();///cyn
                String type = uri.getQueryParameter("type");//110
                String token = uri.getQueryParameter("token");//120
                Log.i("CSD", "scheme=" + scheme + "*" + "host=" + host + "*" + "path=" + path + "*" + "type=" + type + "*" + "token=" + token);
                if ("110".equals(type)) {//实际项目中可根据判断type值拉起相应的页面
//                    ActivityManager.getInstance().finishActivity(ResultActivity.class);//可通过此方法移除某些页面,根据需求决定要不要调用
                    Intent intentResult = new Intent(ActivityManager.getInstance().getTopActivity(), ResultActivity.class);
                    intentResult.putExtra("token", token);
                    startActivity(intentResult);
                    finish();
                }
            } else {
                String type = intent.getStringExtra("type");
                Log.i("CSD", "type=" + type);
                if (type != null) {
                    String token = intent.getStringExtra("token");
                    if ("110".equals(type)) {//实际项目中可根据判断type值拉起相应的页面
//                        ActivityManager.getInstance().finishActivity(ResultActivity.class);//可通过此方法移除某些页面,根据需求决定要不要调用
                        Intent intentResult = new Intent(ActivityManager.getInstance().getTopActivity(), ResultActivity.class);
                        intentResult.putExtra("token", token);
                        finish();
                    }
                } else {
                    initHandler();
                }
            }
        }
    }

    private void initHandler() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(SWITCH_TOMAIN);
            }
        }, 3000);
    }


    private class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SWITCH_TOMAIN:
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                    break;
            }
        }
    }

}
