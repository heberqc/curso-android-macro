package com.inkadroid.ejemplomarketing;
import java.util.HashMap;
import java.util.LinkedList;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import com.google.ads.*;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class MainActivity extends Activity {
	
	//codigo ID para registrar anuncios
	private static final String MY_AD_UNIT_ID ="a15154cc443b790";
	
	//control donde se mostrara el banner
	private AdView adView;
    
	   
	//utilizaremos 2 constantes para guardar la información en un HashMap  
	    
	static final String TITULO = "T";
	static final String LINK  = "L";
	
	 //utilizamos una estructura de datos estática para guardar la información del feed
	static LinkedList<HashMap<String, String>> datos;

	//direccion del feed
	static String URL = "http://elcomercio.feedsportal.com/rss/portada.xml";	
	
	//es necesario un dialogo mientras se carga los datos
	private ProgressDialog barra;
	
	 //un manejador(Handler) para enviar un mensaje de un hilo a otro cuando la carga de datos
	 //haya terminado.
	 	
	private final Handler progressHandler = new Handler() {
		@SuppressWarnings("unchecked")
		public void handleMessage(Message msg) {
			if (msg.obj != null) {
				datos = (LinkedList<HashMap<String, String>>)msg.obj;
				//llamar a la funcion que rellena el listview
				setData(datos);					
			}
			barra.dismiss();
	    }
	};
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //desactivar titulo
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        //mostrar en toda la pantalla        
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.activity_main);
        
        
        //Crear la adView     
        adView = new AdView(this, AdSize.BANNER, MY_AD_UNIT_ID);       
        final LinearLayout layout = (LinearLayout) findViewById(R.id.main);        
        
        
        // Añadirle la adView             
        layout.addView(adView);   
        
   
    			ListView lista = (ListView) findViewById(R.id.lst);

    		   	barra = ProgressDialog.show(MainActivity.this,"","Cargandose los datos...", true);
    	    	
    	    	new Thread(new Runnable(){
    	    		@Override
    	    		public void run() {
    	    			Parser parser = new Parser(URL); 
    	                Message msg = progressHandler.obtainMessage();
    	                msg.obj = parser.parse();
    	    			progressHandler.sendMessage(msg);
    	    		}}).start();
    	      

    	    	
 	    //al presionar un click en algun elemento de la lista	
        lista.setOnItemClickListener(new OnItemClickListener() {

    		@Override
    		public void onItemClick(AdapterView<?> av, View v, int position,
    				long id) {
    			//obtenemos el elemento que se presiono click
    			HashMap<String, String> entry = datos.get(position);

    			//abrimos una pagina a travez de un inten
    			Intent browserAction = new Intent(Intent.ACTION_VIEW,Uri.parse(entry.get(LINK)));
    			startActivity(browserAction);				
    		}
    	});        
    }
    
 
    //rellenar el listview 
    private void setData(LinkedList<HashMap<String, String>> datos){
    	SimpleAdapter sAdapter = new SimpleAdapter(getApplicationContext(), datos, 
    			android.R.layout.two_line_list_item, 
    			new String[] { TITULO, LINK }, 
    			new int[] { android.R.id.text1, android.R.id.text2 });
    	ListView lista = (ListView) findViewById(R.id.lst);
    	lista.setAdapter(sAdapter);
    }   
    
  
}