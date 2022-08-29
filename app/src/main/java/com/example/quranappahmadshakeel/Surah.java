package com.example.quranappahmadshakeel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
public class Surah {

    ListView surahlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah);
        Intent intent=getIntent();
        surahlist=findViewById(R.id.ayaat_list);
        DBHelper helper=new DBHelper(Surah.this);
        List<AyatModel> ayatmodelList;
        if(intent.getStringExtra("type").equals("Surah")) {
            ayatmodelList=helper.readAyah_surah(intent.getIntExtra("position", 0)+1);
        }
        else
        {
            ayatmodelList=helper.readAyah_para(intent.getIntExtra("position", 0)+1);
        }
        CustomAdapter adapter=new CustomAdapter(Surah.this, ayatmodelList);
        surahlist.setAdapter(adapter);
    }

}
