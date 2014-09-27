package com.inkadroid.mapa4;

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
