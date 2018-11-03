package com.example.anslo.mkulimaapp.Adapters;

import android.app.Activity;
import android.widget.ArrayAdapter;

import com.example.anslo.mkulimaapp.Data.SampleSoil;

import java.util.ArrayList;

/**
 * Created by Paul Mburu on 11/2/18.
 */

public class AdapterSampleSoil extends ArrayAdapter<SampleSoil>{
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param words A List of AndroidFlavor objects to display in a list
     */
    public AdapterSampleSoil(Activity context, ArrayList<SampleSoil> words) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
    }

}
