package com.zhuangwu.xmpp.im.pro.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhuangwu.xmpp.im.mvp.presenter.impl.MvpBasePresenter;
import com.zhuangwu.xmpp.im.mvp.view.impl.MvpFragment;

/**
 * Created by zhuangwu on 2016/7/19.
 */
public abstract class BaseFragment<P extends MvpBasePresenter> extends MvpFragment<P>{
    //缓存视图
    private View viewContent;
    private boolean isInit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(viewContent==null){
            viewContent=inflater.inflate(getContextView(),container,false);
            initContentView(viewContent);
        }
        //判断Fragment对应的Activity是否存在这个视图
        ViewGroup parent=(ViewGroup)viewContent.getParent();
        if(parent!=null){
            parent.removeView(viewContent);
        }
        return viewContent;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(!isInit){
            this.isInit=true;
            initData();
        }
    }

    protected void initData() {
    }

    @Override
    public P bindPresenter() {
        return null;
    }

    protected abstract void initContentView(View viewContent);


    protected abstract int getContextView();
}
