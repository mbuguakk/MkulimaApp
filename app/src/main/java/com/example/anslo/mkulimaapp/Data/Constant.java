package com.example.anslo.mkulimaapp.Data;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anslo on 10/29/18.
 */

public class Constant {

    public final String TAG= Constant.class.getSimpleName();

    public static List<SampleSoil> mSoilSample=new ArrayList<SampleSoil>();;

    public static List<SampleSoil> getSoilSamples(Context ctx){
        mSoilSample.add(new SampleSoil("Sample Soil 1"));
        mSoilSample.add(new SampleSoil("Sample Soil 2"));
        mSoilSample.add(new SampleSoil("Sample Soil 3"));
        mSoilSample.add(new SampleSoil("Sample Soil 4"));
        return mSoilSample;
    }



}
