/**
 * 
 */
package com.chatme.chat.mode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.chatme.chat.R;
import com.chatme.chat.controllor.MainChat;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * @author VanTsai
 *
 */
public class PhoneNumber extends Activity {
	private ListView gridView1;
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * 
	 */
	ArrayList<Map<String, Object>> list = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.phone_adapter);
		gridView1= (ListView) findViewById(R.id.gridView);
		Phone phone = new Phone(PhoneNumber.this);
		list = phone.testReadAllContacts();
		SimpleAdapter();
	}
    public void SimpleAdapter(){
    	SimpleAdapter adapter = new SimpleAdapter(this, list,
                R.layout.phone_adapter_item, new String[] {"contactId","name", "phoneNumber", "email" },
                new int[] { R.id.id_number,R.id.name, R.id.number, R.id.emaile });
    	gridView1.setAdapter(adapter);
    	gridView1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				
			}
		});
    	}
}
