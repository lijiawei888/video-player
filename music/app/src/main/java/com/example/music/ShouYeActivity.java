package com.example.music;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShouYeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private Button exit;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shouye);
        initView();
    }
    //    点击事件

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                Intent i=new Intent(this,FarmActivity.class);
                startActivity(i);
                break;
            case R.id.btn2:
                Intent t=new Intent(this,VideoPlayerActivity.class);
                startActivity(t);
                break;
            case  R.id.btn3:
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
        }

    }

    private void initView() {
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        exit = (Button)findViewById(R.id.btn3);
        tv = (TextView)findViewById(R.id.tv);
        Intent c=getIntent();
        String user=c.getStringExtra("account");
        tv.setText("欢迎："+user);
        System.out.println("已经登陆成功");
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        exit.setOnClickListener(this);
        System.out.println("已经完成监听");
    }
}
