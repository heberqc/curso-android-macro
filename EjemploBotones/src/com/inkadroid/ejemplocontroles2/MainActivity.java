package com.inkadroid.ejemplocontroles2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

	EditText editElejido;
	Button btnAndroid,btnIphone,btnRim,btnSymbian,btnWindow;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editElejido = (EditText) findViewById(R.id.editElejido);
        btnAndroid  =  (Button) findViewById(R.id.btnAndroid);
        btnAndroid.setOnClickListener(this);
        btnIphone  =  (Button) findViewById(R.id.btnIphone);
        btnIphone.setOnClickListener(this);     
        btnRim  =  (Button) findViewById(R.id.btnRim);
        btnRim.setOnClickListener(this);     
        btnSymbian  =  (Button) findViewById(R.id.btnSymbian);
        btnSymbian.setOnClickListener(this);     
        btnWindow  =  (Button) findViewById(R.id.btnWindow);
        btnWindow.setOnClickListener(this);     
    }
    
   
    public void onClick(final View clicked)  {
		switch (clicked.getId()) {
		case R.id.btnAndroid:
			editElejido.setText("Sistema Operativo Android Google");
			break;
		case R.id.btnIphone:
			editElejido.setText("Sistema Operativo Iphone");
			break;
		case R.id.btnRim:
			editElejido.setText("Sistema Operativo Rim");
			break;
		case R.id.btnSymbian:
			editElejido.setText("Sistema Operativo Symbian");
			break;
		case R.id.btnWindow:
			editElejido.setText("Sistema Operativo Windows Mobile");
			break;
		}
	}
	
}
