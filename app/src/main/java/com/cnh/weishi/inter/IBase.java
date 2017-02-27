package com.cnh.weishi.inter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cnh.weishi.presenter.BasePresenter;

/**
 * @name WeiShi
 * @PACKAGE_NAME： com.cnh.weishi.inter
 * @anthor CHEN QQ:2262189952
 * @anthor CHEN email:cnhttt@163.com
 * @anthor CHEN githup:cnhttt@163.com
 * @time 2017/2/23 22:46=
 */
public interface IBase {
    BasePresenter getPresenter();
    View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    void bindView(Bundle savedInstanceState);

    View getView();

    int getContentLayout();
}
