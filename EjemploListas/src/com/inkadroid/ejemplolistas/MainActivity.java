package com.inkadroid.ejemplolistas;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;

public class MainActivity extends Activity {
	
	/*
	 Definimos un objeto de tipo TextView y otro de tipo ListView 
	donde almacenaremos las referencias a los objetos que definimos 
	en el archivo XML:lista
	*/
	ListView lv;
	TextView seleccionado;	
	//definimos un arreglo donde almacenamos los valores a mostrar
	String[] incas = { 
			"Manco capac", 
			"Sinchi Roca", 
			"Lloque Yupanqui", 
			"Mayta C�pac", 
			"C�pac Yupanqui", 
			"Inca Roca", 
			"Y�huar Huaca", 
			"Wiracocha", 
			"Pachac�tec", 
			"Amaru Inca Yupanqui", 
			"T�pac Inca Yupanqui",
			"Huayna C�pac",
			"Hu�scar",
			"Atahualpa"};
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);
        //hacemos referencia a los dos objetos:
        lv = (ListView)findViewById(android.R.id.list);
        seleccionado = (TextView)findViewById(R.id.seleccion);
        
        /*
        Paso siguiente es llenar la lista con las opciones, 
        para lo cu�l llamamos al m�todo setAdapter() 
        que recibe como par�metros el contexto en el cu�l
        se est� utilizando la lista (this), el nombre del recurso 
        que define el aspecto visual de la lista 
        (en este caso hacemos uso de un layout predefinido por Android: android.R.layout.simple_list_item_1)
         y por �ltimo, el arreglo de datos que en 
         este caso definimos en la variable datos.
         */
        
        lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,incas));
        
        /*
        ahora asignamos variable lv un listener que nos permitir�
        definir una acci�n que responda al evento de seleccionar 
        un �tem de la lista. En este caso, lo que hacemos es indicar
        que se nos muestre el texto de la opci�n en el TextView.
         */
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                int posicion, long id) {
            	seleccionado.setText("Elejistes: " + incas[posicion]);
            }
          });
    }
}
