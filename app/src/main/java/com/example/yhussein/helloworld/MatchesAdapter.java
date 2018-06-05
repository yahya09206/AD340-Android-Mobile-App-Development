package com.example.yhussein.helloworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.yhussein.helloworld.models.Match;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MatchesAdapter extends BaseAdapter {

    private ArrayList<Match> matches;
    private Context context;

    MatchesAdapter(Context context, ArrayList<Match> matches) {
        this.context = context;
        this.matches = matches;
    }

    @Override
    public int getCount() {
        return matches.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.match_item, null);
            holder.likeBtn = view.findViewById(R.id.likeBtn);
            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }

        holder.likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You liked "+matches.get(position).getName(), Toast.LENGTH_SHORT).show();
                FirebaseDatabase.getInstance().getReference().child("matches").child(matches.get(position).getUid()).child("liked").setValue(true);

            }
        });

        return view;
    }

    private class ViewHolder{
        Button likeBtn;
    }
}
