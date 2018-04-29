package com.example.mohidulislam.blooddonator;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class DonorRegistration extends AppCompatActivity {

    private RadioGroup genderRG;
    private EditText nameET, emailET, phoneET, passET;
    private Spinner bloodGroupSP, citySP;
    private TextView dobTV;
    private ImageButton dobBtn;
    private Calendar calendar;
    MembarDataSource dataSource;



    private String city,bloodGroup, gender, dateOfBirth;
    private int year, month, day;

    private List<String>cities = new ArrayList<>();
    private List<String>bloodGroups = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_registration);
        genderRG = findViewById(R.id.genderInput);
        nameET = findViewById(R.id.nameInput);
        emailET = findViewById(R.id.emailInput);
        phoneET = findViewById(R.id.phoneInput);
        bloodGroupSP = findViewById(R.id.bloodGroupInput);
        citySP = findViewById(R.id.cityInput);
        dobBtn = findViewById(R.id.dobButton);
        dobTV = findViewById(R.id.dobInput);
        passET = findViewById(R.id.passInput);
        calendar = Calendar.getInstance(Locale.getDefault());
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        dataSource = new MembarDataSource(DonorRegistration.this);
        populatedCities();
        populatedBloodGroup();

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySP.setAdapter(adapter);
        citySP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                city = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bloodGroups);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodGroupSP.setAdapter(adapter);
        bloodGroupSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bloodGroup = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        genderRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                gender = rb.getText().toString();
            }
        });

        dobBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(DonorRegistration.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        Calendar temp = Calendar.getInstance();
                        temp.set(year,month,dayOfMonth);
                        dateOfBirth = simpleDateFormat.format(temp.getTime());
                        dobTV.setText(dateOfBirth);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

    }

    private void populatedBloodGroup() {
        bloodGroups.add("A+");
        bloodGroups.add("A-");
        bloodGroups.add("AB+");
        bloodGroups.add("AB-");
        bloodGroups.add("B+");
        bloodGroups.add("B-");
        bloodGroups.add("O+");
        bloodGroups.add("O-");
        Collections.sort(bloodGroups);
    }

    private void populatedCities() {
        cities.add("Bagerhat");
        cities.add("Bandarban");
        cities.add("Barguna");
        cities.add("Barisal");
        cities.add("Bhola");
        cities.add("Bogra");
        cities.add("Brahmanbaria");
        cities.add("Chandpur");
        cities.add("Chittagong");
        cities.add("Chuadanga");
        cities.add("Comilla");
        cities.add("Cox's Bazar");
        cities.add("Dhaka");
        cities.add("Dinajpur");
        cities.add("Faridpur");
        cities.add("Feni");
        cities.add("Gaibandha");
        cities.add("Gazipur");
        cities.add("Gopalganj");
        cities.add("Habiganj");
        cities.add("Jaipurhat");
        cities.add("Jamalpur");
        cities.add("Jessore");
        cities.add("Jhalakati");
        cities.add("Jhenaidah");
        cities.add("Khagrachari");
        cities.add("Khulna");
        cities.add("Kishoreganj");
        cities.add("Kurigram");
        cities.add("Kushtia");
        cities.add("Lakshmipur");
        cities.add("Lalmonirhat");
        cities.add("Madaripur");
        cities.add("Magura");
        cities.add("Manikganj");
        cities.add("Meherpur");
        cities.add("Moulvibazar");
        cities.add("Munshiganj");
        cities.add("Mymensingh");
        cities.add("Naogaon");
        cities.add("Narail");
        cities.add("Narayanganj");
        cities.add("Narsingdi");
        cities.add("Natore");
        cities.add("Nawabganj");
        cities.add("Netrakona");
        cities.add("Nilphamari");
        cities.add("Noakhali");
        cities.add("Pabna");
        cities.add("Panchagarh");
        cities.add("Parbattya Chattagram");
        cities.add("Patuakhali");
        cities.add("Pirojpur");
        cities.add("Rajbari");
        cities.add("Rajshahi");
        cities.add("Rangpur");
        cities.add("Satkhira");
        cities.add("Shariatpur");
        cities.add("Sherpur");
        cities.add("Sirajganj");
        cities.add("Sunamganj");
        cities.add("Sylhet");
        cities.add("Tangail");
        cities.add("Thakurgaon");
        Collections.sort(cities);

    }

    public void registerNewMember(View view) {
        String name = nameET.getText().toString();
        String email = emailET.getText().toString();
        String phone = phoneET.getText().toString();
        String pass = passET.getText().toString();

        Member member = new Member(name,phone,email,pass,dateOfBirth,gender,bloodGroup,city);
        if (dataSource.insetNewMember(member)) {
            Toast.makeText(this, "Registered", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(DonorRegistration.this,MainActivity.class));
        } else {
            Toast.makeText(this, "Failed to Register", Toast.LENGTH_SHORT).show();
        }

    }

}
