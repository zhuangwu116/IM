package com.zhuangwu.xmpp.im.pro.login;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.zhuangwu.xmpp.im.R;
import com.zhuangwu.xmpp.im.mvp.presenter.impl.MvpBasePresenter;
import com.zhuangwu.xmpp.im.pro.base.view.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity {
    @Bind(R.id.et_phone)
    EditText et_phone;
    @Bind(R.id.et_password)
    EditText et_password;
    @Bind(R.id.bt_login)
    Button bt_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        ButterKnife.bind(this);
    }

    @Override
    public MvpBasePresenter bindPresenter() {
        return null;
    }

}
