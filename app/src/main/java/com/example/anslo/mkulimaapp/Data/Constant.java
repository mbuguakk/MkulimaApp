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

    public static List<String> getOrangeDetails(Context ctx){
        List<String> orangeItems=new ArrayList<>();
        orangeItems.add("Plant type: Fruit");
        orangeItems.add("Sun exposure: Full sun");
        orangeItems.add("Soil type: Loamy");
        orangeItems.add("Orange trees need a soil pH of 6.0 to 7.5");
        orangeItems.add("Soil should be slightly acidic to neutral range");

        return orangeItems;
    }

    public static List<String> getTomatoesDetails(Context ctx){
        List<String> tomatoeItems=new ArrayList<>();
        tomatoeItems.add("Plant type: Vegetable");
        tomatoeItems.add("soil pH value: 3.5-4.7");
        tomatoeItems.add("Sun exposure: Full sun");
        tomatoeItems.add("Soil type: Loamy");

        return tomatoeItems;
    }

    public static List<String> getOnionDetails(Context ctx){
        List<String> onionItems=new ArrayList<>();
        onionItems.add("Plant type: Vegetable");
        onionItems.add("pH value: 5.5 to 6.5");
        onionItems.add("Soil type: any,loamy");
        onionItems.add("Sun exposure: Full Sun");

        return onionItems;
    }

    public static List<String> getSunflowerDetails(Context ctx){
        List<String> onionItems=new ArrayList<>();
        onionItems.add("Plant type: Flower");
        onionItems.add("pH value: 5.5 to 6.5 (Alkaline/Basic, Neutral) ");
        onionItems.add("Soil type: loamy,Sandy");
        onionItems.add("sunflowers thrive in slightly acidic to somewhat alkaline soil ");
        onionItems.add("Sunflowers grow best in locations with direct sunlight (6 to 8 hours per day)");
        onionItems.add("Bloom type: summer");
        onionItems.add("Special features: Attracts Birds, Attracts Butterflies");
        return onionItems;
    }

    public static List<String> getCabbageDetails(Context ctx){
        List<String> cabbageItems=new ArrayList<>();
        cabbageItems.add("Plant Type: Vegetable");
        cabbageItems.add("pH value: between 6.5 and 6.8");
        cabbageItems.add("Sun Exposure: Full Sun");
        cabbageItems.add("Soil Type: Loamy, Sandy");
        return cabbageItems;
    }

}
