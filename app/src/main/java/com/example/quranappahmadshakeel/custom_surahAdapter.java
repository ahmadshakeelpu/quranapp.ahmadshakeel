package com.example.quranappahmadshakeel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class custom_surahAdapter extends ArrayAdapter<SurahModel> {
    public custom_surahAdapter(@NonNull Context context, List<SurahModel> surahModel) {
        super(context, 0, surahModel);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        SurahModel surahModel=getItem(position);
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.custom_surahlist, parent, false);
        TextView name=convertView.findViewById(R.id.surahname);
        name.setText(surahModel.getSurahNameU()+"");
        return convertView;
    }
}
