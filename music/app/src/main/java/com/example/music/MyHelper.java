package com.example.music;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLOutput;

/*
上下文，
数据库名称，
SQLiteDatabase.CursorFactory factory游标工厂，
version版本号
 */
public class MyHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="MYsqlite.db";
    private static final String create_users="create table user(name char(32),password varchar(32))";
    public MyHelper(Context context) {
        super(context,DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_users);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
//    实现注册功能
    public long register(User u){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",u.getName().toString());
        cv.put("password",u.getPassword().toString());
        long users=db.insert("user",null,cv);
        System.out.println("ok");
        System.out.println(users);
        db.close();
        return users;
    }
//    实现登录功能
    public boolean login(String name, String password){
        SQLiteDatabase db1=getWritableDatabase();
        boolean result=false;
        Cursor users=db1.query("user",null,"name like?",new String[]{name},
                null,null,null);
        if (users!=null){
            while (users.moveToNext()){
                String password1=users.getString(1);
                result=password1.equals(password);
                return result;
            }
        }
        return false;
    }
}
