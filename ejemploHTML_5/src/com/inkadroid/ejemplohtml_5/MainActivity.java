package com.inkadroid.ejemplohtml_5;


import org.apache.cordova.*;
import android.os.Bundle;

public class MainActivity extends DroidGap
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        super.loadUrl("file:///android_asset/www/index.html");
    }
}