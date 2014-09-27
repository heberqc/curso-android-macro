package com.nolascov.EjemploAlimentos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class EjemploAlimentosActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

       
    }  
    @Override
    public boolean onCreateOptionsMenu(Menu menu)  { 
	super.onCreateOptionsMenu(menu);
	CrearMenu(menu); 
	return true;
    } 
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    return SeleccionOpcion(item);
    }
    private void CrearMenu(Menu menu) {
	MenuItem Opcion1 = menu.add(0, 0, 0, "Arroz"); 
	{
	Opcion1.setAlphabeticShortcut('a'); 
	Opcion1.setIcon(R.drawable.ic_launcher);
	Opcion1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT); 		
	}	
	MenuItem Opcion2 = menu.add(0, 1, 1, "Brocoli"); 
	{
	Opcion2.setAlphabeticShortcut('b'); 
	Opcion2.setIcon(R.drawable.ic_launcher);
	}	
	MenuItem Opcion3 = menu.add(0, 2, 2,   "Limon");
	{
	Opcion3.setAlphabeticShortcut('с'); 
	//Opcion3.setIcon(R.drawable.limon);
	}
	MenuItem Opcion4 = menu.add(0, 3, 3, "Manzana");
	{
	Opcion4.setAlphabeticShortcut('d');
	Opcion4.setIcon(R.drawable.ic_launcher);
	}
								}
    private boolean SeleccionOpcion(MenuItem item)
	{
	switch (item.getItemId())  
	{ 
	case android.R.id.home:
	Toast.makeText(this,  "Presione Clic en el icono",Toast.LENGTH_LONG).show(); 
	Intent i = new Intent(this, EjemploAlimentosActivity.class); 
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
startActivity(i); 
	return true;
	case 0:
        Toast.makeText(this,  "Seleccionastes Arroz",Toast.LENGTH_LONG).show(); 
        return true;
	case 1:
	Toast.makeText(this,  "Seleccionastes Brocoli",Toast.LENGTH_LONG).show(); 
	return true;
	case 2:
	Toast.makeText(this,  "Seleccionastes Limon",Toast.LENGTH_LONG).show();
	return true;
	case 3:
	Toast.makeText(this,  "Seleccionastes Manzana",Toast.LENGTH_LONG).show();
	return true;
	}
	return false;
	}   
}
