/**
 * 
 */
package com.chatme.chat.mode;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.widget.SimpleAdapter;

/**
 * @author VanTsai
 *
 */
public class SimpleAdapterPhone extends SimpleAdapter {

	/**
	 * @param context
	 * @param data
	 * @param resource
	 * @param from
	 * @param to
	 */
	public SimpleAdapterPhone(Context context,
			List<? extends Map<String, ?>> data, int resource, String[] from,
			int[] to) {
		super(context, data, resource, from, to);
		
	}

}
