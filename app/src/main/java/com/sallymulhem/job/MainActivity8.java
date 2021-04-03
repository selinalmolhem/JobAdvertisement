package com.sallymulhem.job;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity8 extends AppCompatActivity {
Button button4;
    EditText t1,t2,t3,t4,t5,t6,t7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        button4 = findViewById(R.id.button4);
        t1 =findViewById(R.id.t1);
        t2 =findViewById(R.id.t2);
        t3 =findViewById(R.id.t3);
        t4 =findViewById(R.id.t4);
        t5 =findViewById(R.id.t5);
        t6 =findViewById(R.id.t6);
        Context context =this;
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbHelper=new DBHelper(context);
                //dbHelper.onUpgrade(dbHelper.getWritableDatabase(),1,2);
                dbHelper.VeriEkle1(t1.getText().toString(),t2.getText().toString(),t3.getText().toString(),Integer.parseInt(t4.getText().toString()),t5.getText().toString(),t6.getText().toString());
                Intent intent = new Intent ( MainActivity8.this ,MainActivity6.class);
                startActivity(intent);
            }
        });
    }
}