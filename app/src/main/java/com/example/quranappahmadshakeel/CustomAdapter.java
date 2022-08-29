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

public class CustomAdapter extends ArrayAdapter<AyatModel> {
    public CustomAdapter(@NonNull Context context, List<AyatModel> ayatModel) {
        super(context, 0, ayatModel);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        AyatModel ayatModel=getItem(position);
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.activity_customayat, parent, false);
        TextView arbic=convertView.findViewById(R.id.ayaat_arabic);
        TextView urdu=convertView.findViewById(R.id.ayat_urdu);
        TextView english=convertView.findViewById(R.id.ayat_english);
        arbic.setText(ayaat_model.getArabicText()+"");
        urdu.setText(ayaat_model.getFateh_Muhammad_Jalandhri()+"");
        english.setText(ayaat_model.getMufti_Taqi_Usmani()+"");
        return convertView;
    }
}
