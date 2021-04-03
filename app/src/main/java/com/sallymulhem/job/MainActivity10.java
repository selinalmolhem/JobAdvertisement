package com.sallymulhem.job;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity10 extends AppCompatActivity {

    DBHelper DB;
    Context context =this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        final ListView L1 ;
        L1=(ListView)findViewById(R.id.veriler2);;

        DB = new DBHelper(MainActivity10.this);
        List<String> veriler2 = DB.VeriListele1();
        System.out.println("ufhhhfuufcdkjkjkckccmcöckckkdkld**d*d*d**d**********************d*d**d*d*d*dd*d*d*d*d*d*d*d**f*f*f*f**rr*r**f*f**c**c*d**dd*d*d**d*d*dd**d*dd*d*d**d*d*d**dd**d*d*d**dd**dd**d*d*dd**d*d**d*d*d*d");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1, veriler2);
        System.out.println("2222222ufhhhfuufcdkjkjkckccmcöckckkdkld**d*d*d**d**********************d*d**d*d*d*dd*d*d*d*d*d*d*d**f*f*f*f**rr*r**f*f**c**c*d**dd*d*d**d*d*dd**d*dd*d*d**d*d*d**dd**d*d*d**dd**dd**d*d*dd**d*d**d*d*d*d");


        L1.setAdapter(adapter);
    System.out.println("3333ufhhhfuufcdkjkjkckccmcöckckkdkld**d*d*d**d**********************d*d**d*d*d*dd*d*d*d*d*d*d*d**f*f*f*f**rr*r**f*f**c**c*d**dd*d*d**d*d*dd**d*dd*d*d**d*d*d**dd**d*d*d**dd**dd**d*d*dd**d*d**d*d*d*d");

    }}