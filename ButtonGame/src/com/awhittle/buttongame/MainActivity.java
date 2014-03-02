package com.awhittle.buttongame;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.app.Activity;
import android.content.SharedPreferences;

public class MainActivity extends Activity {

	public static final String PREFS_NAME = "MyCounter";
	int counter = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
	    counter = settings.getInt("Counter", 0);
	    displayNum();
	}


	private void displayNum(){
		
		TextView tv = (TextView)findViewById(R.id.textView1);
		tv.setText(Integer.toString(counter));
	}
	
	public void buttonPress(View v){
		counter++;
		
		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putInt("Counter", counter);
		editor.commit();
		
		displayNum();
	}

}
