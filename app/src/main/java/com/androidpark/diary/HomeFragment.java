package com.androidpark.diary;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeFragment extends Fragment {
    ViewGroup view;
    private FragmentManager fragmentManager = getChildFragmentManager();
    private CalendarFragment calendarFragment = new CalendarFragment();
    private TodoFragment todoFragment = new TodoFragment();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = (ViewGroup) inflater.inflate(R.layout.fragment_home, null, false);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayoutHome,calendarFragment).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView =  view.findViewById(R.id.navigationBottom);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (item.getItemId()){
                    case R.id.calendar:
                        transaction.replace(R.id.frameLayoutHome,calendarFragment).commitAllowingStateLoss();
                        break;
                    case R.id.todo:
                        transaction.replace(R.id.frameLayoutHome,todoFragment).commitAllowingStateLoss();
                        break;

                }

                return false;
            }
        });


        return view;
    }
}
//view - home
//tab - calendar & todo