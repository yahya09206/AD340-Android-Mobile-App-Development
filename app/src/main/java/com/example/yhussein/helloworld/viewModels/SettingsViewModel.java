package com.example.yhussein.helloworld.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.yhussein.helloworld.database.Database;
import com.example.yhussein.helloworld.interfaces.DaoAccess;
import com.example.yhussein.helloworld.models.SettingsData;

public class SettingsViewModel extends AndroidViewModel {

    private DaoAccess settingsDao;
    LiveData<SettingsData> savedSettingsData;


    public SettingsViewModel(Application application) {
        super(application);
        settingsDao = Database.getInstance(application).daoAccess();
        savedSettingsData = settingsDao.getSettings();
    }

    public LiveData<SettingsData> getSavedSettingsData() {
        return savedSettingsData;
    }

    public void updateSettings(final SettingsData data) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                settingsDao.insertSettings(data);
            }
        }).start();


    }
}
