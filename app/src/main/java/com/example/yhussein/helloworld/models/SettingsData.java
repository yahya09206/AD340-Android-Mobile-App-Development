package com.example.yhussein.helloworld.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class SettingsData {

    @NonNull
    @PrimaryKey
    private String uid;
    private String reminderTime;
    private String searchDistance;
    private int gender;
    private int accountType;
    private String ageRange;

    public SettingsData() {
    }


    public String getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(String reminderTime) {
        this.reminderTime = reminderTime;
    }

    public String getSearchDistance() {
        return searchDistance;
    }

    public void setSearchDistance(String searchDistance) {
        this.searchDistance = searchDistance;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
