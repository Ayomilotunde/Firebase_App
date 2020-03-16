package com.ayomi.firebaseapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FirebaseViewHolder extends RecyclerView.ViewHolder {

    public TextView name,phone_number,occupation,address;

    public FirebaseViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.view_name);
        phone_number = itemView.findViewById(R.id.view_phone_number);
        occupation = itemView.findViewById(R.id.view_occupation);
        address = itemView.findViewById(R.id.view_address);
    }
}
