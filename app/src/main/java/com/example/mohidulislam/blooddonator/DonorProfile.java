package com.example.mohidulislam.blooddonator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DonorProfile extends AppCompatActivity {
    private TextView nameTV,phoneTV,emailTV,dobTV,genderTV,bloodTV,cityTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_profile);
        nameTV = findViewById(R.id.nameOutput);
        phoneTV = findViewById(R.id.phoneOutput);
        emailTV = findViewById(R.id.emailOutput);
        dobTV = findViewById(R.id.dobOutput);
        genderTV = findViewById(R.id.genderOutput);
        bloodTV = findViewById(R.id.bloodOutput);
        cityTV = findViewById(R.id.cityOutput);

        Member member = (Member) getIntent().getSerializableExtra("donor");
        nameTV.setText(member.getName());
        phoneTV.setText(member.getPhone());
        emailTV.setText(member.getEmail());
        dobTV.setText(member.getDateOfBirth());
        genderTV.setText(member.getGender());
        bloodTV.setText(member.getBloodGroup());
        cityTV.setText(member.getCity());
    }
}
