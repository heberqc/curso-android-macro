package com.nolascov.Tutorial4;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class Form extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
   
    public void onCancelarClick(View botton)   { 
    	Intent intent = new Intent();
    intent.setComponent(new ComponentName(this,Form2.class));
    intent.putExtra("Cancel","Cancel");
    startActivity(intent);
    } 
    
    public void onAgregarClick(View botton)   {
    	EditText xnombre =  (EditText)   findViewById(R.id.nombre); 
    	EditText xdireccion =  (EditText)  findViewById(R.id.direccion); 
    	EditText xtelefono =  (EditText)   findViewById(R.id.telefono);

    	Intent intent = new Intent(); 
    	intent.setClass(this,Form2.class);

    	intent.putExtra("nombre", xnombre.getText().toString());
    	intent.putExtra("direccion",xdireccion.getText().toString());
    	intent.putExtra("telefono",xtelefono.getText().toString());
    	startActivity(intent);
    }        
}


