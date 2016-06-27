package com.chatme.chat.controllor;
/**
 * @author VanTsai
 *
 */
import com.chatme.chat.R;
import com.chatme.chat.R.layout;
import com.chatme.chat.mode.QRCode;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class InfoMy extends Activity {
	private RelativeLayout erweeima;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_my); 
        
    }
	
   public void btn_back(View v) {     //标题栏 返回按钮
      	this.finish();
      } 
   public void btn_back_send(View v) {     //标题栏 返回按钮
     	this.finish();
     } 
   public void headMy(View v) {     //头像按钮
	   Intent intent = new Intent();
		intent.setClass(InfoMy.this,InfoMyHead.class);
		startActivity(intent);
    } 
   public void erweeima(View view){
	   Intent intent = new Intent(InfoMy.this,QRCode.class);
	   startActivity(intent);
   }
    
}
