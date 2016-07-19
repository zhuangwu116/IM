package com.zhuangwu.xmpp.im.pro.base.model;

import android.content.Context;

import com.zhuangwu.xmpp.im.mvp.model.MvpModel;

/**
 * Created by zhuangwu on 2016/7/19.
 */
public abstract class BaseModel implements MvpModel{
    private Context context;
    public BaseModel(Context context){
        this.context=context;
    }
}
