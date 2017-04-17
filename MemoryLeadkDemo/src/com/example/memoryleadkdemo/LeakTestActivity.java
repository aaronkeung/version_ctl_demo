package com.example.memoryleadkdemo;

import android.app.Activity;
import android.os.Bundle;

public class LeakTestActivity extends Activity {

	@Override
	protected void onStart() {
		System.out.println("LeakTestActivity onStart");
		super.onStart();
	}

	@Override
	protected void onDestroy() {
		System.out.println("LeakTestActivity onDestroy");
		super.onDestroy();
	}

	static Leaky leak = null;

	class Leaky {
		void doSomething() {
			System.out.println("Wheee!!!");
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.out.println("Look at me, I am leak :" + Leaky.class);
		setContentView(R.layout.activity_test_demo);
		if (leak == null) {
			leak = new Leaky();
			leak.doSomething();
		}
	}
	//Add some comnent here.
}
