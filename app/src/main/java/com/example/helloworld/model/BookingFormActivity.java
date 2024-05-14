package com.example.helloworld.model;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.DBHandler;
import com.example.helloworld.MainActivity;
import com.example.helloworld.R;

public class BookingFormActivity extends AppCompatActivity {


    Button booking;
    DBHandler dbHandler;
    EditText hotelNameEditText, RoomTypeEditText, NoRoomsEditText;
    TextView shared_nic;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "myPref";
    private static final String KEY_NIC = "password";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookingform);

        // Additional setup for your details activity

        shared_nic = findViewById(R.id.shared_nic);
        dbHandler = new DBHandler(this);

        hotelNameEditText = findViewById(R.id.booking_Hname);
        RoomTypeEditText = findViewById(R.id.booking_RoomType);
        NoRoomsEditText = findViewById(R.id.no_OfRooms);


        booking = findViewById(R.id.bookingbtn);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String nic = sharedPreferences.getString(KEY_NIC,null);

        if(nic != null){
            shared_nic.setText("NIC: "+nic);
        }

        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
                String s_nic = nic;
                String s_hname = hotelNameEditText.getText().toString();
                String s_roomType= RoomTypeEditText.getText().toString();
                int noOfRooms = Integer.parseInt(NoRoomsEditText.getText().toString());
                double room_price = 8000;

                Boolean checkinsertData = dbHandler.addBooking(s_nic,s_hname,s_roomType,noOfRooms,room_price);

                if (checkinsertData == true) {
                    Toast.makeText(BookingFormActivity.this, "Booking added Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(BookingFormActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(BookingFormActivity.this, "Error in Booking", Toast.LENGTH_SHORT).show();
                }
                // Optional: Close the LoginActivity

            }
        });
    }
}
