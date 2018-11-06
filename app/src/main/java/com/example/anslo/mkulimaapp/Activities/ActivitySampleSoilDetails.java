package com.example.anslo.mkulimaapp.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputFilter;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anslo.mkulimaapp.Data.Crop;
import com.example.anslo.mkulimaapp.Data.Tools;
import com.example.anslo.mkulimaapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul Mburu on 11/1/18.
 */

public class ActivitySampleSoilDetails extends AppCompatActivity {

    public static final String EXTRA_OBJCT = "key.OBJCT";
    private   String name;
    private String cropAnalysisName="";
    public Crop currentCrop=null;
    private Button mButtonLoad;
    private Button mButtonDelete;
    public static List<String> mSoilDetails=new ArrayList<>();

    // give preparation animation activity transition
    public static void navigate(AppCompatActivity activity, View transitionImage, String obj) {
        Intent intent = new Intent(activity, ActivitySampleSoilDetails.class);
        intent.putExtra(EXTRA_OBJCT, obj);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, transitionImage, EXTRA_OBJCT);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_soil_details);
        name=(String)getIntent().getSerializableExtra(EXTRA_OBJCT);

        final TextView mSampleSoilName=(TextView)findViewById(R.id.sample_soil_name);
        mSampleSoilName.setText(name);

        final List<Crop> cropList=new ArrayList<>();
        cropList.add(new Crop("Oranges","pH value: 6.0 to 7.5",R.drawable.oranges_app));
        cropList.add(new Crop("Tomatoes","pH value: 3.5 to 4.7",R.drawable.tomatoes3_app));
        cropList.add(new Crop("Onions","pH value: 5.5 to 6.5",R.drawable.onions_app));
        cropList.add(new Crop("Sunflower","pH value: 6.0 to 7.5",R.drawable.sunflower2_app));
        cropList.add(new Crop("Cabbage","pH value: between 6.5 and 6.8",R.drawable.cabbage_app));


        for(Crop c:cropList){
            if(c.getCropName().equals(cropAnalysisName))
                currentCrop=c;
        }


        mButtonLoad=(Button)findViewById(R.id.button_load);
        mButtonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogLoadData();
                Toast.makeText(getBaseContext(),"load Clicked",Toast.LENGTH_SHORT).show();
            }
        });


        ListView  listView=(ListView)findViewById(R.id.listView);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mSoilDetails);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(mSoilDetails.get(position).equals("CROP ANALYSIS")){
                    dialogCropAnalysis();
                    Toast.makeText(getBaseContext(),"CROP ANALYSIS CLICKED",Toast.LENGTH_SHORT).show();
//                    ActivityTheDetails.navigate(ActivitySampleSoilDetails.this,view,currentCrop);
                }
            }
        });
    }

    private void dialogLoadData(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Input values");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        input.setMaxLines(0);
        input.setSingleLine(true);
        input.setEms(100);
        input.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        input.setHint("pH value");
        input.setText("");



        LinearLayout lyt = new LinearLayout(this);
        int padding = Tools.dpToPx(this, 20);
        lyt.setPadding(padding, padding, padding, padding);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lyt.setLayoutParams(params);
        lyt.addView(input);
        builder.setView(lyt);

        builder.setPositiveButton("LOAD", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = input.getText().toString().trim();
                if (name.isEmpty()) {
                    Toast.makeText(getBaseContext(), "pH value cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!name.isEmpty()){
                    int ph=0;
                    try {
                        ph = Integer.parseInt(name);
                    }catch (Exception e){


                        Toast.makeText(getBaseContext(), "YOUR PH VALUE MUST BE A NUMBER 0-14", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(ph>14) {
                        Toast.makeText(getBaseContext(), "pH cannot exceed 14", Toast.LENGTH_LONG).show();
                        return;
                    }
                    if(ph<0) {
                        Toast.makeText(getBaseContext(), "pH cannot be below 0", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if(ph>=0  && ph<=14) {
                        mSoilDetails.add("CROP ANALYSIS");
                    }

                }

                Toast.makeText(getBaseContext(), "pH value added", Toast.LENGTH_SHORT).show();
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

    private void dialogCropAnalysis(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Input Crop");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        input.setMaxLines(0);
        input.setSingleLine(true);
        input.setEms(100);
        input.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        input.setHint("Crop name");
        input.setText("");



        LinearLayout lyt = new LinearLayout(this);
        int padding = Tools.dpToPx(this, 20);
        lyt.setPadding(padding, padding, padding, padding);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lyt.setLayoutParams(params);
        lyt.addView(input);
        builder.setView(lyt);

        builder.setPositiveButton("ENTER", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = input.getText().toString().trim();
                if (name.isEmpty()) {
                    Toast.makeText(getBaseContext(), "Crop name cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!name.isEmpty()) {
                    cropAnalysisName = name;
                }
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
