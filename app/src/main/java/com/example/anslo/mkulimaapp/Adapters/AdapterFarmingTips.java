package com.example.anslo.mkulimaapp.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anslo.mkulimaapp.Data.Crop;
import com.example.anslo.mkulimaapp.Fragments.FarmingTipsFragment;
import com.example.anslo.mkulimaapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anslo on 11/4/18.
 */

public class AdapterFarmingTips extends ArrayAdapter<Crop> {
    public AdapterFarmingTips(@NonNull Context context, int resource, @NonNull List<Crop> objects) {
        super(context, resource, objects);
    }


//    /**
//     * This is our own custom constructor (it doesn't mirror a superclass constructor).
//     * The context is used to inflate the layout file, and the list is the data we want
//     * to populate into the lists.
//     *  @param context        The current context. Used to inflate the layout file.
//     * @param crops A List of crop objects to display in a list
//     */
//    public AdapterFarmingTips(FarmingTipsFragment context, List<Crop> crops,int i) {
//        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
//        // the second argument is used when the ArrayAdapter is populating a single TextView.
//        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
//        // going to use this second argument, so it can be any value. Here, we used 0.
//        super(context, 0, crops);
//    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Crop currentCrop = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID crop_text_view
        TextView cropTextView = (TextView) listItemView.findViewById(R.id.crop_text_view);
        // set this text on the miwok TextView
        cropTextView.setText(currentCrop.getCropName());

        // Find the TextView in the list_item.xml layout with the ID default_text_view
        TextView phValueTextView = (TextView) listItemView.findViewById(R.id.phValue_text_view);
        // Get the default translation from the current word object and
        // set this text on the default TextView
        phValueTextView.setText(currentCrop.getSoilPh());

        // Find the ImageView in the list_item.xml layout with the ID image
        ImageView iconView=(ImageView) listItemView.findViewById(R.id.image);

        // Get the image resource ID from the current crop object
        if(currentCrop.hasImage()) {
            // Set this image resource on the
            iconView.setImageResource(currentCrop.getImageResourceId());
        }else{
            iconView.setVisibility(View.GONE);
        }



        return listItemView;
    }
}
