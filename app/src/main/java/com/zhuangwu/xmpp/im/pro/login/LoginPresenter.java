package com.zhuangwu.xmpp.im.pro.login;

import android.content.Context;
import android.support.annotation.NonNull;

import com.zhuangwu.xmpp.im.pro.base.presenter.BasePresenter;

/**
 * Created by zhuangwu on 2016/7/19.
 */
public class LoginPresenter extends BasePresenter<LoginModel>{
    public LoginPresenter(@NonNull Context context) {
        super(context);
    }

    @Override
    public LoginModel bindModel() {
        return new LoginModel(getContext());
    }
    public void login(@NonNull String username,@NonNull String password){
        getModel().login(username,password);
    }

}
