package com.example.contactssqliteapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateContactsActivity extends AppCompatActivity {

    // variables for our edit text, button, strings and dbhandler class.
    private EditText nameEdt, telPhoneNumberEdt, emailAddressEdt, addressEdt;
    private Button updateUserBtn;
    private Button deleteUserBtn;
    private DBHandler dbHandler;
    String name, telephoneNumber, emailAddress, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contacts);

        // initializing all our variables.
        nameEdt = findViewById(R.id.idEdtUpdateName);
        telPhoneNumberEdt = findViewById(R.id.idEdtUpdateTelNumber);
        emailAddressEdt = findViewById(R.id.idEdtUpdateEmailAddress);
        addressEdt = findViewById(R.id.idEdtUpdateAddress);
        updateUserBtn = findViewById(R.id.idBtnUpdateUserDetails);
        deleteUserBtn = findViewById(R.id.idBtnDeleteUserDetails);

        // on below line we are initialing our dbhandler class.
        dbHandler = new DBHandler(UpdateContactsActivity.this);

        // on below lines we are getting data which
        // we passed in our adapter class.
        name = getIntent().getStringExtra("name");
        telephoneNumber = getIntent().getStringExtra("telephoneNumber");
        emailAddress = getIntent().getStringExtra("emailAddress");
        address = getIntent().getStringExtra("address");

        // setting data to edit text
        // of our update activity.
        nameEdt.setText(name);
        telPhoneNumberEdt.setText(telephoneNumber);
        emailAddressEdt.setText(emailAddress);
        addressEdt.setText(address);

        // adding on click listener to our update course button.
        updateUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inside this method we are calling an update course
                // method and passing all our edit text values.
                dbHandler.updateContact(name, nameEdt.getText().toString(), telPhoneNumberEdt.getText().toString(), emailAddressEdt.getText().toString(), addressEdt.getText().toString());

                // displaying a toast message that our course has been updated.
                Toast.makeText(UpdateContactsActivity.this, "User Details Updated..", Toast.LENGTH_SHORT).show();

                // launching our main activity.
                Intent i = new Intent(UpdateContactsActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        // adding on click listener for delete button to delete our course.
        deleteUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling a method to delete our course.
                dbHandler.deleteContact(name);
                Toast.makeText(UpdateContactsActivity.this, "Deleted the contact", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateContactsActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}
