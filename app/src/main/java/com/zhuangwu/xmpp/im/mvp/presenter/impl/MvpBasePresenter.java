package com.zhuangwu.xmpp.im.mvp.presenter.impl;

import com.zhuangwu.xmpp.im.mvp.presenter.MvpPresenter;
import com.zhuangwu.xmpp.im.mvp.view.MvpView;

/**
 * Created by zhuangwu on 2016/7/19.
 */
public class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V> {
    private V view;
    @Override
    public void attachView(V view) {
        this.view=view;
    }

    @Override
    public void detachView() {
        if(view!=null){
            view=null;
        }
    }
}
