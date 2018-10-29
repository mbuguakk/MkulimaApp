package com.example.anslo.mkulimaapp.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.anslo.mkulimaapp.Data.Constant;
import com.example.anslo.mkulimaapp.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.anslo.mkulimaapp.Data.Constant.getSoilSamples;

/**
 * Created by Paul Mburu/ on 10/27/18.
 */

public class SampleSoilFragment extends Fragment {
    View view;
    // Store dummy data for samples
    List<String> soilSamples=new ArrayList<>();
    public SampleSoilFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_sample_soil,container,false);
        // get the dummy data for Sample Soils
        final List<String> mSampleSoil= getSoilSamples(getActivity());
        // Display the data on the Sample soil Fragment
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(),
                android.R.layout.simple_list_item_1, mSampleSoil);
        //set adapter to the ListView
        ListView listView = (ListView) view.findViewById(R.id.list);
        listView.setAdapter(adapter);


        return view;
    }
}
