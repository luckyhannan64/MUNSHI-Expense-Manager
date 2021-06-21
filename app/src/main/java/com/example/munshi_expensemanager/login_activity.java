package com.example.munshi_expensemanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class login_activity extends AppCompatActivity {

    Button skipbtn;
    Button subbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (savedInstanceState == null) {
            FragmentManager Fragmentmanager = getSupportFragmentManager();
            FragmentTransaction FragmentTransaction = Fragmentmanager.beginTransaction();
            FragmentTransaction.replace(R.id.userfrag, new FragmentLogin());
            FragmentTransaction.commit();
        }

        skipbtn = (Button) findViewById(R.id.skipbtn);
        subbtn = findViewById(R.id.signupbutton);

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

        Intent intent = new Intent(this, Activity_SignUp.class);
        startActivity(intent);

    }
}