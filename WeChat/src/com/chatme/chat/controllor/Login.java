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
	private EditText mUser; // �ʺű༭��
	private EditText mPassword; // ����༭��
	private ImageView login_touxiang;//ͷ��

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        mUser = (EditText)findViewById(R.id.login_user_edit);
        mPassword = (EditText)findViewById(R.id.login_passwd_edit);
        login_touxiang = (ImageView) findViewById(R.id.login_touxiang);
        
    }

    public void login_mainweixin(View v) {
    	if("123456".equals(mUser.getText().toString()) && "123".equals(mPassword.getText().toString()))   //�ж� �ʺź�����
        {
             Intent intent = new Intent();
             intent.setClass(Login.this,LoadingActivity.class);
             startActivity(intent);
             //Toast.makeText(getApplicationContext(), "��¼�ɹ�", Toast.LENGTH_SHORT).show();
          }
        else if("".equals(mUser.getText().toString()) || "".equals(mPassword.getText().toString()))   //�ж� �ʺź�����
        {
        	new AlertDialog.Builder(Login.this)
			.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
			.setTitle("��¼����")
			.setMessage("΢���ʺŻ������벻��Ϊ�գ�\n��������ٵ�¼��")
			.create().show();
         }
        else{
           
        	new AlertDialog.Builder(Login.this)
			.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
			.setTitle("��¼ʧ��")
			.setMessage("΢���ʺŻ������벻��ȷ��\n������������룡")
			.create().show();
        }
    	
    	//��¼��ť
    	/*
      	Intent intent = new Intent();
		intent.setClass(Login.this,Whatsnew.class);
		startActivity(intent);
		Toast.makeText(getApplicationContext(), "��¼�ɹ�", Toast.LENGTH_SHORT).show();
		this.finish();*/
      }  
    public void login_back(View v) {     //������ ���ذ�ť
      	this.finish();
      }  
    public void login_pw(View v) {     //�������밴ť
    	Uri uri = Uri.parse("https://3g.qq.com"); 
    	Intent intent = new Intent(Intent.ACTION_VIEW, uri); 
    	startActivity(intent);
    	//Intent intent = new Intent();
    	//intent.setClass(Login.this,Whatsnew.class);
        //startActivity(intent);
      }  
    public void iv_login_touxiang(View view){
    	Toast toast = Toast.makeText(Login.this,"������Ϣ���",Toast.LENGTH_LONG);
    	toast.show();
    	Intent intent = new Intent(Login.this,Person.class);
    	startActivity(intent);
    	
    }
}
