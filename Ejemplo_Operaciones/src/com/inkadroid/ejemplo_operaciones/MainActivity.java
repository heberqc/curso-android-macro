package com.inkadroid.ejemplo_operaciones;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	int resultado;
	int n1;
	int n2;
	EditText txtNumero1;
	EditText txtNumero2;
	Button Suma;
	Button Resta;
	Button Multiplicacion;
	Button Division;
	TextView txtResultado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
        txtNumero1 =(EditText) findViewById(R.id.txtNumero1);
        txtNumero2 =(EditText) findViewById(R.id.txtNumero2);
        
        Suma =(Button) findViewById(R.id.Suma);
        Resta =(Button) findViewById(R.id.Resta);
        Multiplicacion =(Button) findViewById(R.id.multiplicacion);
        Division =(Button) findViewById(R.id.division);
         
        txtResultado =(TextView) findViewById(R.id.txtResultado);
       
        Suma.setOnClickListener(this);
        Resta.setOnClickListener(this);
        Multiplicacion.setOnClickListener(this);
        Division.setOnClickListener(this);   

	}

	public void onClick(final View clicked) {
		  switch(clicked.getId()) {

		  case R.id.Suma:
      	  resultado= Integer.parseInt(txtNumero1.getText().toString())+Integer.parseInt(txtNumero2.getText().toString());
      	  txtResultado.setText(String.valueOf(resultado));     	        	  
        break;
		  case R.id.Resta:
      	  resultado= Integer.parseInt(txtNumero1.getText().toString())-Integer.parseInt(txtNumero2.getText().toString());
      	  txtResultado.setText(String.valueOf(resultado));     	        	  
        break; 
		  case R.id.multiplicacion:
      	  resultado= Integer.parseInt(txtNumero1.getText().toString())*Integer.parseInt(txtNumero2.getText().toString());
      	  txtResultado.setText(String.valueOf(resultado));     	        	  
        break;
		  case R.id.division:
      	  resultado= Integer.parseInt(txtNumero1.getText().toString())/Integer.parseInt(txtNumero2.getText().toString());
      	  txtResultado.setText(String.valueOf(resultado));     	        	  
        break;
        
		  		}
			}
  	


}
