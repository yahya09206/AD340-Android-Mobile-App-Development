package com.example.yhussein.helloworld.database;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.yhussein.helloworld.interfaces.DaoAccess;
import com.example.yhussein.helloworld.models.SettingsData;

@android.arch.persistence.room.Database(entities = {SettingsData.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {

    public abstract DaoAccess daoAccess();
    static final String DATABASE_NAME = "settings_db";
    public static Database dInstance;

    public static Database getInstance(Application application) {
        if (dInstance == null){
            dInstance = create(application);
        }
        return dInstance;
    }

    private static Database create(Application application) {

        return Room.databaseBuilder(application,
                Database.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();

    }
}
