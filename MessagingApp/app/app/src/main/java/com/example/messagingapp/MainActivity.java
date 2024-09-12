/*
Name: Priyansh Parikh
StudentID: 158341214
Section: MAP524 NSA
Email: pparikh8@myseneca.ca
*/

package com.example.messagingapp;

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
        EditText editTextMessage = findViewById(R.id.editTextMessage);
        Button btnSendMessage = findViewById(R.id.btnSendMessage);

        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = editTextPhone.getText().toString().trim();
                String message = editTextMessage.getText().toString().trim();

                // Validate phone number
                if (!isValidPhoneNumber(phoneNumber)) {
                    Toast.makeText(MainActivity.this, "Please enter a valid phone number", Toast.LENGTH_SHORT).show();
                    return;
                }
                // Validate message
                if (message.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a message", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Send message
                Intent messageIntent = new Intent(Intent.ACTION_VIEW);
                messageIntent.setData(Uri.parse("sms:" + phoneNumber));
                messageIntent.putExtra("sms_body", message);
                startActivity(messageIntent);
            }
        });
    }
    // Method to validate phone number using RegEx
    private boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^\\+?1\\s\\(\\d{3}\\)\\s\\d{3}-\\d{4}$";
        return phoneNumber.matches(regex);
    }
}
