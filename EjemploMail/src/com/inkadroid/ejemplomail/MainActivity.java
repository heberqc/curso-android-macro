package com.inkadroid.ejemplomail;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity  implements OnClickListener  {
	private Button envio;
	private EditText destino;
	private EditText asunto;
	private EditText mensaje;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.envio = (Button) findViewById(R.id.envio);
		this.destino = (EditText) findViewById(R.id.destino);
		this.asunto = (EditText) findViewById(R.id.asunto);
		this.mensaje = (EditText) findViewById(R.id.mensaje);
		envio.setOnClickListener(this); 
	 }
				
		 public void onClick(final View clicked)  {
				
			 Intent i = new Intent(android.content.Intent.ACTION_SEND);
				i.setType("plain/text");
				i.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{destino.getText().toString()});
				i.putExtra(android.content.Intent.EXTRA_SUBJECT, asunto.getText().toString());
				i.putExtra(android.content.Intent.EXTRA_TEXT, mensaje.getText().toString());
				startActivity(i);		 
			}
}
