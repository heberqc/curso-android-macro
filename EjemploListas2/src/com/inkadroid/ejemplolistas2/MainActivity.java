package com.inkadroid.ejemplolistas2;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends ListActivity {
	ListView lv;
	TextView seleccionado;
    static final ArrayList<HashMap<String,String>> list = 
		new ArrayList<HashMap<String,String>>();
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SimpleAdapter adapter = new SimpleAdapter(
        	this,
        	list,
        	R.layout.lista,
        	new String[] {"titulo","isbn","autor","paginas"},
        	new int[] {R.id.titulo,R.id.isbn, R.id.autor, R.id.paginas}
        );     
        populateList();
        setListAdapter(adapter);   
        seleccionado = (TextView)findViewById(R.id.seleccion);
        lv = (ListView)findViewById(android.R.id.list);
        
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                int posicion, long id) {   	
            	seleccionado.setText("Elemento: " +posicion);
            }
          });
    }
    
    private void populateList() {
    	HashMap<String,String> map = new HashMap<String,String>();
    	
    	map.put("titulo",
	"Programación Transact con SQL SERVER 2012 ");
    	map.put("isbn", " 978-612-304-084-0");
    	map.put("autor", "Manuel Torres Remon");
    	map.put("paginas", "328 Paginas");
    	list.add(map);
    	
    	map = new HashMap<String,String>();
    	
    	map.put("titulo",
	"Program. orientada a objetos con Visual Basic 2012 ");
    	map.put("isbn", "978-612-304-085-7");
    	map.put("autor", "Manuel Torres Remon");
    	map.put("paginas", "416 Paginas");
    	list.add(map);
    	
    	map = new HashMap<String,String>();
    	
    	map.put("titulo",
	"Program. orientada a objetos con Visual Basic 2012 ");
    	map.put("isbn", "978-612-304-085-7");
    	map.put("autor", "Manuel Torres Remon");
    	map.put("paginas", "416 Paginas");
    	list.add(map); 

    	map = new HashMap<String,String>();
    	
    	map.put("titulo",
	"Desarrollo de aplicaciones con Android");
    	map.put("isbn", "978-612-304-047-5");
    	map.put("autor", "Jorge Nolasco Valenzuela");
    	map.put("paginas", "264 Paginas");
    	list.add(map); 
    	
   	map = new HashMap<String,String>();
    	
    	map.put("titulo",
	"Una nueva forma de desarrollo Visual Studio 2010");
    	map.put("isbn", "978-612-304-004-8");
    	map.put("autor", "Cristian Sánchez F.");
    	map.put("paginas", "384 Paginas");
    	list.add(map); 
    	 	
    	  	}
}