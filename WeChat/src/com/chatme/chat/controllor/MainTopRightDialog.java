package com.chatme.chat.controllor;

/**
 * @author VanTsai
 *
 */
import com.chatme.chat.R;
import com.zxing.activity.CaptureActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainTopRightDialog extends Activity {
	//private MyDialog dialog;
	private LinearLayout layout;
	//	private static final int PHOTO_PIC = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_top_right_dialog);
		//dialog=new MyDialog(this);
		//		layout=(LinearLayout)findViewById(R.id.main_dialog_layout);
		//		layout.setOnClickListener(new OnClickListener() {
		//			
		//			@Override
		//			public void onClick(View v) {
		//				// TODO Auto-generated method stub
		//				Toast.makeText(getApplicationContext(), "��ʾ����������ⲿ�رմ��ڣ�", 
		//						Toast.LENGTH_SHORT).show();	
		//			}
		//		});
	}

	@Override
	public boolean onTouchEvent(MotionEvent event){
		finish();
		return true;
	}
	//��������
	public void chat_message(View view){
		Intent intent = new Intent(MainTopRightDialog.this,ChatActivity.class);
		startActivity(intent);
	}
	//ɨһɨ
	public void richScan(View view){
		Intent intent = new Intent(MainTopRightDialog.this,CaptureActivity.class);
//		startActivity(intent);
		startActivityForResult(intent, 0);
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			//��ȡ�ķ��ؽ����������ַ
			String result = data.getExtras().getString("result");
			Toast.makeText(MainTopRightDialog.this, result, 1).show();
		}
	}
}
