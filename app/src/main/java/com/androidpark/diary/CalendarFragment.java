package com.androidpark.diary;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class CalendarFragment extends Fragment {

    private ViewGroup view;
    private ImageButton btndiary;
    private EditText editDiary;
    TextView daytext;
    View dialogView;
    CalendarView calendarView;
    int selectYear,selectMonth,selectDay;
    String selectDate;
    private SimpleDateFormat mFormat = new SimpleDateFormat("yyyy/M/d"); // 날짜 포맷
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view  = (ViewGroup)inflater.inflate(R.layout.fragment_calendar,container,false);

        calendarView = view.findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                selectYear = year;
                selectMonth = month + 1;
                selectDay = day;

                selectDate = Integer.toString(selectYear)
                        + "." + Integer.toString(selectMonth)
                        + "." + Integer.toString(selectDay);
            }
        });
        FloatingActionButton btndiary = view.findViewById(R.id.writeDiary);
        btndiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //메시지 상자
                dialogView = (View) View.inflate(getContext(),R.layout.diary_dialong1,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(getContext());
                daytext = dialogView.findViewById(R.id.day);
                if(selectDate !=null ){
                    daytext.setText(selectDate);
                }else{
                   Date date = new Date();
                   String time = mFormat.format(date);
                   daytext.setText(time);
                }

                dlg.setIcon(R.drawable.edit);
                dlg.setView(dialogView);
                dlg.setPositiveButton("저장",null);
                dlg.setNegativeButton("취소",null);
                dlg.show();
            }
        });

        return view;
    }
}