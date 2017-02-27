package com.cnh.weishi.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * @name WeiShi
 * @PACKAGE_NAME： com.cnh.weishi.utils
 * @anthor CHEN QQ:2262189952
 * @anthor CHEN email:cnhttt@163.com
 * @anthor CHEN githup:cnhttt@163.com
 * @time 2017/2/27 23:03=
 */
public class ContextUtils {
    /**
     *    px >>   sp
     * @param context
     * @param pxValue
     * @return
     */
    public static  int px2Sp(Context context ,float pxValue){
        final  float fontScale = context.getResources()
                .getDisplayMetrics().scaledDensity;
        return (int) (pxValue/fontScale+0.5f);
    }


    private static LayoutInflater inflater;

    /**
     * 加载布局
     * @param context
     * @param res
     * @return
     */
    public static View inflate(Context context ,int res){
        if (inflater == null)
        {
            inflater = LayoutInflater.from(context);
        }
        return inflater.inflate(res,null);
        }
    }


