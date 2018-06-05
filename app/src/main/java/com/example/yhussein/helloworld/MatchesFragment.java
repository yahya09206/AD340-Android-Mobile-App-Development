package com.example.yhussein.helloworld;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.yhussein.helloworld.models.Match;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MatchesFragment extends Fragment {

    private ArrayList<Match> matches = new ArrayList<>();
    private ListView matchList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_matches, container, false);

        matchList = view.findViewById(R.id.matchList);

        FirebaseDatabase.getInstance().getReference().child("matches").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){

                    matches.clear();

                    for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                        Match mMatch = snapshot.getValue(Match.class);
                        matches.add(mMatch);
                    }

                    showMatches();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
    }

    private void showMatches() {
        MatchesAdapter adapter = new MatchesAdapter(getActivity(), matches);
        matchList.setAdapter(adapter);
    }

}
