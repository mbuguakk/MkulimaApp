package com.example.anslo.mkulimaapp.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.anslo.mkulimaapp.Activities.ActivityMain;
import com.example.anslo.mkulimaapp.Activities.ActivityTheDetails;
import com.example.anslo.mkulimaapp.Adapters.AdapterFarmingTips;
import com.example.anslo.mkulimaapp.Data.Crop;
import com.example.anslo.mkulimaapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul Mburu on 10/27/18.
 */

public class FarmingTipsFragment extends Fragment {
    View view;

    public FarmingTipsFragment(){}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_farming_tips,container,false);
        final List<Crop> cropList=new ArrayList<>();
        cropList.add(new Crop("Oranges","pH value: 6.0 to 7.5",R.drawable.oranges_app));
        cropList.add(new Crop("Tomatoes","pH value: 3.5 to 4.7",R.drawable.tomatoes3_app));
        cropList.add(new Crop("Onions","pH value: 5.5 to 6.5",R.drawable.onions_app));
        cropList.add(new Crop("Sunflower","pH value: 6.0 to 7.5",R.drawable.sunflower2_app));
        cropList.add(new Crop("Cabbage","pH value: between 6.5 and 6.8",R.drawable.cabbage_app));



        AdapterFarmingTips adapterFarmingTips=new AdapterFarmingTips(this.getContext(),0,cropList);
        ListView listView=(ListView)view.findViewById(R.id.farming_tips_listview_id);
        listView.setAdapter(adapterFarmingTips);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ActivityTheDetails.navigate((ActivityMain)getActivity(),view,cropList.get(position));
            }
        });

        return view;
    }
}
