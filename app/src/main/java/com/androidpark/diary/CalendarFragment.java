package com.androidpark.diary;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
    ViewGroup view;
    EditText editDiary;
    TextView daytext;
    View dialogView;
    CalendarView calendarView;

    private int selectYear,selectMonth,selectDay; // 선택된 년도,월,날
    private String selectDate; //선택된 날짜 저장될 변수
    private SimpleDateFormat mFormat = new SimpleDateFormat("yyyy/M/d"); // 날짜 포맷
    private String inputDiary;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view  = (ViewGroup)inflater.inflate(R.layout.fragment_calendar,container,true);

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
                dlg.setPositiveButton("저장", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        editDiary = dialogView.findViewById(R.id.editDiary);
                        inputDiary  = editDiary.getText().toString();
                        Toast.makeText(getActivity(), inputDiary, Toast.LENGTH_SHORT).show();
                    }
                });

                dlg.setNegativeButton("취소",null);
                dlg.show();
            }
        });

        return view;
    }
}