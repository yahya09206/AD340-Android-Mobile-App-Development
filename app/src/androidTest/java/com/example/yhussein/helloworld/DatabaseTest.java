package com.example.yhussein.helloworld;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.yhussein.helloworld.database.Database;
import com.example.yhussein.helloworld.interfaces.DaoAccess;
import com.example.yhussein.helloworld.models.SettingsData;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class DatabaseTest {

    private DaoAccess daoAccess;
    private Database database;

    @Before
    public void createDB(){
        Context context = InstrumentationRegistry.getTargetContext();
        database = Room.inMemoryDatabaseBuilder(context, Database.class).build();
        daoAccess = database.daoAccess();
    }

    @After
    public void closeDB(){
        database.close();
    }

    @Test
    public void testSettingsDataWriteAndRead(){

        //Write settings data with id as "sampleUID"
        SettingsData data = new SettingsData();
        data.setUid("2");
        data.setAgeRange("sampleUID");
        daoAccess.insertSettings(data);

        LiveData<SettingsData> retrievedSettings = daoAccess.getSettings();
        MatcherAssert.assertThat(retrievedSettings, Matchers.equalTo(retrievedSettings));

    }

}
