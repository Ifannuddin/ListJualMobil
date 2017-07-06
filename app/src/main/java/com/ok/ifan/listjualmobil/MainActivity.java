package com.ok.ifan.listjualmobil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[][] data = new String[][]{
            {"Honda, Brio, 1.2L CKD S A/T, 2015",
                    "https://gifdicoding.blob.core.windows.net/academyandroid/modul8_honda_brio.jpg","19 Juta", "Jakarta Selatan"},
            {"Honda, Jazz, RS 1.5 A/T, 2015",
                    "https://gifdicoding.blob.core.windows.net/academyandroid/modul8_honda_jazz.jpg","19 Juta", "Jakarta Selatan"},
            {"Mazda, Mazda2, V 1.5 M/T, 2014",
                    "https://gifdicoding.blob.core.windows.net/academyandroid/modul8_mazda2.jpg", "24 Juta","Tangerang"},
            {"Honda, Jazz, A 1.5 M/T, 2015",
                    "https://gifdicoding.blob.core.windows.net/academyandroid/modul8_honda_jazz_2.png","Rp. 207.500.000", "Jakarta Barat"},
            {"Mitsubishi, Outlander, Sport PX, 2015",
                    "https://gifdicoding.blob.core.windows.net/academyandroid/modul8_outlander.png","Call", "Tangerang"}
    };

    private ListView lvItem;
    private ArrayList listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItem = (ListView)findViewById(R.id.lv_item);
        listItem = new ArrayList<>();

        MobilModel mobil = null;

        for (int i = 0; i < data.length; i++) {
            mobil = new MobilModel();
            mobil.setTitle(data[i][0]);
            mobil.setImage(data[i][1]);
            mobil.setHarga(data[i][2]);
            mobil.setLokasi(data[i][3]);

            listItem.add(mobil);
        }

        MobilAdapter adapter = new MobilAdapter(MainActivity.this, listItem);
        lvItem.setAdapter(adapter);

        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MobilModel mbl = (MobilModel) listItem.get(position);

                Intent intent = new Intent(MainActivity.this, DetailMobilActivity.class);
                intent.putExtra(DetailMobilActivity.KEY_ITEM, mbl);
                startActivityForResult(intent, 0);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_setelan) {
            Intent intent = new Intent(MainActivity.this, Setelan.class);
            startActivity(intent);
        }

        if (id == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
