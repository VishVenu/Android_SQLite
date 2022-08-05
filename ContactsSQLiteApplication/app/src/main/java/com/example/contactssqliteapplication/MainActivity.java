package com.example.contactssqliteapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText nameEdt, telPhoneNumberEdt, emailAddressEdt, addressEdt, imageEdt;
    private Button addUserBtn;
    private Button readAllUserDetailsBtn;
    private Button searchUserDetailsBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all our variables.
        nameEdt = findViewById(R.id.idEdtName);
        telPhoneNumberEdt = findViewById(R.id.idEdtTelNumber);
        emailAddressEdt = findViewById(R.id.idEdtEmailAddress);
        addressEdt = findViewById(R.id.idEdtAddress);
        imageEdt=findViewById(R.id.idEdtImage);
        addUserBtn = findViewById(R.id.idBtnAddUserDetails);
        readAllUserDetailsBtn = findViewById(R.id.idBtnReadAllUserDetails);
        searchUserDetailsBtn = findViewById(R.id.idBtnSearchUser);


        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(MainActivity.this);

        // below line is to add on click listener for our add course button.
        addUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String name = nameEdt.getText().toString();
                String telephoneNumber = telPhoneNumberEdt.getText().toString();
                String emailAddress = emailAddressEdt.getText().toString();
                String address = addressEdt.getText().toString();
                String image = imageEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (name.isEmpty() && telephoneNumber.isEmpty() && emailAddress.isEmpty() && address.isEmpty() && image.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewUser(name, telephoneNumber, emailAddress, address, image);

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "User details has been added.", Toast.LENGTH_SHORT).show();
                nameEdt.setText("");
                emailAddressEdt.setText("");
                telPhoneNumberEdt.setText("");
                addressEdt.setText("");
                imageEdt.setText("");
            }
        });


        readAllUserDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(MainActivity.this, ViewContactsActivity.class);
                startActivity(i);
            }
        });

        searchUserDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEdt.getText().toString();
                if(!name.equals("")) {
                    // opening a new activity via a intent.
                    Intent i = new Intent(MainActivity.this, ViewContactsActivity.class);
                    i.putExtra("name", name);
                    startActivity(i);
                }else{
                    Toast.makeText(MainActivity.this, "Please enter a name to search", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
