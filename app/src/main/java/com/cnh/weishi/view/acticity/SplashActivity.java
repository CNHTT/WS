package com.cnh.weishi.view.acticity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cnh.weishi.R;
import com.cnh.weishi.WeiApplication;


/**
 * 欢迎页
 */
public class SplashActivity extends AppCompatActivity {

    private ImageView splash_imageView;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        // 隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        initFindById();
        Glide.with(SplashActivity.this).load(WeiApplication.SplashUrl).placeholder(R.mipmap.load).error(R.mipmap.err).into(splash_imageView);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                mHandler.postDelayed(this,5000);
            }
        },5000);
    }

    private void initFindById() {
        splash_imageView = (ImageView) findViewById(R.id.splash_imageView);
    }


    @Override
    public void onBackPressed() {
    }
}
