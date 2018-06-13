package com.example.yhussein.helloworld;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yhussein.helloworld.database.Database;
import com.example.yhussein.helloworld.models.SettingsData;
import com.example.yhussein.helloworld.viewModels.SettingsViewModel;

public class SettingsFragment extends Fragment {


    EditText reminderTime;
    EditText maxDistance;
    EditText ageRange;
    Spinner genderSpinner;
    Spinner accountTypeSpinner;

    Button saveBtn;
    private SettingsViewModel settingsViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        //MVVM Implementation
        settingsViewModel = ViewModelProviders.of(this).get(SettingsViewModel.class);
        settingsViewModel.getSavedSettingsData().observe(this, new Observer<SettingsData>() {
            @Override
            public void onChanged(@Nullable SettingsData settingsData) {
                if (settingsData != null) {
                    updateUI(settingsData);
                }
            }
        });

        reminderTime = view.findViewById(R.id.reminderTime);
        maxDistance = view.findViewById(R.id.maxDistance);
        ageRange = view.findViewById(R.id.ageRange);
        genderSpinner = view.findViewById(R.id.genderSpinner);
        accountTypeSpinner = view.findViewById(R.id.accountTypeSpinner);
        saveBtn = view.findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsData data = new SettingsData();
                data.setUid("sample");
                data.setReminderTime(reminderTime.getText().toString());
                data.setSearchDistance(maxDistance.getText().toString());
                data.setGender(genderSpinner.getSelectedItemPosition());
                data.setAccountType(accountTypeSpinner.getSelectedItemPosition());
                data.setAgeRange(ageRange.getText().toString());

                Toast.makeText(getActivity(), "Settings saved", Toast.LENGTH_SHORT).show();
                updateSettings(data);
            }
        });

        return view;
    }

    private void updateSettings(final SettingsData data) {
        //Save settings
        settingsViewModel.updateSettings(data);
    }

    private void updateUI(SettingsData settingsData) {

        //Show saved settings

        reminderTime.setText(settingsData.getReminderTime());
        maxDistance.setText(settingsData.getSearchDistance());
        genderSpinner.setSelection(settingsData.getGender());
        accountTypeSpinner.setSelection(settingsData.getAccountType());
        ageRange.setText(settingsData.getAgeRange());
    }
}
