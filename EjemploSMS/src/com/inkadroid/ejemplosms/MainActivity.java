package com.inkadroid.ejemplosms;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}


	 public void Mensaje(View v) {
	        SmsManager sms = SmsManager.getDefault();
	        sms.sendTextMessage("51999999999", null,"Hola", null, null);

	        
	    }

}
