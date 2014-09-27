package com.inkadroid.ejemplosms2;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;



public class MainActivity extends Activity {  

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}


	 public void Mensaje(View v) {
		 
		   String telefono = ((EditText) findViewById(R.id.txtNumero)).getText().toString();  
		String asunto  = ((EditText) findViewById(R.id.txtMensaje)).getText().toString();  	 
	        
			SmsManager sms = SmsManager.getDefault();
	        
			sms.sendTextMessage(telefono, null,asunto, null, null);
	                
	    }

}

