package com.example.helloworld.model;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.DBHandler;
import com.example.helloworld.MainActivity;
import com.example.helloworld.R;

public class SignUpformActivity extends AppCompatActivity {

    Button signup;
    DBHandler dbHandler;
    EditText nicEditText, nameEditText, emailEditText, phoneEditText, addressEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupform);

        // Additional setup for your details activity
        dbHandler = new DBHandler(this);

        nicEditText = findViewById(R.id.nic);
        nameEditText = findViewById(R.id.name);
        emailEditText = findViewById(R.id.email);
        phoneEditText = findViewById(R.id.phone);
        addressEditText = findViewById(R.id.address);

        signup = findViewById(R.id.signin);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_nic = nicEditText.getText().toString();
                String s_name = nameEditText.getText().toString();
                String s_email = emailEditText.getText().toString();
                String s_phone = phoneEditText.getText().toString();
                String s_address = addressEditText.getText().toString();

                Boolean checkinsertData = dbHandler.addNewMember(s_nic, s_name, s_phone, s_address, s_email);

                if (checkinsertData == true) {
                    Toast.makeText(SignUpformActivity.this, "Register Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpformActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(SignUpformActivity.this, "Error in Register", Toast.LENGTH_SHORT).show();
                }
                 // Optional: Close the LoginActivity

            }
        });
    }
}
