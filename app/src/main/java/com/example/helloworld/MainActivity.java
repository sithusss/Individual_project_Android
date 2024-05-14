package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.helloworld.adapter.RecentAdapter;
import com.example.helloworld.adapter.TopPlacesAdapter;
import com.example.helloworld.model.LoginActivity;
import com.example.helloworld.model.RecentData;
import com.example.helloworld.model.SignUpformActivity;
import com.example.helloworld.model.TopPlacesData;
import com.example.helloworld.model.ViewBooking;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recentRecycler, topPlacesRecycler;
    RecentAdapter recentsAdapter;
    TopPlacesAdapter topPlacesAdapter;

    ImageButton profile;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Now here we will add some dummy data in our model class

        List<RecentData> recentsDataList = new ArrayList<>();
        recentsDataList.add(new RecentData("Aliya Resort & Spa"," Sigiriya","4 Star",R.drawable.hotel1));
        recentsDataList.add(new RecentData("Amaya Beach Passikudah","Kalkudah","5 Star",R.drawable.hotel2));
        recentsDataList.add(new RecentData("Amaranthe Bay Resorts & Spa","Trincomalee","3 Star",R.drawable.hotel3));
        recentsDataList.add(new RecentData("Amaya Hills","Kandy","5 Star",R.drawable.hotel4));
        recentsDataList.add(new RecentData("Amaya Lake","Dambulla","5 Star",R.drawable.hotel1));
        recentsDataList.add(new RecentData("Anantara Kalutara Resort","Kalutara","5 Star",R.drawable.hotel2));

        setRecentRecycler(recentsDataList);

        List<TopPlacesData> topPlacesDataList = new ArrayList<>();
        topPlacesDataList.add(new TopPlacesData("Anantara Peace Heaven Resort","Tangalle","5 Star",R.drawable.hotel3));
        topPlacesDataList.add(new TopPlacesData("Araliya Beach Resort","Unawatuna","5 Star",R.drawable.hotel4));
        topPlacesDataList.add(new TopPlacesData("Amaara Forest Hotel","Sigiriya","Medium",R.drawable.hotel1));
        topPlacesDataList.add(new TopPlacesData("Ani Villas","Dikwella","Samll",R.drawable.hotel2));
        topPlacesDataList.add(new TopPlacesData("Avani Kalutara Resort","Kalutara","Mediium",R.drawable.hotel3));

        setTopPlacesRecycler(topPlacesDataList);

        profile = findViewById(R.id.btn_profile);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewBooking.class);
                startActivity(intent);
            }
        });


    }

    private  void setRecentRecycler(List<RecentData> recentsDataList){

        recentRecycler = findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentAdapter(this, recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);

    }

    private  void setTopPlacesRecycler(List<TopPlacesData> topPlacesDataList){

        topPlacesRecycler = findViewById(R.id.top_places_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        topPlacesRecycler.setLayoutManager(layoutManager);
        topPlacesAdapter = new TopPlacesAdapter(this, topPlacesDataList);
        topPlacesRecycler.setAdapter(topPlacesAdapter);

    }



    // Hi all, today we are going to make a holiday tour app.
    // so lets see i will show you what we are going to build
    // so lets get started.
    // before getting started make sure to subscribe and hit the bell i con to get notified
    // everytime i post a video.
    // lets first import image assets
    // Now we will add a recycler view for recents data.
    // lets make a model class first.
    // now we create a adapter class for holding data
    // our adapter class is ready now we will setup recyclerview

    // So we have setup recents items recyclerview
    //Now we do same setup for top places
    // lets do it fast.
    // Now i will add a bottom navigation
    // now we will set the details activity
    // when user click on any of places details activity will open
    // So this app is done.
    // Please like share and subscribe
    // if any question plz do comment
    // Thanks for watching see you in the next tutorial

}

