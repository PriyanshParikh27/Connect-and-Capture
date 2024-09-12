/*
Name: Priyansh Parikh
StudentID: 158341214
Section: MAP524 NSA
Email: pparikh8@myseneca.ca
*/

package com.example.callingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextPhone = findViewById(R.id.editTextPhone);
        Button btnCall = findViewById(R.id.btnCall);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = editTextPhone.getText().toString().trim();

                if (isValidPhoneNumber(phoneNumber)) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + phoneNumber));
                    startActivity(callIntent);
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a valid phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    // Method to validate phone number using RegEx
    private boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^\\+?1\\s\\(\\d{3}\\)\\s\\d{3}-\\d{4}$";
        return phoneNumber.matches(regex);
    }
}
