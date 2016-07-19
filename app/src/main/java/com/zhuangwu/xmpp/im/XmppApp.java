package com.zhuangwu.xmpp.im;

import android.app.Application;
import android.content.Intent;

import com.zhuangwu.xmpp.im.service.XmppService;

/**
 * Created by zhuangwu on 2016/7/19.
 */
public class XmppApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Intent mIntent=new Intent(this, XmppService.class);
        mIntent.setAction("connect-all");
        startService(mIntent);
    }
}
