package com.nolasco.wallpaper;

import java.io.IOException;
import com.nolasco.wallpaper.R.id;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity implements OnClickListener{
	
	ImageView mostrar,ferrari,audi,chevrolet,dodge,kia,toyota;
	Button colocar;
	int celular;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mostrar = (ImageView) findViewById(id.imageView0);
        ferrari = (ImageView) findViewById(id.imageView1);
        audi = (ImageView) findViewById(id.imageView2);
        chevrolet = (ImageView) findViewById(id.imageView3);
        dodge = (ImageView) findViewById(id.imageView4);
        kia = (ImageView) findViewById(id.imageView5);
        toyota = (ImageView) findViewById(id.imageView6);
        colocar = (Button) findViewById(id.btnColocar);
        
        ferrari.setOnClickListener(this);
        audi.setOnClickListener(this);
        chevrolet.setOnClickListener(this);
        dodge.setOnClickListener(this);
        kia.setOnClickListener(this);
        toyota.setOnClickListener(this);
        colocar.setOnClickListener(this);
        	      
    }

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId())
		{
		//ferrari
		case R.id.imageView1:
	    mostrar.setImageResource(R.drawable.ferrari);
	    celular=R.drawable.ferrari;
	    break;
		//audi
		case R.id.imageView2:
		mostrar.setImageResource(R.drawable.audi);
	    celular=R.drawable.audi;
	    break;
		//chevrolet
		case R.id.imageView3:
		mostrar.setImageResource(R.drawable.chevrolet);
	    celular=R.drawable.chevrolet;
	    break;
		//dodge
		case R.id.imageView4:
		mostrar.setImageResource(R.drawable.dodge);
	    celular=R.drawable.dodge;
	    break;
		//kia
		case R.id.imageView5:
		mostrar.setImageResource(R.drawable.kia);		
	    celular=R.drawable.kia;	
	    break;
		//toyota
		case R.id.imageView6:
		mostrar.setImageResource(R.drawable.toyota);	
	    celular=R.drawable.toyota;
	    break;
		//boton colocar
		case R.id.btnColocar:
		Bitmap imagen = BitmapFactory.decodeStream(getResources().openRawResource(celular));
			try {
				getApplicationContext().setWallpaper(imagen);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    break;

		}
		
	}
    
}
