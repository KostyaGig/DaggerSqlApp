package com.kostya_ubutnu.daggersqlapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.kostya_ubutnu.daggersqlapp.model.User;
import com.kostya_ubutnu.daggersqlapp.repositories.MainRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.Provides;

public class MainDbHelper extends SQLiteOpenHelper {

    @Inject
    public MainDbHelper(Context context) {
        super(context,"User.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE  User_table (_id INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Password TEXT);");
        Log.d(MainRepository.TAG, "onCreate: ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public int addUser(String name,String password){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("Name",name);
        cv.put("Password",password);

        return (int) db.insert("User_table",null,cv);
    }

    public List<User> getAllUsers(){
        Log.d(MainRepository.TAG, "getAllUsers: ");
        SQLiteDatabase db = this.getWritableDatabase();

        List<User> allUsers = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM User_table",null);

        if (cursor.getCount() == 0){
            allUsers.add(new User("DefaultUser","Default password"));
            return allUsers;
        }

        if (cursor.moveToFirst()){
            while (cursor.moveToNext()){
                String name = cursor.getString(cursor.getColumnIndex("Name"));
                String password = cursor.getString(cursor.getColumnIndex("Password"));

                allUsers.add(new User(name,password));
            }
        }

        return allUsers;
    }
}
