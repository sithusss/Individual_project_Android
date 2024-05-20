package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.helloworld.adapter.RecentAdapter;
import com.example.helloworld.adapter.TopPlacesAdapter;
import com.example.helloworld.model.RecentData;
import com.example.helloworld.model.TopPlacesData;
import com.example.helloworld.model.ViewBooking;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recentRecycler, topPlacesRecycler;
    RecentAdapter recentsAdapter;
    TopPlacesAdapter topPlacesAdapter;

    EditText search;
    ImageButton profile, search_btn;

    List<TopPlacesData> topPlacesDataList;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<RecentData> recentsDataList = new ArrayList<>();
        recentsDataList.add(new RecentData("Aliya Resort", "Sigiriya", "4 Star", R.drawable.hotel1));
        recentsDataList.add(new RecentData("Amaya Beach Passikudah", "Kalkudah", "5 Star", R.drawable.hotel2));
        recentsDataList.add(new RecentData("Amaranthe Bay Resorts & Spa", "Trincomalee", "3 Star", R.drawable.hotel3));
        recentsDataList.add(new RecentData("Amaya Hills", "Kandy", "5 Star", R.drawable.hotel4));
        recentsDataList.add(new RecentData("Amaya Lake", "Dambulla", "5 Star", R.drawable.hotel1));
        recentsDataList.add(new RecentData("Anantara Kalutara Resort", "Kalutara", "5 Star", R.drawable.hotel2));

        setRecentRecycler(recentsDataList);

        topPlacesDataList = new ArrayList<>();
        topPlacesDataList.add(new TopPlacesData("Anantara Peace Heaven Resort", "Tangalle", "5 Star", R.drawable.hotel3));
        topPlacesDataList.add(new TopPlacesData("Araliya Beach Resort", "Unawatuna", "5 Star", R.drawable.hotel4));
        topPlacesDataList.add(new TopPlacesData("Amaara Forest Hotel", "Sigiriya", "Medium", R.drawable.hotel1));
        topPlacesDataList.add(new TopPlacesData("Ani Villas", "Dikwella", "Small", R.drawable.hotel2));
        topPlacesDataList.add(new TopPlacesData("Avani Kalutara Resort", "Kalutara", "Medium", R.drawable.hotel3));
        topPlacesDataList.add(new TopPlacesData("Anantara Peace Heaven Resort", "Tangalle", "5 Star", R.drawable.hotel3));
        topPlacesDataList.add(new TopPlacesData("Araliya Beach Resort", "Unawatuna", "5 Star", R.drawable.hotel4));
        topPlacesDataList.add(new TopPlacesData("Amaara Forest Hotel", "Sigiriya", "Medium", R.drawable.hotel1));

        setTopPlacesRecycler(topPlacesDataList);

        profile = findViewById(R.id.btn_profile);
        search = findViewById(R.id.searchEditText);
        search_btn = findViewById(R.id.search_btn);

        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchString = search.getText().toString().trim();
                if (searchString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a name to search", Toast.LENGTH_SHORT).show();
                    setTopPlacesRecycler(topPlacesDataList);
                } else {
                    List<TopPlacesData> filteredList = searchData(topPlacesDataList, searchString);
                    if (!filteredList.isEmpty()) {
                        updateRecyclerView(filteredList);
                    } else {
                        Toast.makeText(MainActivity.this, "No results found", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewBooking.class);
                startActivity(intent);
            }
        });
    }

    private List<TopPlacesData> searchData(List<TopPlacesData> topPlacesDataList, String searchTerm) {
        List<TopPlacesData> filteredList = new ArrayList<>();
        for (TopPlacesData data : topPlacesDataList) {
            if (data.getPlaceName().equalsIgnoreCase(searchTerm)) {
                filteredList.add(data);
            }
        }
        return filteredList;
    }

    private void updateRecyclerView(List<TopPlacesData> filteredList) {
        topPlacesAdapter = new TopPlacesAdapter(this, filteredList);
        topPlacesRecycler.setAdapter(topPlacesAdapter);
        topPlacesAdapter.notifyDataSetChanged();
    }

    private void setRecentRecycler(List<RecentData> recentsDataList) {
        recentRecycler = findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentAdapter(this, recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);
    }

    private void setTopPlacesRecycler(List<TopPlacesData> topPlacesDataList) {
        topPlacesRecycler = findViewById(R.id.top_places_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        topPlacesRecycler.setLayoutManager(layoutManager);
        topPlacesAdapter = new TopPlacesAdapter(this, topPlacesDataList);
        topPlacesRecycler.setAdapter(topPlacesAdapter);
    }
}
