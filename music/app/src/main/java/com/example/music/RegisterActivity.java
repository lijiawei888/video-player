package com.example.music;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//import androidx.annotation.Nullable;

public class RegisterActivity extends AppCompatActivity {
    private EditText usernameInput;
    private EditText passwordInput;
    private EditText confirmPasswordInput;
    private Button registerButton;
    private MyHelper myHelper1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        //onClick();
    }

    public void aaa(View view) {
//                SQLiteDatabase db;
//                ContentValues values;
        // 这里添加实际的注册逻辑（如验证输入、向服务器发送请求等）
        String username = usernameInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();
        String confirmPassword = confirmPasswordInput.getText().toString().trim();
        if (validateInputs(username, password, confirmPassword)) {
            User u=new User(username,password);
            long register=myHelper1.register(u);
            if(register!=-1){
                Toast.makeText(RegisterActivity.this, "注册成功!", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(i);
            }
        }else{
            Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
        }
    }


    private void initView() {

        usernameInput = (EditText)findViewById(R.id.username_input);
        passwordInput = (EditText)findViewById(R.id.password_input);
        confirmPasswordInput = (EditText)findViewById(R.id.confirm_password_input);
        registerButton = (Button)findViewById(R.id.register_button);
        myHelper1 = new MyHelper(this);
//        registerButton.setOnClickListener((View.OnClickListener) this);
    }

    private boolean validateInputs(String username, String password, String confirmPassword) {
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() ) {
//            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
