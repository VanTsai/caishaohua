package com.chatme.chat.controllor;
/**
 * @author VanTsai
 *
 */
import com.chatme.chat.R;
import com.chatme.chat.R.layout;

import android.app.Activity;
import android.os.Bundle;

public class Person extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_person);
	}
}
