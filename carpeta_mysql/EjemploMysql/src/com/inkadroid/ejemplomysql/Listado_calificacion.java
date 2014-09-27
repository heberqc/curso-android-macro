package com.inkadroid.ejemplomysql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class Listado_calificacion extends ListActivity {

	// barra de progreso
	private ProgressDialog pDialog;

	// creacion del objeto   JSON 
	JSONParser jParser = new JSONParser();

	
	ArrayList<HashMap<String, String>> listado;
	//listado de calificaciones
	
	// url para obtener el listado de calificaciones
	private static String url_listado = "http://10.0.2.2/instituto/listado_alumnos.php";

	//url_all_products
	
	// Nombre de Nodos JSON 
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_ALUMNO = "alumnos";
	private static final String TAG_NOMBRE = "nombre";
	private static final String TAG_NOTA = "nota";
	
	
	// calificacion JSONArray
	JSONArray calificacion = null;


	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.all_products);
		//setContentView(R.layout.list_item);

		// Hashmap para el ListView
		listado = new ArrayList<HashMap<String, String>>();

		// cargando calificaciones en Background Thread
		new CargarCalificacion().execute();

		// obtener listview
		ListView lv = getListView();

	}

	// Respuesta desde la eidcion de la ctividad Product 
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		// si el resultado del codigo es 100
		if (resultCode == 100) {
			//si el código de resultado 100 se recibió
			//: el usuario editar / eliminar producto
			//vuelve a cargar la pantalla de nuevo
			Intent intent = getIntent();
			finish();
			startActivity(intent);
		}

	}


	//Async cargar todo las calificaciones al hacer una solicitud HTTP
	class CargarCalificacion extends AsyncTask<String, String, String> {

		//Antes de comenzar thread Mostrar cuadro de diálogo Progreso
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			///CAMBIOS EN LA SIGUIENTE LINEA
			pDialog = new ProgressDialog(Listado_calificacion.this);
			pDialog.setMessage("Cargando Calificaciones...Espero un Momento...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}

		
		 //obtener calificaciones desde la url
		 
		protected String doInBackground(String... args) {
			// Construyendo Parametros
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			// consiguiendo la cadena  JSON desde URL
			JSONObject json = jParser.makeHttpRequest(url_listado, "GET", params);
			
			// Check your log cat for JSON reponse
			Log.d("All Products: ", json.toString());

			try {
				// comprobacion de for SUCCESS TAG
				int success = json.getInt(TAG_SUCCESS);

				if (success == 1) {
					// calificacion encontrada
					// obtener  Array de calificacion
					calificacion = json.getJSONArray(TAG_ALUMNO);

					// recorriendo todas las  calificacion
					for (int i = 0; i < calificacion.length(); i++) {
						JSONObject c = calificacion.getJSONObject(i);

						// almacenan el nombre y la nota en la variable json 
						String id = c.getString(TAG_NOMBRE);
						String name = c.getString(TAG_NOTA);
						
						System.out.println(id);
						System.out.println(name);

						// creando un nuevo HashMap
						HashMap<String, String> map = new HashMap<String, String>();

						// añadiendo nodos clave y valor
						map.put(TAG_NOMBRE, id);
						map.put(TAG_NOTA, name);

						// añadiendo HashList al ArrayList
						listado.add(map);
					}
				} 
			} catch (JSONException e) {
				e.printStackTrace();
			}

			return null;
		}

	
		//Después de completar la tarea  cerra el diálogo de progreso
		protected void onPostExecute(String file_url) {
			// cerra el dialogo despues de recibir las calificaciones
			pDialog.dismiss();
			// actualzas las UI en segundo plano 
			runOnUiThread(new Runnable() {
				public void run() {
					//Actualización  datos JSON en el ListView
					///CAMBIOS EN LA SIGUIENTE LINEA
					ListAdapter adapter = new SimpleAdapter(
							Listado_calificacion.this, listado,
							R.layout.list_item, new String[] { TAG_NOMBRE,
									TAG_NOTA},
							new int[] { R.id.pid, R.id.name });
					// actualizar el  listview
					setListAdapter(adapter);
				}
			});

		}

	}
}