package com.example.helloworld.model;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.DBHandler;
import com.example.helloworld.MainActivity;
import com.example.helloworld.R;


public class LoginformActivity extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    Button buttonLogin;

    DBHandler dbHandler;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "myPref";
    private static final String KEY_NIC = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginform);

        dbHandler = new DBHandler(this);

        editTextEmail = findViewById(R.id.login_email);
        editTextPassword = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.signin);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String pw = sharedPreferences.getString(KEY_NIC,null);
        if(pw != null){
            Intent intent = new Intent(LoginformActivity.this, MainActivity.class);
            startActivity(intent);
        }


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NIC,password);
                editor.apply();

                if (TextUtils.isEmpty(email)) {
                    editTextEmail.setError("Enter email address");
                    editTextEmail.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    editTextPassword.setError("Enter password");
                    editTextPassword.requestFocus();
                    return;
                }

                boolean isValidUser = dbHandler.validateUser(email, password);

                if (isValidUser) {
                    // User authenticated
                    Toast.makeText(LoginformActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginformActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    // Proceed to next activity or perform desired action
                } else {
                    // Authentication failed
                    Toast.makeText(LoginformActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}

