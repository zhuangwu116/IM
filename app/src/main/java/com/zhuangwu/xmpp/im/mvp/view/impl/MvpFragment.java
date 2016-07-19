package com.zhuangwu.xmpp.im.mvp.view.impl;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.zhuangwu.xmpp.im.mvp.presenter.impl.MvpBasePresenter;
import com.zhuangwu.xmpp.im.mvp.view.MvpView;

/**
 * Created by zhuangwu on 2016/7/19.
 */
public abstract class MvpFragment<P extends MvpBasePresenter> extends Fragment implements MvpView {
    protected  P presenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter=bindPresenter();
        if(presenter!=null){
            presenter.attachView(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.detachView();
        }
    }

    public abstract P bindPresenter();
}
