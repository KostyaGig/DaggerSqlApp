package com.kostya_ubutnu.daggersqlapp.modules;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.kostya_ubutnu.daggersqlapp.db.MainDbHelper;
import com.kostya_ubutnu.daggersqlapp.model.User;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private Context context;

    public MainModule(Context context){
        this.context = context;
    }

    @Provides
    public Context provideContext(){
        return this.context;
    }

    @Provides
    public MainDbHelper provideHelper(){
        return new MainDbHelper(context);
    }

    @Provides
    public MutableLiveData<List<User>> provideLiveData(){
        return new MutableLiveData<>();
    }
}
