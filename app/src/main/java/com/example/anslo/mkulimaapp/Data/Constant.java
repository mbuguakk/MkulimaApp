package com.example.anslo.mkulimaapp.Data;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anslo on 10/29/18.
 */

public class Constant {

    public final String TAG= Constant.class.getSimpleName();

    public static List<String> getSoilSamples(Context ctx){
        List<String> mSoilSample=new ArrayList<String>();
        mSoilSample.add("Sample Soil 1");
        mSoilSample.add("Sample Soil 2");
        mSoilSample.add("Sample Soil 3");
        mSoilSample.add("Sample Soil 4");
        mSoilSample.add("Sample Soil 5");
        mSoilSample.add("Sample Soil 6");
        mSoilSample.add("Sample Soil 7");
        mSoilSample.add("Sample Soil 8");
        mSoilSample.add("Sample Soil 9");
        mSoilSample.add("Sample Soil 10");
        mSoilSample.add("Sample Soil 11");
        mSoilSample.add("Sample Soil 12");
        mSoilSample.add("Sample Soil 13");
        mSoilSample.add("Sample Soil 14");
        return mSoilSample;
    }
}
