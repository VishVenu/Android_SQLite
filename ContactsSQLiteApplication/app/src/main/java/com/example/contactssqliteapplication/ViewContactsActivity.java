package com.example.contactssqliteapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewContactsActivity extends AppCompatActivity {

    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<UserModal> userModalArrayList;
    private DBHandler dbHandler;
    private UserRVAdapter userRVAdapter;
    private RecyclerView contactsRV;
    private String name;
    private TextView emptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contacts);

        // initializing our all variables.
        userModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewContactsActivity.this);
        contactsRV = findViewById(R.id.idRVCourses);
        emptyView=findViewById(R.id.idEmptyView);

        //get the search item
        if(getIntent().hasExtra("name")) {
            name = getIntent().getStringExtra("name");
            userModalArrayList = dbHandler.readUser(name);
        }else{
            userModalArrayList = dbHandler.readUsers();
        }

        if (userModalArrayList.isEmpty()) {
            contactsRV.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        }
        else { // on below line passing our array lost to our adapter class.
            userRVAdapter = new UserRVAdapter(userModalArrayList, ViewContactsActivity.this);

            // setting layout manager for our recycler view.
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewContactsActivity.this, RecyclerView.VERTICAL, false);
            contactsRV.setLayoutManager(linearLayoutManager);

            // setting our adapter to recycler view.
            contactsRV.setAdapter(userRVAdapter);
            contactsRV.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
        }
    }
}
