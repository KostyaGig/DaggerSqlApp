package com.kostya_ubutnu.daggersqlapp.repositories;

import android.content.Context;
import android.util.Log;

import com.kostya_ubutnu.daggersqlapp.db.MainDbHelper;
import com.kostya_ubutnu.daggersqlapp.model.User;

import java.util.List;

import javax.inject.Inject;

public class MainRepository {

    public static final String TAG = "uierng";



   @Inject MainDbHelper dbHelper;

    @Inject
    public MainRepository(){
        if (dbHelper == null){
            Log.d(TAG, "helper = null ");
        } else {
            Log.d(TAG, "MainRepository: != null");
        }
    }

    public boolean addUser(String name,String password){
        int result = dbHelper.addUser(name,password);

        if (result != -1){
            return true;
        } else {
            return false;
        }
    }

    public List<User> getAllUsers(){
        Log.d(TAG, "getAllUsers: ");
        return dbHelper.getAllUsers();
    }

}
