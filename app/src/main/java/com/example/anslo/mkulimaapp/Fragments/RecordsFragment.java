package com.example.anslo.mkulimaapp.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anslo.mkulimaapp.R;

/**
 * Created by Paul Mburu on 10/27/18.
 */

public class RecordsFragment extends Fragment{
    View view;
    public RecordsFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_records,container,false);
        return view;
    }
}
