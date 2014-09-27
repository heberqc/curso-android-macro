package com.nolascov.Tutorial4;
import com.nolascov.Tutorial4.R;
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class Form2 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultado);

		TextView resultText = (TextView) findViewById(R.id.resultText);
		Bundle bundle = getIntent().getExtras();

		if (bundle.getString("Cancel") != null) {
			resultText.setText(getString(R.string.cancel));
		} else {
			String xnombre = bundle.getString("nombre");
			String xdireccion = bundle.getString("direccion");
			String xtelefono = bundle.getString("telefono");
			insertarCliente(xnombre, xdireccion ,xtelefono);

			resultText.setText(getString(R.string.mensaje2) + "\n" +
					"Nombre : " + xnombre + "\n" +
					"Direccion :" + xdireccion + "\n" +
					"Telefono : " + xtelefono);					
		}
	}	
	private void insertarCliente(String xnombre, String xdireccion, String xtelefono) {
		ManejoDatabase manejoDatabase = new ManejoDatabase(this);
		SQLiteDatabase db = manejoDatabase.getWritableDatabase();	
		ContentValues cv = new ContentValues();
		cv.put(manejoDatabase.NOMBRE, xnombre);
		cv.put(manejoDatabase.DIRECCION, xdireccion);
		cv.put(manejoDatabase.TELEFONO, xtelefono);	
		db.insert("cliente", manejoDatabase.NOMBRE, cv);
		db.close();
	}	
}