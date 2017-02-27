package com.cnh.weishi.presenter;

import com.cnh.weishi.view.impl.IBaseView;

/**
 * @name WeiShi
 * @PACKAGE_NAME： com.cnh.weishi.presenter
 * @anthor CHEN QQ:2262189952
 * @anthor CHEN email:cnhttt@163.com
 * @anthor CHEN githup:cnhttt@163.com
 * @time 2017/2/23 22:41=
 */
public abstract class BasePresenter<T extends IBaseView>{
    public  T mView;
    public  void attach(T mView){
        this.mView =mView;
    }
    public void detachView() {
        if (mView != null) {
            mView = null;
        }
    }
}
