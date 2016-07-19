package com.zhuangwu.xmpp.im.smack.manager;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.zhuangwu.xmpp.im.MainActivity;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;

import java.io.IOException;

/**
 * Created by zhuangwu on 2016/7/19.
 */
public class XmppManager {
    private static final String HOST="192.168.1.101";
    public static final int PORT=5222;
    public static final String SERVICE_NAME="zhuangwu";
    private static XmppManager xmppManager;
    private XMPPTCPConnection connection;


    private XmppManager(){}
    public static synchronized XmppManager getInstance(){
        if(xmppManager==null){
            xmppManager=new XmppManager();
        }
        return xmppManager;
    }
    //获取连接对象
    public XMPPTCPConnection getConnection(){
        if(connection==null){
            openConnection();
        }
        return connection;
    }

    //打开连接
    private void openConnection(){
        XMPPTCPConnectionConfiguration config=XMPPTCPConnectionConfiguration.builder()
                .setHost(HOST).setPort(PORT)
                .setServiceName(SERVICE_NAME).setSecurityMode(ConnectionConfiguration.SecurityMode.disabled).build();
        this.connection=new XMPPTCPConnection(config);
        try {
            this.connection.connect();
        } catch (SmackException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMPPException e) {
            e.printStackTrace();
        }
    }
    public static class LoginTask extends AsyncTask<String,Void,Boolean>{
        private Context context;
        public LoginTask(Context context){
            this.context=context;
        }
        @Override
        protected Boolean doInBackground(String... params) {
            XMPPTCPConnection connection=XmppManager.getInstance().getConnection();
            try {
                connection.login(params[0],params[1]);
                Presence presence=new Presence(Presence.Type.available);
                connection.sendStanza(presence);
            } catch (Exception e) {
                return false;
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            if(result){
                Toast.makeText(context, "登录成功", Toast.LENGTH_SHORT).show();
                context.startActivity(new Intent(context, MainActivity.class));
            }else {
                Toast.makeText(context, "登录失败", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
