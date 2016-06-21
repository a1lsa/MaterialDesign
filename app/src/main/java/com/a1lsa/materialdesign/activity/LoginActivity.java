package com.a1lsa.materialdesign.activity;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.yyz.materialdesign.R;

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private EditText mEtName,mEtPwd;
    private TextInputLayout mTextInput1,mTextInput2;
    private Button mBtnLogin;


    @Override
    public int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        mEtName= (EditText) findViewById(R.id.edit_name);
        mEtPwd= (EditText) findViewById(R.id.edit_password);
        mTextInput1= (TextInputLayout) findViewById(R.id.textInputLayout1);
        mTextInput2= (TextInputLayout) findViewById(R.id.textInputLayout2);
        mBtnLogin= (Button) findViewById(R.id.btn_login);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {
        mBtnLogin.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
