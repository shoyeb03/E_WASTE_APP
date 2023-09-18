package com.example.e_wasteapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Admin_dashboard extends AppCompatActivity {

    private RecyclerView Smart_Phone,Electronic_Equipments,Video_Games,Computer_Components,Other;
    private LinearLayout Smart_Phone_NoData,Electronic_Equipments_NoData,Video_Games_NoData,Computer_Components_NoData,Other_NoData;
    private List<EWasteData> List1,List2,List3,List4,List5;
    private EWasteAdapter adapter;

    private DatabaseReference reference,dbRef;
    ImageView logoutBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        logoutBtn= findViewById(R.id.logoutBtn);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Admin_dashboard.this,Login_page.class);
                startActivity(i);


            }
        });

        Smart_Phone = findViewById(R.id.Smart_Phone);
        Electronic_Equipments = findViewById(R.id.Electronic_Equipments);
        Video_Games = findViewById(R.id.Video_Games);
        Computer_Components = findViewById(R.id.Computer_Components);
        Other = findViewById(R.id.Other);

        Smart_Phone_NoData = findViewById(R.id.Smart_Phone_NoData);
        Electronic_Equipments_NoData = findViewById(R.id.Electronic_Equipments_NoData);
        Video_Games_NoData = findViewById(R.id.Video_Games_NoData);
        Computer_Components_NoData = findViewById(R.id.Computer_Components_NoData);
        Other_NoData = findViewById(R.id.Other_NoData);

        reference = FirebaseDatabase.getInstance().getReference().child("E - Waste");

        Smart_Phone();
        Electronic_Equipments();
        Video_Games();
        Computer_Components();
        Other();

    }

    private void Smart_Phone() {

        dbRef = reference.child("Smart Phone");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List1 = new ArrayList<>();
                if (!snapshot.exists()) {
                    Smart_Phone_NoData.setVisibility(View.VISIBLE);
                    Smart_Phone.setVisibility(View.GONE);
                }
                else
                {
                    Smart_Phone_NoData.setVisibility(View.GONE);
                    Smart_Phone.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1:snapshot.getChildren()){
                        EWasteData data = snapshot1.getValue(EWasteData.class);
                        List1.add(data);
                    }
                    Smart_Phone.setHasFixedSize(true);
                    Smart_Phone.setLayoutManager(new LinearLayoutManager(Admin_dashboard.this));
                    adapter = new EWasteAdapter(List1,Admin_dashboard.this, "Smart Phone");
                    Smart_Phone.setAdapter(adapter);
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Admin_dashboard.this, error.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void Electronic_Equipments(){

        dbRef = reference.child("Electronic Equipments");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List2 = new ArrayList<>();
                if (!snapshot.exists()) {
                    Electronic_Equipments_NoData.setVisibility(View.VISIBLE);
                    Electronic_Equipments.setVisibility(View.GONE);
                }
                else
                {
                    Electronic_Equipments_NoData.setVisibility(View.GONE);
                    Electronic_Equipments.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1:snapshot.getChildren()){
                        EWasteData data = snapshot1.getValue(EWasteData.class);
                        List2.add(data);
                    }
                    Electronic_Equipments.setHasFixedSize(true);
                    Electronic_Equipments.setLayoutManager(new LinearLayoutManager(Admin_dashboard.this));
                    adapter = new EWasteAdapter(List2,Admin_dashboard.this, "Electronic Equipments");
                    Electronic_Equipments.setAdapter(adapter);
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Admin_dashboard.this, error.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void Video_Games(){

        dbRef = reference.child("Video Games");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List3 = new ArrayList<>();
                if (!snapshot.exists()) {
                    Video_Games_NoData.setVisibility(View.VISIBLE);
                    Video_Games.setVisibility(View.GONE);
                }
                else
                {
                    Video_Games_NoData.setVisibility(View.GONE);
                    Video_Games.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1:snapshot.getChildren()){
                        EWasteData data = snapshot1.getValue(EWasteData.class);
                        List3.add(data);
                    }
                    Video_Games.setHasFixedSize(true);
                    Video_Games.setLayoutManager(new LinearLayoutManager(Admin_dashboard.this));
                    adapter = new EWasteAdapter(List3,Admin_dashboard.this, "Video Games");
                    Video_Games.setAdapter(adapter);
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Admin_dashboard.this, error.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void Computer_Components(){

        dbRef = reference.child("Computer Components");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List4 = new ArrayList<>();
                if (!snapshot.exists()) {
                    Computer_Components_NoData.setVisibility(View.VISIBLE);
                    Computer_Components.setVisibility(View.GONE);
                }
                else
                {
                    Computer_Components_NoData.setVisibility(View.GONE);
                    Computer_Components.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1:snapshot.getChildren()){
                        EWasteData data = snapshot1.getValue(EWasteData.class);
                        List4.add(data);
                    }
                    Computer_Components.setHasFixedSize(true);
                    Computer_Components.setLayoutManager(new LinearLayoutManager(Admin_dashboard.this));
                    adapter = new EWasteAdapter(List4,Admin_dashboard.this, "Computer Components");
                    Computer_Components.setAdapter(adapter);
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Admin_dashboard.this, error.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void Other(){

        dbRef = reference.child("Other");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List5 = new ArrayList<>();
                if (!snapshot.exists()) {
                    Other_NoData.setVisibility(View.VISIBLE);
                    Other.setVisibility(View.GONE);
                }
                else
                {
                    Other_NoData.setVisibility(View.GONE);
                    Other.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1:snapshot.getChildren()){
                        EWasteData data = snapshot1.getValue(EWasteData.class);
                        List5.add(data);
                    }
                    Other.setHasFixedSize(true);
                    Other.setLayoutManager(new LinearLayoutManager(Admin_dashboard.this));
                    adapter = new EWasteAdapter(List5,Admin_dashboard.this, "Other");
                    Other.setAdapter(adapter);
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Admin_dashboard.this, error.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });

    }


    }







