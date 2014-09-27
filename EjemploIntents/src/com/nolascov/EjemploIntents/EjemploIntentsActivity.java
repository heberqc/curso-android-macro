package com.nolascov.EjemploIntents;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class EjemploIntentsActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	
	Intent i;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button b =  (Button) findViewById(R.id.button1);
        b.setOnClickListener(this);
        
        
        Button c =  (Button) findViewById(R.id.button2);
        c.setOnClickListener(this);
    }

	public void onClick(View clicked) {
		if ( clicked.getId() == R.id.button1 )
		{
  		i = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.google.com.pe/"));
		startActivity(i);
		}

		if ( clicked.getId() == R.id.button2 )
		{
    		i = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.youtube.com/watch?v=pZYTb1aVb6c"));
    		startActivity(i);
		}

		
	}
}