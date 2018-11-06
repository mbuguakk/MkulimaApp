package com.example.anslo.mkulimaapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.anslo.mkulimaapp.Adapters.ViewPagerAdapter;
import com.example.anslo.mkulimaapp.Fragments.ClimateFragment;
import com.example.anslo.mkulimaapp.Fragments.FarmingTipsFragment;
import com.example.anslo.mkulimaapp.Fragments.RecordsFragment;
import com.example.anslo.mkulimaapp.Fragments.SampleSoilFragment;
import com.example.anslo.mkulimaapp.R;

/**
 * Created by Paul Mburu on 10/27/18.
 */

public class ActivityMain extends AppCompatActivity{

    private TabLayout mTabLayout;
    private AppBarLayout mAppBarlayout;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();

        mTabLayout=(TabLayout)findViewById(R.id.tablayout_id);
        mAppBarlayout=(AppBarLayout)findViewById(R.id.appbar_id);
        mViewPager=(ViewPager)findViewById(R.id.viewpager_id);

        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new SampleSoilFragment(),"Sample Soil");
        adapter.addFragment(new FarmingTipsFragment(),"Farming tips");
        adapter.addFragment(new ClimateFragment(),"Climate");
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }
    private void initToolbar(){
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mkulima App");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.action_settings){
            Toast.makeText(this,item.getTitle()+" clicked ",Toast.LENGTH_SHORT).show();
            Intent i=new Intent(this,ActivitySettings.class);
            startActivity(i);
        }else if(id==R.id.action_about){
            Toast.makeText(this,item.getTitle()+" clicked ",Toast.LENGTH_SHORT).show();
            Intent i=new Intent(this,ActivityAbout.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
