package com.example.anslo.mkulimaapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.anslo.mkulimaapp.Adapters.ViewPagerAdapter;
import com.example.anslo.mkulimaapp.Fragments.ClimateFragment;
import com.example.anslo.mkulimaapp.Fragments.FarmingTipsFragment;
import com.example.anslo.mkulimaapp.Fragments.RecordsFragment;
import com.example.anslo.mkulimaapp.Fragments.SampleSoilFragment;

/**
 * Created by Paul Mburu on 10/27/18.
 */

public class MainActivity extends AppCompatActivity{

    private TabLayout mTabLayout;
    private AppBarLayout mAppBarlayout;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabLayout=(TabLayout)findViewById(R.id.tablayout_id);
        mAppBarlayout=(AppBarLayout)findViewById(R.id.appbar_id);
        mViewPager=(ViewPager)findViewById(R.id.viewpager_id);
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new SampleSoilFragment(),"Sample Soil");
        adapter.addFragment(new RecordsFragment(),"Records");
        adapter.addFragment(new ClimateFragment(),"Climate");
        adapter.addFragment(new FarmingTipsFragment(),"Farming tips");

    }
}
