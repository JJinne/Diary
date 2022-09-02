package com.androidpark.diary;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private HomeFragment homeFragment = new HomeFragment();
    private MyFragment  myFragment = new MyFragment();
    private BoarFragment boarFragment = new BoarFragment();

    private CalendarFragment calendarFragment = new CalendarFragment();
    private TodoFragment todoFragment = new TodoFragment();
//    private CalendarFragment calendarFragment = new CalendarFragment();
//    private TodoFragment todoFragment = new TodoFragment();
   /*  Button todoAdd;
    EditText insertTodo;

    private ArrayList<TodoItem> todoItemArrayList;
    private TodoAdapter todoAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, homeFragment).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationBottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());


    }
    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.home:
                        transaction.replace(R.id.frameLayout, homeFragment).commitNowAllowingStateLoss();
/*                             FragmentManager fragmentManager1 = homeFragment.getChildFragmentManager();
                            if(item.getItemId() == R.id.calendar) {
                                fragmentManager1.beginTransaction().replace(R.id.frameLayoutHome,calendarFragment).commitAllowingStateLoss();
                            }else if(item.getItemId() == R.id.todo){
                                fragmentManager1.beginTransaction().replace(R.id.frameLayoutHome,  todoFragment).commitAllowingStateLoss();
                            }*/
                        break;
                    case R.id.board:
                        transaction.replace(R.id.frameLayout, boarFragment).commitNowAllowingStateLoss();
                        break;
                    case R.id.my:
                        transaction.replace(R.id.frameLayout, myFragment).commitNowAllowingStateLoss();
                        break;
                }

            return true;
        }
    }
}