package com.example.mohidulislam.blooddonator;

import android.content.Intent;
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

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView memberLV;
    private List<Member>members;
    private MemberAdapter adapter;
    private MembarDataSource dataSource;
    private TextView emptyRecordTV;
    public static boolean isLoggedIn = false;
    public static Member loggedInMember = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        memberLV = findViewById(R.id.donorListLV);
        dataSource = new MembarDataSource(this);
        members = dataSource.getAllMembers();
        adapter = new MemberAdapter(this,members);
        memberLV.setAdapter(adapter);
        emptyRecordTV = findViewById(R.id.emptyRecord);
        if(members.size()==0) emptyRecordTV.setVisibility(View.VISIBLE);

        memberLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Member member = members.get(position);
                startActivity(new Intent(MainActivity.this,DonorProfile.class).putExtra("donor",member));
            }
        });
        
    }


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
                break;
            case R.id.logOut:
                isLoggedIn = false;
                Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myAccount:
                startActivity(new Intent(MainActivity.this,DonorProfile.class).putExtra("donor",loggedInMember));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem loginItem = menu.findItem(R.id.logIn);
        MenuItem logoutItem = menu.findItem(R.id.logOut);
        MenuItem profileItem = menu.findItem(R.id.myAccount);
        if(isLoggedIn) {
            loginItem.setVisible(false);
            logoutItem.setVisible(true);
            profileItem.setVisible(true);
        }
        else {
            loginItem.setVisible(true);
            logoutItem.setVisible(false);
            profileItem.setVisible(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }
}
