package com.example.mohidulislam.blooddonator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText emailET, passET;
    private Button loginBtn, regiBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailET = findViewById(R.id.loginEmail);
        passET = findViewById(R.id.loginPass);
        loginBtn = findViewById(R.id.loginBtn);
        regiBtn = findViewById(R.id.registerBtn);
    }

    public void loginUser(View view) {
        String email = emailET.getText().toString();
        String pass = passET.getText().toString();
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        intent.putExtra("email",email);
        intent.putExtra("pass",pass);
        startActivity(intent);

    }

    public void registerUser(View view) {
        startActivity(new Intent(LoginActivity.this,DonorRegistration.class));
    }
}
