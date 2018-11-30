package com.pull.csd;

import android.app.Application;

import com.pull.csd.manager.ActivityManager;

/**
 * 安卓开发由一个APP拉起另一个APP的方法总结
 * 转载请标明出处：http://blog.csdn.net/zang_chen/article/details/76677846
 * 本文出自陈小二来巡山的博客：https://blog.csdn.net/zang_chen
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActivityManager.getInstance().register(this);
    }
}
