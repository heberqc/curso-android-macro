//crear una clase publica Ejemplo_piscoActivity heredando caracteristicas de la clase base Activity
package com.nolascov.Ejemplo_pisco_;


import com.google.ads.*;
import com.nolascov.Ejemplo_pisco_.PiscoAdapter;
import com.nolascov.Ejemplo_pisco_.PiscoHolder;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;



public class Ejemplo_pisco_Activity extends Activity implements OnItemClickListener{ //implementar el escucha de evento OnItemClickListener
	   private static final String MY_AD_UNIT_ID ="a15111d27f1f49e";
	private static PiscoHolder viewHolder;
	    private PiscoAdapter newsEntryAdapter;
	    private AdView adView;
	    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
     
        
        
        //Crear la adView     
        adView = new AdView(this, AdSize.BANNER, MY_AD_UNIT_ID);       
        final LinearLayout layout = (LinearLayout) findViewById(R.id.main);        
        
        
        // Añadirle la adView             
        layout.addView(adView);              
        /*
        // Iniciar una solicitud genérica para cargarla con un anuncio            
        adView.loadAd(new AdRequest()); 
        */
        
        
        // configuramos la lista 
        final ListView listView = (ListView) findViewById(R.id.list);
        //evento de escucha para el listView        
        listView.setOnItemClickListener(this);
        // instanciamos la clase PiscoAdapter
        newsEntryAdapter = new PiscoAdapter(this, R.layout.pisco_entry);
        // indicamos el adapater que utilizara el listView 
        listView.setAdapter(newsEntryAdapter);
        // llenamos la lista a travez del adapter
        addNewsEntries( newsEntryAdapter );   
    }

    
	private void addNewsEntries( PiscoAdapter adapter ) {
        adapter.add( new PiscoEntry( "Chilcano", "Pisco, jugo de limon, ginger ale, amargo de angostura", "", "", R.drawable.pisco_0, R.drawable.icon_0 ) );
        adapter.add( new PiscoEntry( "Peru Libre", "Pisco, rodaja de limon, gaseosa oscura, hielo", "", "", R.drawable.pisco_1, R.drawable.icon_1 ) );
        adapter.add( new PiscoEntry( "Cocktel De Fruta", "Pisco, pulpa de fresa, jarabe de goma, leche, hielo", "", "", R.drawable.pisco_2, R.drawable.icon_2 ) );
        adapter.add( new PiscoEntry( "Capitan", "Pisco, Vermut rojo, hielo", "", "", R.drawable.pisco_3, R.drawable.icon_3 ) );
        adapter.add( new PiscoEntry( "Pisco Tonic", "Pisco, agua tonica, hielo", "", "", R.drawable.pisco_4,R.drawable.icon_4 ) );
        adapter.add( new PiscoEntry( "Pisco Sunrise", "Pisco, jugo de naranja, jarabe de granadina, hielo", "", "", R.drawable.pisco_5,R.drawable.icon_5 ) );
        adapter.add( new PiscoEntry( "Biblia", "Pisco, vino Oporto, jarabe de goma, leche, huevo entero, hielo", "", "", R.drawable.pisco_6,R.drawable.icon_6 ) );
        adapter.add( new PiscoEntry( "Pisco Sour", "Pisco, clara de huevo, jugo de limon, jarabe de goma, hielo", "", "", R.drawable.pisco_7,R.drawable.icon_7 ) );
    }
    public void onItemClick( final AdapterView<?> av, final View view, final int pos, final long id ) {
        viewHolder = newsEntryAdapter.getViewHolder( newsEntryAdapter.getWorkingView(view) );
        Toast.makeText(getApplicationContext(), viewHolder.titleView.getText(), Toast.LENGTH_SHORT).show();
    }   
}

