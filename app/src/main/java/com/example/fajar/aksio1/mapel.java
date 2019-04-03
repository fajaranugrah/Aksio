package com.example.fajar.aksio1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fajar on 28/03/2016.
 */
public class mapel extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapel);
        //initTab();

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new senin(), "SENIN");
        adapter.addFragment(new selasa(), "SELASA");
        adapter.addFragment(new rabu(), "RABU");
        adapter.addFragment(new kamis(), "KAMIS");
        adapter.addFragment(new jumat(), "JUM'At");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }



//    private void initTab(){
//        TabHost tabhost = getTabHost();
//        TabHost.TabSpec spec;
//        Intent intent;
//        intent = new Intent().setClass(this, senin.class);//content pada tab yang akan kita buat
//        spec = tabhost.newTabSpec("Senin").setIndicator("Senin",null).setContent(intent);//mengeset nama tab dan mengisi content pada menu tab anda.
//        tabhost.addTab(spec);//untuk membuat tabbaru disini bisa diatur sesuai keinginan anda
//        intent = new Intent().setClass(this, selasa.class);
//        spec = tabhost.newTabSpec("selasa").setIndicator("Selasa",null).setContent(intent);
//        tabhost.addTab(spec);
//        intent = new Intent().setClass(this, rabu.class);
//        spec = tabhost.newTabSpec("rabu").setIndicator("Rabu",null).setContent(intent);
//        tabhost.addTab(spec);
//        intent = new Intent().setClass(this, kamis.class);
//        spec = tabhost.newTabSpec("kamis").setIndicator("Kamis",null).setContent(intent);
//        tabhost.addTab(spec);
//        intent = new Intent().setClass(this, jumat.class);
//        spec = tabhost.newTabSpec("jum'at").setIndicator("Jum'at",null).setContent(intent);
//        tabhost.addTab(spec);
//    }
}
