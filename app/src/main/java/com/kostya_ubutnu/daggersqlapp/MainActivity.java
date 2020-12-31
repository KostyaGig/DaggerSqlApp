package com.kostya_ubutnu.daggersqlapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.kostya_ubutnu.daggersqlapp.model.User;
import com.kostya_ubutnu.daggersqlapp.repositories.MainRepository;
import com.kostya_ubutnu.daggersqlapp.viewmodel.MainViewModel;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.component.inject(this);
        setContentView(R.layout.activity_main);

        mainViewModel.getUsers();
        mainViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {


                Log.d(MainRepository.TAG, "onChanged: ");
                for (int i = 0; i <users.size() ; i++) {
                    User user = users.get(i);
                    Log.d(MainRepository.TAG,user.getName());
                }

            }
        });

        findViewById(R.id.text2).setOnClickListener(view ->{
            mainViewModel.addUser("KOstya","123456");
        });
    }

}
