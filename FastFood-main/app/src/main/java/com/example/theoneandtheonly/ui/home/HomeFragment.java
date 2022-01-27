package com.example.theoneandtheonly.ui.home;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.*;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.theoneandtheonly.R;
import com.example.theoneandtheonly.adapters.HomeHorAdapter;
import com.example.theoneandtheonly.adapters.HomeVerAdapter;
import com.example.theoneandtheonly.adapters.UpdateVerticalRec;
import com.example.theoneandtheonly.models.HomeHorModel;
import com.example.theoneandtheonly.models.HomeVerModel;

import java.util.ArrayList;

import javax.annotation.Nonnull;

public class HomeFragment extends Fragment implements UpdateVerticalRec {

RecyclerView homeHorizontalRec,homeVerticalRec;
ArrayList<HomeHorModel> homeHorModelList;
HomeHorAdapter homeHorAdapter;
///////////// vertical
    ArrayList<HomeVerModel>homeVerModelList;
    HomeVerAdapter homeVerAdapter;


    public View onCreateView(@Nonnull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root  = inflater.inflate(R.layout.fragment_home, container, false);

        homeHorizontalRec= root.findViewById(R.id.home_hor_rec);
        homeVerticalRec=root.findViewById(R.id.home_ver_rec);
//////////////  Horizontal Recyclerview
        
        homeHorModelList=new ArrayList<>();
        homeHorModelList.add(new HomeHorModel(R.drawable.pizza,"Pizza"));
        homeHorModelList.add(new HomeHorModel(R.drawable.sandwich,"Sandwich"));
        homeHorModelList.add(new HomeHorModel(R.drawable.ice_cream,"Ice cream"));
        homeHorModelList.add(new HomeHorModel(R.drawable.hamburger,"HamBurger"));
        homeHorModelList.add(new HomeHorModel(R.drawable.fried_potatoes,"Fries"));

        homeHorAdapter= new HomeHorAdapter(this,getActivity(),homeHorModelList);
        homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);

//////////////  vertical Recyclerview

        homeVerModelList=new ArrayList<>();

        homeVerAdapter= new HomeVerAdapter(getActivity(),homeVerModelList);
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));


        return root;

    }


    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list) {
homeVerAdapter=new HomeVerAdapter(getContext(),list);
homeVerAdapter.notifyDataSetChanged();
homeVerticalRec.setAdapter(homeVerAdapter);
    }
}