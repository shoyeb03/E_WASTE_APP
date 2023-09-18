package com.example.e_wasteapp;

import
        androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class contact_page extends AppCompatActivity {

    ImageView fb,insta;
  //  TextView emailLink;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_page);

        fb = findViewById(R.id.fb_logo);
        insta = findViewById(R.id.insta_logo);
        //emailLink= findViewById(R.id.mailLink);


        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://instagram.com/_shahid_sayyad?igshid=ZDdkNTZiNTM=");
            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://m.facebook.com/profile.php?id=100068625722691");
            }
        });




    }

    private void gotoUrl(String s) {

        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));


    }
}