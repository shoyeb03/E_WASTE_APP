package com.example.e_wasteapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_page extends AppCompatActivity {

    EditText mEmail,mPassword;
    Button mLoginBtn,adminLoginBtn;
    TextView mCreateBtn,forgotTextLink;
    ProgressBar progressBar;
    FirebaseAuth fAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        mEmail= findViewById(R.id.Email2);
        mPassword = findViewById(R.id.password2);
        progressBar= findViewById(R.id.progressBar2);
        fAuth= FirebaseAuth.getInstance();
        mLoginBtn = findViewById(R.id.loginBtn);
        mCreateBtn = findViewById(R.id.createText2);
        forgotTextLink = findViewById(R.id.forgotPassword);
        adminLoginBtn= findViewById(R.id.adminLoginBtn);

        adminLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();


                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required.");
                    return;
                }

                if(password.length()< 6){
                    mPassword.setError("Password Must Be Greater Than 6 Char");
                    return;
                }


                if(mEmail.getText().toString().equals("admin@gmail.com") && mPassword.getText().toString().equals("123456"))
                {
                    Intent i1= new Intent(Login_page.this,Admin_dashboard.class);
                    startActivity(i1);
                    Toast.makeText(Login_page.this, "Login Successfull !!!", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Toast.makeText(Login_page.this, "Invalid Data !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required.");
                    return;
                }

                if(password.length()< 6){
                    mPassword.setError("Password Must Be Greater Than 6 Char");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

//                AUTHENTICATE THE USER
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login_page.this, "Logged In Succeessfully.", Toast.LENGTH_SHORT).show();
                            Intent i= new Intent(Login_page.this,MainActivity.class);
                            startActivity(i);
                        }
                        else{
                            Toast.makeText(Login_page.this, "Error!!!"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);

                        }

                    }
                });
            }
        });

        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Login_page.this,Register_page.class);
                startActivity(i);
            }
        });

        forgotTextLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final  EditText resetMail = new EditText(v.getContext());
               final AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset Password ?");
                passwordResetDialog.setMessage("Enter Your Email To Receive Reset Link.");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       String mail = resetMail.getText().toString();
                       fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                           @Override
                           public void onSuccess(Void unused) {
                               Toast.makeText(Login_page.this, "Reset Link Sent To Your E-mail. ", Toast.LENGTH_SHORT).show();
                           }
                       }).addOnFailureListener(new OnFailureListener() {
                           @Override
                           public void onFailure(@NonNull Exception e) {
                               Toast.makeText(Login_page.this, "Error ! Reset Link Is Not Sent." + e.getMessage(), Toast.LENGTH_SHORT).show();
                           }
                       });
                    }
                });

                passwordResetDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                passwordResetDialog.create().show();


            }
        });




    }
}