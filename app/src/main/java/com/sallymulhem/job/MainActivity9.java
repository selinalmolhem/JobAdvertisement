package com.sallymulhem.job;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

public class MainActivity9 extends AppCompatActivity {
    ImageView imageview1;
    DBHelper DB;
    Context context =this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        final ListView L1 ,L2;

        imageview1 = findViewById(R.id.imageView1);
        L1 =findViewById(R.id.veriler);
        L2 =findViewById(R.id.veriler2);
        imageview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( MainActivity9.this ,MainActivity5.class);
                startActivity(intent);
            }
        });
        if(L1 == null) {
            DB = new DBHelper(this);
            List<String> veriler = DB.VeriListele();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity9.this, android.R.layout.simple_list_item_1, android.R.id.text1, veriler);
            L1.setAdapter(adapter);
        }
        else
            DB = new DBHelper(this);
        List<String> veriler = DB.VeriListele();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity9.this, android.R.layout.simple_list_item_1, android.R.id.text1, veriler);
        L1.setAdapter(adapter);
    }
 }