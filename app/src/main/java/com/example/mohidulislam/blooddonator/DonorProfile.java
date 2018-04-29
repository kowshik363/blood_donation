package com.example.mohidulislam.blooddonator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DonorProfile extends AppCompatActivity {
    private EditText nameTV,phoneTV,emailTV,genderTV,bloodTV,cityTV;
    private TextView dobTV;
    private Button updateBtn;
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
        updateBtn = findViewById(R.id.updateBtn);

        final Member member = (Member) getIntent().getSerializableExtra("donor");
        nameTV.setText(member.getName());
        phoneTV.setText(member.getPhone());
        emailTV.setText(member.getEmail());
        dobTV.setText(member.getDateOfBirth());
        genderTV.setText(member.getGender());
        bloodTV.setText(member.getBloodGroup());
        cityTV.setText(member.getCity());
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Member memberUpdateValues = new Member(member.getID(),nameTV.getText().toString(),
                        phoneTV.getText().toString(),emailTV.getText().toString(),
                        member.getPassword(),member.getDateOfBirth(),member.getGender(),member.getBloodGroup(),cityTV.getText().toString());

                MembarDataSource dataSource = new MembarDataSource(DonorProfile.this);
                dataSource.updateMemeberById(member.getID(),memberUpdateValues);
                Intent intent = new Intent(DonorProfile.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
