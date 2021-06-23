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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_SignUp extends AppCompatActivity {

    Button btn1;
    EditText emails_signup,usernames_signup,passwords_signup;
    private FirebaseAuth mAuth;
    DatabaseReference Reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btn1 = findViewById(R.id.sumbitfargbtn);
        emails_signup = findViewById(R.id.emailsignup);
        usernames_signup  = findViewById(R.id.usernamesignup);
        passwords_signup = findViewById(R.id.passwordsignup);
        Reference = FirebaseDatabase.getInstance().getReference().child("Data");
        mAuth = FirebaseAuth.getInstance();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccountRealtime();
            }

        });
        } private void openHome() {
        Intent intent = new Intent(this , home_activity.class);
        startActivity(intent);
    }
    void createAccount() {

        String Username = usernames_signup.getText().toString().trim();
        String Email = emails_signup.getText().toString().trim();
        String Password = passwords_signup.getText().toString();
        mAuth.createUserWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Account is Created", Toast.LENGTH_LONG).show();
                            openHome();
                        } else {
                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }

                });
    }
        void createAccountRealtime(){

            String Username_real = usernames_signup.getText().toString();
            String Email_real = emails_signup.getText().toString().trim();
            String Password_real = passwords_signup.getText().toString();
            mAuth.createUserWithEmailAndPassword(Email_real,Password_real)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"Account is Created",Toast.LENGTH_LONG).show();
                                openHome();
                                modelclass1 ob1=new modelclass1(1,Username_real,Password_real,Email_real);
                                Reference.child(mAuth.getCurrentUser().getUid()).setValue(ob1);
                            }

                            else{
                                Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_LONG).show();
                            }
                        }

                    });
    }


}