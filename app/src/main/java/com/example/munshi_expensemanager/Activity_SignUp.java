package com.example.munshi_expensemanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class Activity_SignUp extends AppCompatActivity {

    Button btn1;
    EditText emails_signup,usernames_signup,passwords_signup;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btn1 = findViewById(R.id.sumbitfargbtn);
        emails_signup = findViewById(R.id.emailsignup);
        usernames_signup  = findViewById(R.id.usernamesignup);
        passwords_signup = findViewById(R.id.passwordsignup);
        mAuth = FirebaseAuth.getInstance();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }

        });
        } private void openHome() {
        Intent intent = new Intent(this , home_activity.class);
        startActivity(intent);
    }
    void createAccount(){

        String Username = usernames_signup.getText().toString().trim();
        String Email = emails_signup.getText().toString().trim();
        String Password = passwords_signup.getText().toString();
        mAuth.createUserWithEmailAndPassword(Email,Password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Account is Created",Toast.LENGTH_LONG).show();
                            openHome();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }

                });
    }


}