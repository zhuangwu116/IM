package com.zhuangwu.xmpp.im.mvp.view.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zhuangwu.xmpp.im.mvp.presenter.impl.MvpBasePresenter;
import com.zhuangwu.xmpp.im.mvp.view.MvpView;

/**
 * Created by zhuangwu on 2016/7/19.
 */
public abstract class MvpActivity<P extends MvpBasePresenter> extends AppCompatActivity implements MvpView {
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=bindPresenter();
        if(presenter!=null){
            presenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.detachView();
        }
    }

    public abstract P bindPresenter();
}
