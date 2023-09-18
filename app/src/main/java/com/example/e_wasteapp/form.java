package com.example.e_wasteapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class form extends AppCompatActivity {


    private EditText name,phoneno,email,address,model,brand;
    private Spinner EWasteCategory;
    private TextView submit;

    ImageView profileImg;

    private String category;
    private String Name, phone,Email, Address, Model,Brand,Condition,Quantity;
    private ProgressDialog pd;

    private StorageReference storageReference;

    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        name = findViewById(R.id.name);
        phoneno = findViewById(R.id.phoneno);
        email = findViewById(R.id.Email);
        address = findViewById(R.id.address);
        model = findViewById(R.id.model);
        brand = findViewById(R.id.brand);
        EWasteCategory = findViewById(R.id.EWasteCategory);
        submit = findViewById(R.id.submit);
        pd = new ProgressDialog(this);






        reference = FirebaseDatabase.getInstance().getReference().child("E - Waste");
        storageReference = FirebaseStorage.getInstance().getReference();

        String[] item = new String[]{"select Category", "Smart Phone", " Electronic Equipments", "Video Games", "Computer Components","Other"};
        EWasteCategory.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, item));

        EWasteCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                category = EWasteCategory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkValidation();
            }
        });





    }

    private void checkValidation() {

        Name  = name.getText().toString();
        phone = phoneno.getText().toString();
        Address = address.getText().toString();
        Email = email.getText().toString();
        Model = model.getText().toString();
        Brand = brand.getText().toString();

        if(Name.isEmpty())
        {
            name.setError("Empty");
            name.requestFocus();
        }
        else if(phone.isEmpty())
        {
            phoneno.setError("Empty");
            phoneno.requestFocus();
        }
        else if(Address.isEmpty())
        {
            address.setError("Empty");
            address.requestFocus();
        }
        else if(Email.isEmpty())
        {
            email.setError("Empty");
            email.requestFocus();
        }
        else if(category.equals("select Category"))
        {
            Toast.makeText(this, "Please provide Department category", Toast.LENGTH_SHORT).show();
        }
        else
        {
            insertData();
        }
    }




    private void insertData() {

        pd.setMessage("Uploading...");
        pd.show();
        dbRef = reference.child(category);
        final String uniqueKey = dbRef.push().getKey();

        EWasteData complaintData = new EWasteData(Name ,phone,Email, Address ,Condition,Quantity,Brand,Model,uniqueKey);

        dbRef.child(uniqueKey).setValue(complaintData).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                pd.dismiss();
                Toast.makeText(form.this, "Data Uploaded Successfully !!!", Toast.LENGTH_SHORT).show();
                Intent i1= new Intent(form.this,submission.class);
                startActivity(i1);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(form.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onWorkSelected(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.working:
                if (checked)
                    Condition = "Working";
                break;

            case R.id.notWorking:
                if (checked)
                    Condition = "Not Working";
                break;

            case R.id.MixItems:
                if (checked)
                    Condition = "Mixed Items";
                break;

        }

    }

    public void onQuantitySelected(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.KG:
                if (checked)
                    Quantity = "Kg";
                break;

            case R.id.NoOFItems:
                if (checked)
                    Quantity = "No of Items";
                break;


        }

    }









    }
