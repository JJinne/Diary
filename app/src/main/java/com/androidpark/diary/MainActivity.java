package com.androidpark.diary;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private CalendarFragment calendarFragment = new CalendarFragment();
    private TodoFragment todoFragment = new TodoFragment();
    Button todoAdd;
    EditText insertTodo;
    /*
    private ArrayList<TodoItem> todoItemArrayList;
    private TodoAdapter todoAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, calendarFragment).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());


    }
    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (item.getItemId()){
                case R.id.calendar:
                    transaction.replace(R.id.frameLayout,calendarFragment).commitNowAllowingStateLoss();
                    break;
                case R.id.todo:
                    transaction.replace(R.id.frameLayout,todoFragment).commitNowAllowingStateLoss();
                    break;
            }

            return true;
        }
    }
}