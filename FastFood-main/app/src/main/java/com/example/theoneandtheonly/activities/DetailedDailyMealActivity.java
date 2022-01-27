package com.example.theoneandtheonly.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.theoneandtheonly.R;
import com.example.theoneandtheonly.adapters.DetailedDailyMealAdapter;
import com.example.theoneandtheonly.adapters.HomeVerAdapter;
import com.example.theoneandtheonly.models.DetailedDailyMealModel;

import java.util.ArrayList;
import java.util.List;

public class DetailedDailyMealActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<DetailedDailyMealModel> detailedDailyModelsList;
    DetailedDailyMealAdapter dailyAdapter;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_daily_meal);

        String type = getIntent().getStringExtra("type");

        recyclerView = findViewById(R.id.detailed_rec);
        imageView = findViewById(R.id.detailed_img);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailedDailyModelsList = new ArrayList<>();
        dailyAdapter = new DetailedDailyMealAdapter(detailedDailyModelsList);
        recyclerView.setAdapter(dailyAdapter);

        if (type != null && type.equalsIgnoreCase("breakfast")) {
            detailedDailyModelsList.add(new DetailedDailyMealModel(R.drawable.fav1, "Breakfast", "description", "4.4", "40", "10am to 8pm"));
            detailedDailyModelsList.add(new DetailedDailyMealModel(R.drawable.fav2, "Breakfast", "description", "4.4", "40", "10am to 8pm"));
            detailedDailyModelsList.add(new DetailedDailyMealModel(R.drawable.fav3, "Breakfast", "description", "4.4", "40", "10am to 8pm"));
            dailyAdapter.notifyDataSetChanged();
        }

        if (type != null && type.equalsIgnoreCase("sweets")){

            imageView.setImageResource(R.drawable.sweets);
            detailedDailyModelsList.add(new DetailedDailyMealModel(R.drawable.s1, "sweets", "description", "4.4", "40", "10am to 8pm"));
            detailedDailyModelsList.add(new DetailedDailyMealModel(R.drawable.s2, "sweets", "description", "4.4", "40", "10am to 8pm"));
            detailedDailyModelsList.add(new DetailedDailyMealModel(R.drawable.s3, "sweets", "description", "4.4", "40", "10am to 8pm"));
            detailedDailyModelsList.add(new DetailedDailyMealModel(R.drawable.s4, "sweets", "description", "4.4", "40", "10am to 8pm"));
            dailyAdapter.notifyDataSetChanged();
        }
    }}