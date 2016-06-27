/**
 * 
 */
package com.chatme.chat.controllor;

import com.chatme.chat.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * @author VanTsai
 *
 */
public class Regist extends Activity{
	private EditText mUser; // ÕÊºÅ±à¼­¿ò
	private EditText mPassword; // ÃÜÂë±à¼­¿ò
	private Button login_login_btn;
	private EditText login_repasswd_edit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.regist);
		mUser = (EditText)findViewById(R.id.login_user_edit);
        mPassword = (EditText)findViewById(R.id.login_passwd_edit);
        login_login_btn = (Button) findViewById(R.id.login_login_btn);
        login_repasswd_edit = (EditText) findViewById(R.id.login_repasswd_edit);
        
	}

}
