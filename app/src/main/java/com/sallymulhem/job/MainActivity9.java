package com.sallymulhem.job;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

public class MainActivity9 extends AppCompatActivity {
    ImageView imageview1;
    DBHelper DB;
    Context context =this;
    List<String> veriler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        final ListView L1 ,L2;


        L1 =findViewById(R.id.veriler1);
        L2 =findViewById(R.id.veriler2);
        DB = new DBHelper(this);
        veriler = DB.VeriListele();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity9.this, android.R.layout.simple_list_item_1, android.R.id.text1, veriler);
        L1.setAdapter(adapter);
L1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent ( MainActivity9.this ,MainActivity5.class);
        startActivity(intent);
    }
});





    }
 }