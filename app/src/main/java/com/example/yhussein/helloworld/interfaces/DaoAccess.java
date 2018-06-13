package com.example.yhussein.helloworld.interfaces;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.yhussein.helloworld.models.SettingsData;

@Dao
public interface DaoAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSettings(SettingsData settingsData);

    @Query("SELECT * FROM SettingsData")
    LiveData<SettingsData> getSettings();

}
