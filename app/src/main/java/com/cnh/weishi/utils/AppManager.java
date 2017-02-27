package com.cnh.weishi.utils;

import android.app.Activity;
import android.content.Context;

import java.util.Stack;

/**
 * @name WeiShi
 * @PACKAGE_NAME： com.cnh.weishi.utils
 * @anthor CHEN QQ:2262189952
 * @anthor CHEN email:cnhttt@163.com
 * @anthor CHEN githup:cnhttt@163.com
 * @time 2017/2/27 21:59=
 */
public class AppManager {
    private static Stack<Activity> activityStack;
    private static AppManager ourInstance = new AppManager();

    private AppManager() {
    }

    public static AppManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new AppManager();
        }
        return ourInstance;
    }

    /**
     * Add Activity
     * @param activity
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

    /**
     * gety current Activity
     * @return
     */
    public Activity currentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * close current Activity
     */
    public void finishActivity() {
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * From activity  Close　Activity
     * @param activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * From class Close activity
     *
     * @param cls
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls))
                finishActivity(activity);
        }
    }

    /**
     * finish All Activity  And Exit
     * @param context
     */
    public void finishAllActivityAndExit(Context context) {
        if (activityStack != null) {
            for (Activity activity : activityStack) {
                if (activity!=null)
                    activity.finish();
            }
            activityStack.clear();
        }
    }

}
