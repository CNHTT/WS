package com.cnh.weishi.view.acticity;

import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cnh.weishi.inter.IBase;
import com.cnh.weishi.presenter.BasePresenter;
import com.cnh.weishi.utils.AppManager;
import com.cnh.weishi.utils.ContextUtils;
import com.cnh.weishi.view.impl.IBaseView;

import butterknife.ButterKnife;

/**
 * @name WeiShi
 * @PACKAGE_NAME： com.cnh.weishi.view.acticity
 * @anthor CHEN QQ:2262189952
 * @anthor CHEN email:cnhttt@163.com
 * @anthor CHEN githup:cnhttt@163.com
 * @time 2017/2/23 22:39=
 */
public abstract class BaseActivity<T extends BasePresenter<IBaseView>> extends AppCompatActivity implements IBase {
    private long mUIthreadId;


    public void setActionBar() {

    }

    public void getIntentValue() {

    }

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= ContextUtils.inflate(this,getContentLayout());
        ButterKnife.bind(this,view);
        return view;
    }

    protected  BasePresenter mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUIthreadId  = Process.myTid();
        AppManager.getInstance().addActivity(this);
        mPresenter = getPresenter();

        if (mPresenter != null && this instanceof  IBaseView)
            mPresenter.attach((IBaseView) this);

        initWindow();
    }


    /**
     * 是否设置沉浸式
     *
     * @return
     */
    protected boolean isSetStatusBar() {
        return false;
    }


    private  void initWindow(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT&&isSetStatusBar()){

        }
    };
}
