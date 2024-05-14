package com.example.helloworld.model;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.MainActivity;
import com.example.helloworld.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = findViewById(R.id.login);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button signupButton = findViewById(R.id.main_signup);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle login button click
                // Example: Start MainActivity upon successful login
                Intent intent = new Intent(LoginActivity.this, LoginformActivity.class);
                startActivity(intent);
                finish(); // Optional: Close the LoginActivity
            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle login button click
                // Example: Start MainActivity upon successful login
                Intent intent = new Intent(LoginActivity.this, SignUpformActivity.class);
                startActivity(intent);
                finish(); // Optional: Close the LoginActivity
            }
        });
    }
}

