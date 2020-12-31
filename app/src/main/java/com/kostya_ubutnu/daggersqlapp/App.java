package com.kostya_ubutnu.daggersqlapp;

import android.app.Application;

import com.kostya_ubutnu.daggersqlapp.components.AppComponent;
import com.kostya_ubutnu.daggersqlapp.components.DaggerAppComponent;
import com.kostya_ubutnu.daggersqlapp.modules.MainModule;


public class App extends Application {

    public static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .mainModule(new MainModule(getApplicationContext()))
                .build();
    }

}
