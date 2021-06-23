package com.example.munshi_expensemanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class login_activity extends AppCompatActivity {

    Button skipbtn;
    Button subbtn;
    Button login;
    EditText edittext1,edittext2;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        skipbtn = findViewById(R.id.skipbtn);
        subbtn = findViewById(R.id.signupbtn);
        login = findViewById(R.id.loginbtn);
        edittext1 = findViewById(R.id.usernametextlogin);
        edittext2 = findViewById(R.id.passwordlogin);

        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginAccount();
            }
        });


       subbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               opensignup();
           }
       });

        skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openskip();

            }
        });

        }

    private void opensignup() {
        Intent intent = new Intent(this, Activity_SignUp.class);
        startActivity(intent);
    }

    public void openskip() {

        Intent intent = new Intent(this, home_activity.class);
        startActivity(intent);

    }

    void loginAccount(){
        String Userlogin = edittext1.getText().toString().trim();
        String Passlogin = edittext2.getText().toString();
        mAuth.signInWithEmailAndPassword(Userlogin,Passlogin)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete( Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Account is logged in",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(),home_activity.class));
                        }
                        else{
                            Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }

}