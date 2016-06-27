package com.chatme.chat.controllor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.chatme.chat.R;
import com.chatme.chat.R.id;
import com.chatme.chat.R.layout;
import com.chatme.chat.method.ChatMsgEntity;
import com.chatme.chat.method.ChatMsgViewAdapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * @author VanTsai
 *
 */
public class ChatActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */

	private Button mBtnSend;
	private Button mBtnBack;
	private EditText mEditTextContent;
	private ListView mListView;
	private ChatMsgViewAdapter mAdapter;
	private List<ChatMsgEntity> mDataArrays = new ArrayList<ChatMsgEntity>();
	
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_me);
        //启动activity时不自动弹出软键盘
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN); 
        initView(); 
        initData();
    }
    
    
    public void initView()
    {
    	mListView = (ListView) findViewById(R.id.listview);
    	mBtnSend = (Button) findViewById(R.id.btn_send);
    	mBtnSend.setOnClickListener(this);
    	mBtnBack = (Button) findViewById(R.id.btn_back);
    	mBtnBack.setOnClickListener(this);
    	
    	mEditTextContent = (EditText) findViewById(R.id.et_sendmessage);
    }
    
    private String[]msgArray = new String[]{"是妹子？", "是，你是汉子？", "我也是", "真巧哦", 
    										"那我们在一起如何啊", "可以啊，你是哪里的人，我们可能是老乡哦",
    										"达州人", "尼滚....",};
    
    private String[]dataArray = new String[]{"2016-05-12 18:00", "2016-05-12 18:10", 
    										"2016-05-12 18:11", "2016-05-12 18:20", 
    										"2016-05-12 18:30", "2016-05-12 18:35", 
    										"2016-05-12 18:40", "2016-05-12 18:50"}; 
    private final static int COUNT = 8;
    public void initData()
    {
    	for(int i = 0; i < COUNT; i++)
    	{
    		ChatMsgEntity entity = new ChatMsgEntity();
    		entity.setDate(dataArray[i]);
    		if (i % 2 == 0)
    		{
    			entity.setName("王五");
    			entity.setMsgType(true);
    		}else{
    			entity.setName("李四");
    			entity.setMsgType(false);
    		}
    		
    		entity.setText(msgArray[i]);
    		mDataArrays.add(entity);
    	}

    	mAdapter = new ChatMsgViewAdapter(this, mDataArrays);
		mListView.setAdapter(mAdapter);
		
    }


	@Override
	public void onClick(View v) {
		if (v.getId()==R.id.btn_send) {
			send();
		}else if (v.getId()==R.id.btn_back) {
			finish();
		}
	}
	
	private void send()
	{
		String contString = mEditTextContent.getText().toString();
		if (contString.length() > 0)
		{
			ChatMsgEntity entity = new ChatMsgEntity();
			entity.setDate(getDate());
			entity.setName("VanTsai");
			entity.setMsgType(false);
			entity.setText(contString);
			
			mDataArrays.add(entity);
			mAdapter.notifyDataSetChanged();
			
			mEditTextContent.setText("");
			
			mListView.setSelection(mListView.getCount() - 1);
		}
	}
	
    private String getDate() {
        Calendar c = Calendar.getInstance();

        String year = String.valueOf(c.get(Calendar.YEAR));
        String month = String.valueOf(c.get(Calendar.MONTH));
        String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH) + 1);
        String hour = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
        String mins = String.valueOf(c.get(Calendar.MINUTE));
        
        
        StringBuffer sbBuffer = new StringBuffer();
        sbBuffer.append(year + "-" + month + "-" + day + " " + hour + ":" + mins); 
        						
        						
        return sbBuffer.toString();
    }
    
    
    public void headMy(View v) {     //标题栏 返回按钮
    	Intent intent = new Intent (ChatActivity.this,InfoMy.class);			
		startActivity(intent);	
      } 
    //自己的头像进入自己的界面
    public void headFriend(View view){
    	Intent intent = new Intent(ChatActivity.this,InfoFriend.class);
    	startActivity(intent);
    }
}