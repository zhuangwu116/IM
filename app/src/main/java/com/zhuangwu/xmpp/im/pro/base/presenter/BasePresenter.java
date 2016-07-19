package com.zhuangwu.xmpp.im.pro.base.presenter;

import android.content.Context;

import com.zhuangwu.xmpp.im.mvp.presenter.impl.MvpBasePresenter;
import com.zhuangwu.xmpp.im.pro.base.model.BaseModel;

/**
 * Created by zhuangwu on 2016/7/19.
 */
public abstract class BasePresenter<M extends BaseModel> extends MvpBasePresenter {
    private Context context;
    private M model;
    public BasePresenter(Context context){
        this.context=context;
        this.model=bindModel();
    }
    public Context getContext(){
        return this.context;
    }
    public interface OnUIThreadListener<T>{
        public void onResult(T result);
    }
    public M getModel(){
        return model;
    }
    public abstract M bindModel();
}
