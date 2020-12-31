package com.kostya_ubutnu.daggersqlapp.components;

import com.kostya_ubutnu.daggersqlapp.MainActivity;
import com.kostya_ubutnu.daggersqlapp.modules.MainModule;

import dagger.Component;

@Component(modules = {MainModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);
}
