package com.sallymulhem.job;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity7 extends AppCompatActivity {
Button button8;
EditText t1,t2,t3,t4,t5,t6,t7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        t1 =findViewById(R.id.ad);
        t2 =findViewById(R.id.adres);
        t3 =findViewById(R.id.acıklama);
        t4 =findViewById(R.id.tel);
        t5 =findViewById(R.id.ozelık);
        t6 =findViewById(R.id.zaman);
        t7 =findViewById(R.id.maas);
        button8 = findViewById(R.id.button8);
        Context context =this;
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // int d = Integer.parseInt(t6.getText().toString());

              //  DBHelper dbHelper=new DBHelper(MainActivity7.this);
                DBHelper dbHelper=new DBHelper(context);
                dbHelper.onUpgrade(dbHelper.getWritableDatabase(),1,2);
                dbHelper.VeriEkle(t1.getText().toString(),t2.getText().toString(),t3.getText().toString(),t4.getText().toString(),t5.getText().toString(),Integer.parseInt(t6.getText().toString()),Integer.parseInt(t7.getText().toString()));
                Intent intent = new Intent ( MainActivity7.this ,MainActivity9.class);
                startActivity(intent);
            }
        });
        //Buradan bilgileri mainactivty9'a getirecek.....
    }
}