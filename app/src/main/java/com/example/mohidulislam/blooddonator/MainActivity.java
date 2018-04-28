package com.example.mohidulislam.blooddonator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Serializable{

    private ListView memberLV;
    private List<Member>members;
    private MemberAdapter adapter;
    private MembarDataSource dataSource;
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        memberLV = findViewById(R.id.donorListLV);
        dataSource = new MembarDataSource(this);
        members = dataSource.getAllMembers();
        adapter = new MemberAdapter(this,members);
        memberLV.setAdapter(adapter);

        memberLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(MainActivity.this, MemberProfile.class);
                intent.putExtra("memberInfo", members.get(position));
                startActivity(intent);
            }
        });
        
    }

    boolean userExist(String email, String pass) {
       for(Member m: members) {
           if(m.getEmail().equals(email) && m.getPassword().equals(pass)) {
               return true;
           }
       }
       return false;
    }

    public void addNewDonor(View view) {
        startActivity(new Intent(this,DonorRegistration.class));
    }

   /* public void login(View view) {
        String uemail = "k@gmail.com";
        String upass = "789456";
        boolean login = loginExist(uemail,upass);
        if (login) {
            Toast.makeText(this, "Login Successfull!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.user_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.logIn:
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                String email = getIntent().getStringExtra("email");
                String pass = getIntent().getStringExtra("pass");
                if(userExist(email,pass)) {
                    Toast.makeText(this, "Loged In", Toast.LENGTH_SHORT).show();
                } else   Toast.makeText(this, "Wrong Email or Password", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logOut:
                Toast.makeText(this, "Logout Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myAccount:
                Toast.makeText(this, "Myaccount Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.registration:
                Intent intent = new Intent(MainActivity.this, DonorRegistration.class);
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
