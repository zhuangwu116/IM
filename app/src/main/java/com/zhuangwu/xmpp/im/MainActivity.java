package com.zhuangwu.xmpp.im;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.text.TextUtils;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.zhuangwu.xmpp.im.service.XmppService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,TabHost.OnTabChangeListener {
    private XMPPServiceConnection mServiceConnection = new XMPPServiceConnection();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private List<TabItem> tabItemList=new ArrayList<TabItem>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initTabHost();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Intent service = new Intent(getApplicationContext(), XmppService.class);
        bindService(service, mServiceConnection, 0);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.zhuangwu.xmpp.im/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.zhuangwu.xmpp.im/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        unbindService(mServiceConnection);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.disconnect();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onTabChanged(String tabId) {
        for(int i=0;i<tabItemList.size();i++){
            TabItem tabItem=tabItemList.get(i);
            if(tabId.equals(tabItem.getTitleString())){
                tabItem.setChecked(true);
            }else{
                tabItem.setChecked(false);
            }
        }
    }
    //初始化主页菜单选项
    private void initTabHost() {
        //获取FragmentTabHost
        FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        //绑定TabHost(绑定我们的body）
        fragmentTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        //去掉分割线
        fragmentTabHost.getTabWidget().setDividerDrawable(null);
        for (int i = 0; i < tabItemList.size(); i++) {
            TabItem tabItem = tabItemList.get(i);
            //绑定Fragment（将Fragment添加到FragmentTabHost组建上面)
            //newTabSpec 代表Tab名字
            //setIndicator:图片（采用布局文件--Tab样式我们自己定义）
            TabHost.TabSpec tabSpec=fragmentTabHost.newTabSpec(tabItem.getTitleString())
                    .setIndicator(tabItem.getView());
            //添加Fragment
            fragmentTabHost.addTab(tabSpec,tabItem.getFragmentClass(),tabItem.getBundle());
            //给我们的Tab按钮设置背景
            fragmentTabHost.getTabWidget().getChildAt(i)
                    .setBackgroundColor(getColor(R.color.main_bottom_bg));
            fragmentTabHost.setOnTabChangedListener(this);
            //默认选中第一个
            if(i==0){
                tabItem.setChecked(true);
            }
        }

    }
    private void initTabData() {

    }


    public static class XMPPServiceConnection implements ServiceConnection {
        private XmppService mService;

        public XMPPServiceConnection() {
        }

        public XmppService getmService() {
            return mService;
        }

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder service) {
            XmppService.LocalBinder binder = (XmppService.LocalBinder) service;
            mService = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mService = null;
        }
    }


    class TabItem {
        private int imageNormal;
        private int imagePress;
        private int title;
        private String titleString;
        private View view;
        private ImageView imageView;
        private TextView textView;
        private Bundle bundle;
        private Class<? extends Fragment> fragmentClass;

        public TabItem(@DrawableRes int imageNormal, @DrawableRes int imagePress, @StringRes int title, @NonNull Class<? extends Fragment> fragmentClass) {
            this.imageNormal = imageNormal;
            this.imagePress = imagePress;
            this.title = title;
            this.fragmentClass = fragmentClass;
        }

        public Bundle getBundle() {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("title", titleString);
            return bundle;
        }

        public int getImageNormal() {
            return imageNormal;
        }

        public int getImagePress() {
            return imagePress;
        }

        public int getTitle() {
            return title;
        }

        public void setChecked(boolean isChecked) {
            if (imageView != null) {
                if (isChecked) {
                    imageView.setImageResource(imagePress);
                } else {
                    imageView.setImageResource(imageNormal);
                }
                if (textView != null && title != 0) {
                    if (isChecked) {
                        textView.setTextColor(getColor(R.color.main_bottom_text_select));
                    } else {
                        textView.setTextColor(getColor(R.color.main_bottom_text_normal));
                    }
                }
            }
        }

        public String getTitleString() {
            if (title == 0) {
                return "";
            }
            if (TextUtils.isEmpty(titleString)) {
                titleString = getString(title);
            }
            return titleString;
        }

        public View getView() {
            if (this.view == null) {
                this.view = getLayoutInflater().inflate(R.layout.main_activity_tabhost_item_layout, null);
                this.imageView = (ImageView) this.view.findViewById(R.id.tab_iv_image);
                this.textView = (TextView) this.view.findViewById(R.id.tab_tv_text);
                if (this.title == 0) {
                    this.textView.setVisibility(View.GONE);
                } else {
                    this.textView.setVisibility(View.VISIBLE);
                    this.textView.setText(title);
                }
                this.imageView.setImageResource(imageNormal);
            }
            return view;
        }

        public Class<? extends Fragment> getFragmentClass() {
            return fragmentClass;
        }
    }

}
