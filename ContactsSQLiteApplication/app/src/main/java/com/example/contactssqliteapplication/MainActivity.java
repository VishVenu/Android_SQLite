package com.example.contactssqliteapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText nameEdt, telPhoneNumberEdt, emailAddressEdt, addressEdt;
    private Button addUserBtn;
    private Button readAllUserDetailsBtn;
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
        addUserBtn = findViewById(R.id.idBtnAddUserDetails);
        readAllUserDetailsBtn = findViewById(R.id.idBtnReadAllUserDetails);

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

                // validating if the text fields are empty or not.
                if (name.isEmpty() && telephoneNumber.isEmpty() && emailAddress.isEmpty() && address.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewUser(name, emailAddress, address, telephoneNumber);

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "User details has been added.", Toast.LENGTH_SHORT).show();
                nameEdt.setText("");
                emailAddressEdt.setText("");
                telPhoneNumberEdt.setText("");
                addressEdt.setText("");
            }
        });
    }
}
