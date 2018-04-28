package com.example.mohidulislam.blooddonator;

import android.content.Intent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.text.DateFormat;
import java.time.Period;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

public class MemberProfile extends AppCompatActivity {

    private TextView memberNameTV, memberAgeTV, memberLocationTV, memberBloodGroupTV, memberEmailTV, memberContactTV;
    private DateFormat format;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_profile);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Member member = (Member) bundle.getSerializable("memberInfo");
        memberNameTV = findViewById(R.id.memberNameValue);
        memberAgeTV = findViewById(R.id.memberAgeValue);
        memberLocationTV = findViewById(R.id.memberLocationValue);
        memberBloodGroupTV = findViewById(R.id.memberBloodGroupValue);
        memberEmailTV = findViewById(R.id.memberEmailValue);
        memberContactTV = findViewById(R.id.memberContactValue);
        format = new SimpleDateFormat("d/M/Y", Locale.ENGLISH);
        Date today = new Date();
        Date birthdate = getDate(member.getDateOfBirth());
        int age = getDiffYears(birthdate,today);

        memberNameTV.setText(member.getName());
        memberAgeTV.setText(age+"");
        memberLocationTV.setText(member.getCity());
        memberBloodGroupTV.setText(member.getBloodGroup());
        memberEmailTV.setText(member.getEmail());
        memberContactTV.setText(member.getPhone());
    }

    public Date getDate(String dateText) {

        try {
            Date date = format.parse(dateText);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getDiffYears(Date first, Date last) {
        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);
        int diff = b.get(YEAR) - a.get(YEAR);
        if (a.get(MONTH) > b.get(MONTH) ||
                (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
            diff--;
        }
        return diff;
    }

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }
}
