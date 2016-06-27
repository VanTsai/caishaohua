/**
 * 
 */
package com.chatme.chat.mode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

/**
 * @author VanTsai
 *
 */
public class Phone {
	ArrayList<Map<String, Object>> list = null;
	Context context;
	public Phone(Context context){
		this.context = context;
	}
	/*
     * 读取联系人的信息
     */
    public ArrayList<Map<String, Object>> testReadAllContacts() {
    	list = new ArrayList<Map<String,Object>>();
        Cursor cursor = context.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, 
                 null, null, null, null);
        int contactIdIndex = 0;
        int nameIndex = 0;
        
        if(cursor.getCount() > 0) {
            contactIdIndex = cursor.getColumnIndex(ContactsContract.Contacts._ID);
            nameIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
        }
        while(cursor.moveToNext()) {
        	Map<String,Object> map = new HashMap<String, Object>();
            String contactId = cursor.getString(contactIdIndex);
            String name = cursor.getString(nameIndex);
//            System.out.println("contactId+name:"+contactId+name);
            map.put("contactId", contactId);
        	map.put("name", name);
            /*
             * 查找该联系人的phone信息
             */
            Cursor phones = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, 
                    null, 
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + contactId, 
                    null, null);
            int phoneIndex = 0;
            if(phones.getCount() > 0) {
                phoneIndex = phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            }
//            if (phones.getString(phoneIndex)==null)break;
            while(phones.moveToNext()) {
                String phoneNumber = phones.getString(phoneIndex);
                map.put("phoneNumber", phoneNumber);
//                System.out.println("phoneNumber"+phoneNumber);
            }
            
            /*
             * 查找该联系人的email信息
             */
            Cursor emails = context.getContentResolver().query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, 
                    null, 
                    ContactsContract.CommonDataKinds.Email.CONTACT_ID + "=" + contactId, 
                    null, null);
            int emailIndex = 0;
            if(emails.getCount() > 0) {
                emailIndex = emails.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA);
            }
            while(emails.moveToNext()) {
                String email = emails.getString(emailIndex);
                map.put("email", email);
            }
            list.add(map);
        }

    return list;
    }

}
