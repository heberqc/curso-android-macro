package com.nolascov.EjemploNavegar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;


public class EjemploNavegarActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Uri uri = Uri.parse("http://www.google.es");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri) ;
        startActivity(intent);
        WebView webview = new WebView(this);
        setContentView(R.layout.main);
    }
}