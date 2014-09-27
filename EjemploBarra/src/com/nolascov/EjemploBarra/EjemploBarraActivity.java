package com.nolascov.EjemploBarra;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class EjemploBarraActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        //ActionBar actionBar = getActionBar();
 
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
        CreateMenu(menu);
         return true;
    }
 
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {    
         return MenuChoice(item);    
    }    
    
    
    private void CreateMenu(Menu menu)
    {
        MenuItem mnu1 = menu.add(0, 0, 0, "Opcion 1" );
        {
            mnu1.setAlphabeticShortcut('a');
            mnu1.setIcon(R.drawable.ic_launcher);            
        }
        MenuItem mnu2 = menu.add(0, 1, 1, "Opcion 2" );
        {
            mnu2.setAlphabeticShortcut('b' );
            mnu2.setIcon(R.drawable.ic_launcher);            
        }
        MenuItem mnu3 = menu.add(0, 2, 2, "Opcion 3" );
        {
            mnu3.setAlphabeticShortcut('c' );
            mnu3.setIcon(R.drawable.ic_launcher);
        }
        MenuItem mnu4 = menu.add(0, 3, 3, "Opcion 4" );
        {
            mnu4.setAlphabeticShortcut('d');             
        }
        MenuItem mnu5 = menu.add(0, 4, 4, "Opcion 5" );
        {
            mnu4.setAlphabeticShortcut('d');             
        }
        MenuItem mnu6 = menu.add(0, 5, 5, "Opcion 6" );
        {
            mnu4.setAlphabeticShortcut('d');             
        }
        MenuItem mnu7 = menu.add(0, 6, 6, "Opcion 7" );
        {
            mnu4.setAlphabeticShortcut('d');             
        }
        
        
    }
 
    
    
    
    private boolean MenuChoice(MenuItem item)
    {        
         switch (item.getItemId()) {
         case 0:
            Toast.makeText (this, "Seleccionastes la opcion 1" , 
                Toast.LENGTH_LONG).show();
            return true;
         case 1:
            Toast.makeText (this, "Seleccionastes la opcion 2" , 
                Toast.LENGTH_LONG).show();
            return true;
         case 2:
            Toast.makeText (this, "Seleccionastes la opcion 3" , 
                Toast.LENGTH_LONG).show();
            return true;
         case 3:
            Toast.makeText (this, "Seleccionastes la opcion 4" , 
                Toast.LENGTH_LONG).show();
            return true;
         case 4:
            Toast. makeText (this, "Seleccionastes la opcion 5" , 
                Toast.LENGTH_LONG).show();
            return true;
         case 5:
            Toast.makeText (this, "Seleccionastes la opcion 6" , 
                Toast.LENGTH_LONG).show();
            return true;
         case 6:
            Toast.makeText (this, "Seleccionastes la opcion 7" , 
                Toast.LENGTH_LONG).show();
            return true;            
        }
         return false;
    }    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}