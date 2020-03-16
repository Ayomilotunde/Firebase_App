package com.ayomi.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String name = getIntent().getStringExtra("name");
        String Phone = getIntent().getStringExtra("phone_number");
        String occupation = getIntent().getStringExtra("occupation");
        String address = getIntent().getStringExtra("address");
        Log.i("OUR VALUE", name);
        Toast.makeText(this, ""+name, Toast.LENGTH_SHORT).show();
    }
}
