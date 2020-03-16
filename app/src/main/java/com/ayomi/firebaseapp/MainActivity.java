package com.ayomi.firebaseapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText name, number, occupation, address;
    Button btnsubmit;

    FirebaseDatabase database;
    DatabaseReference ref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         name = findViewById(R.id.edtname);
         number = findViewById(R.id.edtphone_number);
        occupation = findViewById(R.id.edtoccupation);
        address = findViewById(R.id.edtaddress);
        btnsubmit = findViewById(R.id.btnsubmit);

        //ref = database.getReference();

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!(name.getText().toString().equals("") || number.getText().toString().equals("")
                    || occupation.getText().toString().equals("") || address.getText().toString().equals(""))){
                        getValues();
                    setContentView(R.layout.activity_main2);
                } else{
                    Toast.makeText(MainActivity.this, "All field required", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    private void getValues(){

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("User");

        String uniqueId = ref.push().getKey();

        User user = new User();
        user.setName(name.getText().toString());
        user.setPhone(number.getText().toString());
        user.setOccupation(occupation.getText().toString());
        user.setAddress(address.getText().toString());



        ref.child(uniqueId).setValue(user);
        Toast.makeText(MainActivity.this, "Data Inputed...",Toast.LENGTH_SHORT).show();

    }

    public void btnView(View view) {
        Intent intent = new Intent(this, ViewActivity.class);
        startActivity(intent);
    }

    public void btnSubmit(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
