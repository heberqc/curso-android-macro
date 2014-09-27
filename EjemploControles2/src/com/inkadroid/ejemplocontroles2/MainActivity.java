package com.inkadroid.ejemplocontroles2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	

// Boton Ingresar
	Button BtnIng = (Button) findViewById(R.id.BtnIng);
	
	BtnIng.setOnClickListener(new View.OnClickListener(){
	public void onClick(View v)
	{  
	 Toast.makeText(getBaseContext(),"Comprobando Credenciales",Toast.LENGTH_SHORT).show();
	}
	});
	
	// Boton Cancelar
		Button BtnCan = (Button) findViewById(R.id.BtnCan);
		
		
		BtnCan.setOnClickListener(new View.OnClickListener(){
		public void onClick(View v)
		{  
		 Toast.makeText(getBaseContext(),"Comprobando Credenciales",Toast.LENGTH_SHORT).show();
		}
		});	
			
	}
}
