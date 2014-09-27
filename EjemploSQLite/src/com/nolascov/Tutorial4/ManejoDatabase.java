package com.nolascov.Tutorial4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ManejoDatabase extends SQLiteOpenHelper {
	private static final String BASEDATOS = "ventas.db";
	public static final String NOMBRE = "nombre";
	public static final String DIRECCION = "direccion";
	public static final String TELEFONO = "telefono";

	public ManejoDatabase(Context context) {
		super(context, BASEDATOS, null, 1); 
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(	"CREATE TABLE cliente (codigo INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , nombre TEXT, direccion TEXT, telefono TEXT);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		android.util.Log.w("cliente","Upgrading database, which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS cliente");
		onCreate(db);
	}
}




