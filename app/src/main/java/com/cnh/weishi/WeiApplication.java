package com.cnh.weishi;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

/**
 * @name WeiShi
 * @PACKAGE_NAME： com.cnh.weishi
 * @anthor CHEN QQ:2262189952
 * @anthor CHEN email:cnhttt@163.com
 * @anthor CHEN githup:cnhttt@163.com
 * @time 2017/2/21 21:38=
 */
public class WeiApplication extends Application {
    public static String SplashUrl ="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488464681&di=c51cbded19cc3584dd16a924426c346f&imgtype=jpg&er=1&src=http%3A%2F%2Fh.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fdc54564e9258d1093cf78e5cd558ccbf6d814dc3.jpg";

    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this,"fUecYKfyvi3rHV6kBw4a0l9k-gzGzoHsz","miUGwDC88Pp7zrRfV6DndvCf");
    }

}
