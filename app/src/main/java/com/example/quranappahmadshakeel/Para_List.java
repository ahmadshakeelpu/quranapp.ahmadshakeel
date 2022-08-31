package com.example.quranappahmadshakeel;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import java.util.ArrayList;

public class Para_List extends AppCompatActivity {
    ListView paralist;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_para_list);
        paralist=findViewById(R.id.parahList);
        drawerLayout=findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DBHelper helper=new DBHelper(Para_List.this);
        ArrayList<String> list=new ArrayList<String>();
        for (int i=1; i<=30; i++){
            list.add(i+"");
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        paralist.setAdapter(adapter);
        paralist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Para_List.this, Surah.class);
                intent.putExtra("position", position);
                intent.putExtra("type", "Para");
                startActivity(intent);
            }
        });
 public ArrayList<String> getParaList() {
            SQLiteDatabase db = this.getReadableDatabase();
            String Query = "Select * from " + AYAH_TABLE ;
            Cursor cursor = db.rawQuery(Query, null);
            ArrayList<String> rtn=new ArrayList<String>();
            //english urdu ka chakr hai abhi
            QDH qdh=new QDH();
            ArrayList<String> paraName = new ArrayList<>();
            paraName=qdh.GetParahNameEnglish();
            int i=0;
            /*if(!(cursor.getCount() <= 0)){
                while(cursor.moveToNext()) {
                    rtn.add(cursor.getString(10));
                }
            }*/
            while(i<paraName.size())
            {
                rtn.add((i+1)+"   "+paraName.get(i));
                i++;
            }

            cursor.close();
            db.close();
            return rtn;

        }

     case R.id.nav_book:
                        Toast.makeText(getApplicationContext(), "Book is Clicked", Toast.LENGTH_LONG).show();
                    case R.id.nav_surah:
//                        Toast.makeText(getApplicationContext(), "Book is Clicked", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, view1.class);
                        intent.putExtra("type","surah");
                        startActivity(intent);
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_return:
                        Toast.makeText(getApplicationContext(), "Return is Clicked", Toast.LENGTH_LONG).show();
                    case R.id.nav_parah:
//                        Toast.makeText(getApplicationContext(), "Return is Clicked", Toast.LENGTH_LONG).show();
                        intent = new Intent(MainActivity.this, view1.class);
                        intent.putExtra("type","para");
                        startActivity(intent);
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        break;
    }

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}