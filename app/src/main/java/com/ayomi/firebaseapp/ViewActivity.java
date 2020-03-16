package com.ayomi.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ArrayList<DataSetFire> arrayList;
    private FirebaseRecyclerOptions<DataSetFire> options;
    private FirebaseRecyclerAdapter<DataSetFire,FirebaseViewHolder> adapter;
    private DatabaseReference databaseReference;

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<DataSetFire>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("User");
        databaseReference.keepSynced(true);

        options = new FirebaseRecyclerOptions.Builder<DataSetFire>().setQuery(databaseReference,DataSetFire.class).build();

        adapter
                = new FirebaseRecyclerAdapter<DataSetFire, FirebaseViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseViewHolder firebaseViewHolder, int i, @NonNull final DataSetFire dataSetFire) {

                firebaseViewHolder.name.setText(dataSetFire.getName());
                firebaseViewHolder.phone_number.setText(dataSetFire.getPhone());
                firebaseViewHolder.occupation.setText(dataSetFire.getOccupation());
                firebaseViewHolder.address.setText(dataSetFire.getAddress());
                firebaseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ViewActivity.this,Main2Activity.class);
                        intent.putExtra("name", dataSetFire.getName());
                        intent.putExtra("phone",dataSetFire.getPhone());
                        intent.putExtra("occupation",dataSetFire.getOccupation());
                        intent.putExtra("address",dataSetFire.getAddress());
                        startActivity(intent);
                    }
                });

            }

            @NonNull
            @Override
            public FirebaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new FirebaseViewHolder(LayoutInflater.from(ViewActivity.this).inflate(R.layout.row,parent,false));
            }
        };



        recyclerView.setAdapter(adapter);
    }
}
