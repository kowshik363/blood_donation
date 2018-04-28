package com.example.mohidulislam.blooddonator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText emailET, passET;
    private MembarDataSource dataSource = new MembarDataSource(this);
    String email,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailET = findViewById(R.id.loginEmail);
        passET = findViewById(R.id.loginPass);
    }

    public void loginUser(View view) {
        email = emailET.getText().toString();
        pass = passET.getText().toString();
        Member member = dataSource.getMemberByEmail(email);
        if(member != null) {
            if (member.getPassword().equals(pass)) {
                MainActivity.isLoggedIn = true;
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                MainActivity.loggedInMember = member;
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
