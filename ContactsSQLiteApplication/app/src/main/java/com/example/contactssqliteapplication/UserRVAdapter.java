package com.example.contactssqliteapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserRVAdapter extends RecyclerView.Adapter<UserRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<UserModal> userModalArrayList;
    private Context context;

    // constructor
    public UserRVAdapter(ArrayList<UserModal> userModalArrayList, Context context) {
        this.userModalArrayList = userModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        UserModal modal = userModalArrayList.get(position);
        holder.nameTV.setText(modal.getName());
        holder.telephoneNumberTV.setText(modal.getTelephoneNumber());
        holder.emailAddressTV.setText(modal.getEmailAddress());
        holder.addressTV.setText(modal.getAddress());

        // below line is to add on click listener for our recycler view item.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are calling an intent.
                Intent i = new Intent(context, UpdateContactsActivity.class);

                // below we are passing all our values.
                i.putExtra("name", modal.getName());
                i.putExtra("telephoneNumber", modal.getTelephoneNumber());
                i.putExtra("emailAddress", modal.getEmailAddress());
                i.putExtra("address", modal.getAddress());

                // starting our activity.
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return userModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView nameTV, telephoneNumberTV, emailAddressTV, addressTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            nameTV = itemView.findViewById(R.id.idTVName);
            telephoneNumberTV = itemView.findViewById(R.id.idTVTelNumber);
            emailAddressTV = itemView.findViewById(R.id.idTVEmailAddress);
            addressTV = itemView.findViewById(R.id.idTVAddress);
        }
    }
}
