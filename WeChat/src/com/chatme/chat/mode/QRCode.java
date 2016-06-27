package com.chatme.chat.mode;
/**
 * @author VanTsai
 *
 */
import com.chatme.chat.R;
import com.google.zxing.WriterException;
import com.zxing.encoding.EncodingHandler;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class QRCode extends Activity {
	//���ɶ�ά���·��
	private String pathCode="http://baidu.com";
	private ImageView iv_code;
	private TextView tv_pathcode;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_dialog_code);
		iv_code = (ImageView) findViewById(R.id.iv_code);
		tv_pathcode = (TextView) findViewById(R.id.tv_pathcode);
		QRcode();
	}
	private void QRcode(){
		try {
			//����λͼ��EncodingHandler����һ��ͼƬ
			Bitmap qrcode = EncodingHandler.createQRCode(pathCode, 400);
			tv_pathcode.setText("��ά��·��:"+pathCode);
			iv_code.setImageBitmap(qrcode);
		} catch (WriterException e) {
			e.printStackTrace();
			Toast.makeText(QRCode.this, "��ά�����ɴ�������������", 1).show();
		} 
	}
}
