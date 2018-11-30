package com.pull.csd.manager;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * Created by pc on 2018/11/26.
 */

public class ActivityManagerLifecycleCallbackImpl implements Application.ActivityLifecycleCallbacks {

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        ActivityManager.getInstance().addActivity(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        ActivityManager.getInstance().removeActivity(activity);
    }


}
