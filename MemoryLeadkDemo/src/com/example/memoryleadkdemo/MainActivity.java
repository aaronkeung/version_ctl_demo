package com.example.memoryleadkdemo;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button mTestBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mTestBtn = (Button)findViewById(R.id.button1);
		mTestBtn.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, LeakTestActivity.class);
				startActivity(intent);		
			}
		});
		
		ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
		
		TextView textView = (TextView)findViewById(R.id.textView1);
		textView.setText("Current memory size: " + activityManager.getMemoryClass()+"");
	}	
}
