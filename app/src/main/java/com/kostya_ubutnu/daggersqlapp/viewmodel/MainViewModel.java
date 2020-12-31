package com.kostya_ubutnu.daggersqlapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kostya_ubutnu.daggersqlapp.model.User;
import com.kostya_ubutnu.daggersqlapp.repositories.MainRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainViewModel extends ViewModel {

    @Inject  MutableLiveData<List<User>> allUsers;
    @Inject  MainRepository repository;

    @Inject
    public MainViewModel() {

    }

    public void addUser(String name,String password) {
        boolean result = repository.addUser(name, password);

        if (result == true) {
            getUsers();
        } else {
            allUsers.setValue(null);
        }

    }

    public MutableLiveData<List<User>> getAllUsers(){
        return allUsers;
    }

    public void getUsers(){
        allUsers.setValue(repository.getAllUsers());
    }

}
