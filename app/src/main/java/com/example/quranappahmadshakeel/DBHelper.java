package com.example.quranappahmadshakeel;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;
public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "QuranDb.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<SurahModel> readSurah() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor SurahData = db.rawQuery("SELECT * FROM tsurah", null);
        ArrayList<SurahModel> SurahList = new ArrayList<>();
        if (SurahData.moveToFirst()) {
            do {
                SurahList.add(new SurahModel(SurahData.getInt(0), SurahData.getString(1), SurahData.getString(2), SurahData.getString(3), SurahData.getString(4)));
            } while (SurahData.moveToNext());
        }
        SurahData.close();
        return SurahList;
    }
    public ArrayList<Ayaat_Model> readAyah() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor AyahData = db.rawQuery("SELECT * FROM tayah", null);
        ArrayList<Ayaat_Model> AyahList = new ArrayList<>();
        if (AyahData.moveToFirst()) {
            do {
                AyahList.add(new Ayaat_Model(AyahData.getInt(0), AyahData.getInt(1), AyahData.getInt(2), AyahData.getString(3), AyahData.getString(4), AyahData.getString(5), AyahData.getString(6), AyahData.getString(7), AyahData.getInt(8),AyahData.getInt(9),AyahData.getInt(10)));
            } while (AyahData.moveToNext());
        }
        AyahData.close();
        return AyahList;
    }
    public ArrayList<Ayaat_Model> readAyah_surah(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor AyahData = db.rawQuery("SELECT * FROM tayah WHERE SuraID ="+id, null);
        ArrayList<Ayaat_Model> AyahList = new ArrayList<>();
        if (AyahData.moveToFirst()) {
            do {
                AyahList.add(new Ayaat_Model(AyahData.getInt(0), AyahData.getInt(1), AyahData.getInt(2), AyahData.getString(3), AyahData.getString(4), AyahData.getString(5), AyahData.getString(6), AyahData.getString(7), AyahData.getInt(8),AyahData.getInt(9),AyahData.getInt(10)));
            } while (AyahData.moveToNext());
        }
        AyahData.close();
        return AyahList;
    }
    public ArrayList<Ayaat_Model> readAyah_para(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor AyahData = db.rawQuery("SELECT * FROM tayah WHERE ParaID ="+id, null);
        ArrayList<Ayaat_Model> AyahList = new ArrayList<>();
        if (AyahData.moveToFirst()) {
            do {
                AyahList.add(new Ayaat_Model(AyahData.getInt(0), AyahData.getInt(1), AyahData.getInt(2), AyahData.getString(3), AyahData.getString(4), AyahData.getString(5), AyahData.getString(6), AyahData.getString(7), AyahData.getInt(8),AyahData.getInt(9),AyahData.getInt(10)));
            } while (AyahData.moveToNext());
        }
    String Query = "Select Arabic Text from " + AYAH_TABLE+ "WHERE SuraID =" + suraId;
            String Query = "Select \""+ARABIC_COLUMN+"\" from " + AYAH_TABLE+ " WHERE AyaId =0 or SuraID =" + suraId;
            Cursor cursor = db.rawQuery(Query, null);
            ArrayList<String> rtn=new ArrayList<String>();
            if(!(cursor.getCount() <= 0)){
                while(cursor.moveToNext()) {
                    rtn.add(cursor.getString(0)+"    "+cursor.getString(2)+"    "+cursor.getString(4));
                    rtn.add(cursor.getString(0));
                }
            }
        AyahData.close();
        return AyahList;
    }
}
