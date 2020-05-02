package com.example.akhbariapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.akhbariapp.Dao.UserDao;
import com.example.akhbariapp.Entity.EntityUser;
import com.example.akhbariapp.Entity.NationalCardsEntity;
import com.example.akhbariapp.Entity.PostsEntity;

@Database(entities = {EntityUser.class, NationalCardsEntity.class, PostsEntity.class},version = 2)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;
    public abstract UserDao userDao();
    public static synchronized AppDatabase getinstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context,AppDatabase.class,"Database")
                    .fallbackToDestructiveMigration()
                    .build();
            return instance;
        }

        return instance;
    }
}
