package com.zhuangwu.xmpp.im.mvp.presenter;

import com.zhuangwu.xmpp.im.mvp.view.MvpView;

/**
 * Created by zhuangwu on 2016/7/19.
 */
public interface MvpPresenter<V extends MvpView> {
    //绑定View
    public void attachView(V view);
    //解除绑定View
    public void detachView();
}
