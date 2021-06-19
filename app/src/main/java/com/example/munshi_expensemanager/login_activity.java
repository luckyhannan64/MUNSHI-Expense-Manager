package com.example.munshi_expensemanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class login_activity extends AppCompatActivity {

    Button loginbtn;
    Button skipbtn;
    Button subbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        skipbtn = (Button) findViewById(R.id.skipbtn);

        subbtn = findViewById(R.id.signupbutton);

        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replacefrag (new sign_up_frag());
            }

            private void replacefrag(sign_up_frag sign_up_frag) {
                FragmentManager Fragmentmanger = getSupportFragmentManager();
                FragmentTransaction FragmentTransaction = Fragmentmanger.beginTransaction();
                FragmentTransaction.replace(R.id.userfrag,sign_up_frag);
                FragmentTransaction.commit();
            }
        });


        loginbtn = findViewById(R.id.loginbtn);

        loginbtn.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                replaceFragment(new FragmentLogin());
            }

            private void replaceFragment (FragmentLogin fragmentLogin){
                FragmentManager Fragmentmanger = getSupportFragmentManager();
                FragmentTransaction FragmentTransaction = Fragmentmanger.beginTransaction();
                FragmentTransaction.replace(R.id.userfrag, fragmentLogin);
                FragmentTransaction.commit();

            }

        });



        skipbtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                openskip();
            }
        });
    }

    public void openskip() {

        Intent intent = new Intent(this, home_activity.class);
        startActivity(intent);

}

}