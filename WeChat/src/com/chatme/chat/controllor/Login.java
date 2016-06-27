package com.chatme.chat.controllor;
/**
 * @author VanTsai
 *
 */
import com.chatme.chat.R;
import com.chatme.chat.R.drawable;
import com.chatme.chat.R.id;
import com.chatme.chat.R.layout;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Login extends Activity {
	private EditText mUser; // 帐号编辑框
	private EditText mPassword; // 密码编辑框
	private ImageView login_touxiang;//头像

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        mUser = (EditText)findViewById(R.id.login_user_edit);
        mPassword = (EditText)findViewById(R.id.login_passwd_edit);
        login_touxiang = (ImageView) findViewById(R.id.login_touxiang);
        
    }

    public void login_mainweixin(View v) {
    	if("123456".equals(mUser.getText().toString()) && "123".equals(mPassword.getText().toString()))   //判断 帐号和密码
        {
             Intent intent = new Intent();
             intent.setClass(Login.this,LoadingActivity.class);
             startActivity(intent);
             //Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
          }
        else if("".equals(mUser.getText().toString()) || "".equals(mPassword.getText().toString()))   //判断 帐号和密码
        {
        	new AlertDialog.Builder(Login.this)
			.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
			.setTitle("登录错误")
			.setMessage("微信帐号或者密码不能为空，\n请输入后再登录！")
			.create().show();
         }
        else{
           
        	new AlertDialog.Builder(Login.this)
			.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
			.setTitle("登录失败")
			.setMessage("微信帐号或者密码不正确，\n请检查后重新输入！")
			.create().show();
        }
    	
    	//登录按钮
    	/*
      	Intent intent = new Intent();
		intent.setClass(Login.this,Whatsnew.class);
		startActivity(intent);
		Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
		this.finish();*/
      }  
    public void login_back(View v) {     //标题栏 返回按钮
      	this.finish();
      }  
    public void login_pw(View v) {     //忘记密码按钮
    	Uri uri = Uri.parse("https://3g.qq.com"); 
    	Intent intent = new Intent(Intent.ACTION_VIEW, uri); 
    	startActivity(intent);
    	//Intent intent = new Intent();
    	//intent.setClass(Login.this,Whatsnew.class);
        //startActivity(intent);
      }  
    public void iv_login_touxiang(View view){
    	Toast toast = Toast.makeText(Login.this,"个人信息类表",Toast.LENGTH_LONG);
    	toast.show();
    	Intent intent = new Intent(Login.this,Person.class);
    	startActivity(intent);
    	
    }
}
