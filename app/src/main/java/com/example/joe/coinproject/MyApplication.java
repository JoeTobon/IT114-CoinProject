package com.example.joe.coinproject;

import android.app.Application;
import com.facebook.drawee.backends.pipeline.Fresco;
/**  * Created by halper.  */
public class MyApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        Fresco.initialize(this);
    }
}