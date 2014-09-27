package com.inkadroid.mapa3;

import android.os.Bundle;
import org.apache.cordova.*;



public class MainActivity extends DroidGap
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        super.loadUrl("file:///android_asset/www/index.html");
    }
}
