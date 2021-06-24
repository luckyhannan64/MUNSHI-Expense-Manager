package com.example.munshi_expensemanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

public class home_activity extends AppCompatActivity {
    ImageButton transactionbtn,chartsbtn,balancebtn,accountsbtn,budgetbtn,expensesbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        transactionbtn = findViewById(R.id.img_transaction);
        chartsbtn = findViewById(R.id.img_charts);
        balancebtn = findViewById(R.id.img_balance);
        accountsbtn = findViewById(R.id.img_accounts);
        budgetbtn = findViewById(R.id.img_budget);
        expensesbtn = findViewById(R.id.img_expenses);

     transactionbtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             opentrans();
         }


     });
     expensesbtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             openexpense();
         }
     });

    }
    private void opentrans() {
        getSupportFragmentManager().beginTransaction().replace(R.id.Fagment_framlayout_home,new FragmentTransaction()).commit();
    }
    private void openexpense() {
        getSupportFragmentManager().beginTransaction().replace(R.id.Fagment_framlayout_home,new FragmentExpense()).commit();
    }

}