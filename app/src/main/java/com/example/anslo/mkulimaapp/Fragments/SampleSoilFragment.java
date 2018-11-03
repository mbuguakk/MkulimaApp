package com.example.anslo.mkulimaapp.Fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.anslo.mkulimaapp.Activities.ActivityMain;
import com.example.anslo.mkulimaapp.Data.Constant;
import com.example.anslo.mkulimaapp.Data.SampleSoil;
import com.example.anslo.mkulimaapp.Data.Tools;
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
    private List<String> items=new ArrayList<>();
    private AdapterView.OnItemClickListener mOnItemClickListener;
    public SampleSoilFragment(){}


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_sample_soil,container,false);

        // get the dummy data for Sample Soils
//        final List<SampleSoil> mSampleSoil= getSoilSamples(getActivity());
       items.add("Sample soil 1");
       items.add("Sample soil 2");
       items.add("Sample soil 3");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(),
                android.R.layout.simple_list_item_1, items);


        final ListView listView = (ListView) view.findViewById(R.id.list);
        //set adapter to the ListView
        listView.setAdapter(adapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String name=view;
//            Toast.makeText(getContext(),name+" Clicked",Toast.LENGTH_SHORT).show();
//            }
//        });

        FloatingActionButton floatingActionButton=(FloatingActionButton)view.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogManageSoilSamples();
            }
        });

        return view;
    }

    private void dialogManageSoilSamples(){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("New Soil Sample");

        final EditText input = new EditText(getActivity());
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        input.setMaxLines(0);
        input.setSingleLine(true);
        input.setEms(100);
        input.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        input.setHint("name of the Sample Soil");
        input.setText("");

        LinearLayout lyt = new LinearLayout(getActivity());
        int padding = Tools.dpToPx(getActivity(), 20);
        lyt.setPadding(padding, padding, padding, padding);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lyt.setLayoutParams(params);
        lyt.addView(input);
        builder.setView(lyt);

        builder.setPositiveButton("CREATE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = input.getText().toString().trim();
                if (name.isEmpty()) {
                    Toast.makeText(getActivity(), "Sample Soil name cannot empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!name.isEmpty())
                    items.add(name);
                Toast.makeText(getActivity(), "Sample Soil added", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();

    }

}
