package com.example.music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText mAccount;
    private EditText mPassword;
    private Button mLogin;
    private Button mRegister;
    private MyHelper myHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myHelper=new MyHelper(this);
        initView();
        initListener();

    }
    private void initListener() {
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlerLogin();
            }
        });
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlerRegister();
            }
        });
    }
//注册
    private void handlerRegister() {
     Intent i=new Intent(this,RegisterActivity.class);
     startActivity(i);
    }

    //登录
    private void handlerLogin() {
        String name=mAccount.getText().toString().trim();
        if(TextUtils.isEmpty(name)){
            Toast.makeText(this,"输入的账号为空",Toast.LENGTH_SHORT).show();
            return;
        }
        String password=mPassword.getText().toString().trim();
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"输入的密码为空",Toast.LENGTH_SHORT).show();
            return;
        }
        User u=new User(name,password);
        boolean login=myHelper.login(name,password);
        if(login){
//                 显示意图
            Intent intent=new Intent(MainActivity.this,ShouYeActivity.class);
            System.out.println(name);
            intent.putExtra("account",name);
            startActivity(intent);
            System.out.println("okkk");
        }else{
            Toast.makeText(this,"登陆失败",Toast.LENGTH_SHORT).show();
        }
    }

//    注册

    private void initView() {
//        抽取成员变量 ctrl+alt+f
        mAccount = (EditText)this.findViewById(R.id.account);
        mPassword = (EditText)this.findViewById(R.id.password);
        mLogin = (Button)this.findViewById(R.id.login);
        mRegister = findViewById(R.id.register);
    }
    public void register(View view) {

    }



}