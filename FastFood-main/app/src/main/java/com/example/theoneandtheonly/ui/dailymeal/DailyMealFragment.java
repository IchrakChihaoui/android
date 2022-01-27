package com.example.theoneandtheonly.ui.dailymeal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.theoneandtheonly.R;
import com.example.theoneandtheonly.adapters.DailyMealAdapter;
import com.example.theoneandtheonly.models.DailyMealModel;

import java.util.ArrayList;
import java.util.List;


public class DailyMealFragment extends Fragment {
    RecyclerView recyclerView;
    List<DailyMealModel> dailyMealModels;
    DailyMealAdapter dailyMealAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_daily_meal, container, false);


        recyclerView=root.findViewById(R.id.daily_meal_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dailyMealModels=new ArrayList<>();


        dailyMealModels.add(new DailyMealModel(R.drawable.eggs,"Breakfast","30% OFF","Description","breakfast"));
        dailyMealModels.add(new DailyMealModel(R.drawable.makrouna,"Lunch","10% OFF","Description","Lunch"));
        dailyMealModels.add(new DailyMealModel(R.drawable.dinner,"Dinner","20% OFF","Description","Dinner"));
        dailyMealModels.add(new DailyMealModel(R.drawable.coffe,"coffee","50% OFF","Description","Coffee" ));
        dailyMealModels.add(new DailyMealModel(R.drawable.sweets,"sweets","50% OFF","Description","sweets" ));

        dailyMealAdapter=new DailyMealAdapter(getContext(),dailyMealModels);
        recyclerView.setAdapter(dailyMealAdapter);
        dailyMealAdapter.notifyDataSetChanged();


        return root;
    }


}