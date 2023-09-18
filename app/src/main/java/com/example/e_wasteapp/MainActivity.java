package com.example.e_wasteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


//    Button logout;
//    Button info_page;
//    Button profileBtn;
    ImageView  logoutBtn,infoBtn,profileBtn2,upload_data,contact_us;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        logout = findViewById(R.id.logout);
//        info_page= findViewById(R.id.info);
//        profileBtn = findViewById(R.id.profileBtn);

        logoutBtn = findViewById(R.id.logout1);
        infoBtn = findViewById(R.id.information1);
        profileBtn2= findViewById(R.id.profile1);
        upload_data= findViewById(R.id.upload_data);
        contact_us = findViewById(R.id.contact_us);





        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MainActivity.this,Login_page.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Logged out Successfully!!!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,information_page.class);
                startActivity(intent);
            }
        });


        profileBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,profile_page.class);
                startActivity(intent);
            }
        });

        upload_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1= new Intent(MainActivity.this,form.class);
                startActivity(i1);
            }
        });

        contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(MainActivity.this,contact_page.class);
                startActivity(i2);
            }
        });
    }
}