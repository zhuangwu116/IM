package com.zhuangwu.xmpp.im.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class XmppService extends Service {
    public XmppService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public class LocalBinder extends Binder{
        public XmppService getService(){
            return XmppService.this;
        }
    }
}
