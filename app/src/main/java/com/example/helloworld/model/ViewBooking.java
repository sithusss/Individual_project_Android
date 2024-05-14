package com.example.helloworld.model;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.DBHandler;
import com.example.helloworld.R;
import com.example.helloworld.adapter.BookingViewAdapter;
import com.example.helloworld.adapter.RecentAdapter;
import com.example.helloworld.adapter.TopPlacesAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewBooking  extends AppCompatActivity {

    RecyclerView viewBookingRecycler;
    BookingViewAdapter bookingViewAdapter;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_booking);

        // Now here we will add some dummy data in our model class

        List<ViewBookingData> viewBookingDataList = new ArrayList<>();
        viewBookingDataList.add(new ViewBookingData(1,"2024.05.10","Sandali Liyanage","200078403106","Queens","Single Bed",2,16000.00));

        setBookingRecycler(viewBookingDataList);

        dbHandler = new DBHandler(this);
    }



    private  void setBookingRecycler(List<ViewBookingData> viewBookingDataList){

        viewBookingRecycler = findViewById(R.id.view_booking_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        viewBookingRecycler.setLayoutManager(layoutManager);
        bookingViewAdapter = new BookingViewAdapter(this,viewBookingDataList);

        viewBookingRecycler.setAdapter(bookingViewAdapter);

    }

}
