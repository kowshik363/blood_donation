package com.example.mohidulislam.blooddonator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity {

    private EditText emailET, passET;
    private MembarDataSource dataSource = new MembarDataSource(this);
    String email,pass;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailET = findViewById(R.id.loginEmail);
        passET = findViewById(R.id.loginPass);

        preferences = getApplicationContext().getSharedPreferences("Pref",0);
        editor = preferences.edit();

    }

    public void loginUser(View view) {
        email = emailET.getText().toString();
        pass = passET.getText().toString();
        Member member = dataSource.getMemberByEmail(email);
        if(member != null) {
            if (member.getPassword().equals(pass)) {
                editor.putBoolean("isLoggedIn",true);
                Gson gson = new Gson();
                String json = gson.toJson(member);
                editor.putString("loggedInMember",json);
                editor.commit();
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Invalid E-mail", Toast.LENGTH_SHORT).show();
        }

    }

    public void registerUser(View view) {
        startActivity(new Intent(LoginActivity.this,DonorRegistration.class));
    }
}
