package com.bgstation0.android.sample.activity_;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

// MainActivityによって起動されるSubActivity.
public class SubActivity extends Activity {	// SubActivityの定義.

	// Activityが生成されたとき.
	@Override
    protected void onCreate(Bundle savedInstanceState) {	// onCreateの定義
		super.onCreate(savedInstanceState);
		
		// "SubActivity!"の表示.
		TextView tv = new TextView(this);	// TextViewオブジェクトtvの生成.
		tv.setText("SubActivity!");	// tv.setTextで"SubActivity!"のセット.
		setContentView(tv);	// setContentViewでtvを表示.
	}	
}
