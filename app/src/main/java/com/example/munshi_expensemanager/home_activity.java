package com.example.munshi_expensemanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
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
    ImageButton Trans_btn,Balance_btn,Accounts_btn,budget_btn,Expenses_btn,Charts_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    Trans_btn = findViewById(R.id.img_transaction);
    Balance_btn =findViewById(R.id.img_balance);
    Accounts_btn = findViewById(R.id.img_accounts);
    budget_btn = findViewById(R.id.img_budget);
    Expenses_btn = findViewById(R.id.img_expenses);
    Charts_btn = findViewById(R.id.img_charts);

    Trans_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            open_trans();
        }
    });
        Balance_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_balance();
            }
        });
        Accounts_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_accounts();
            }
        });
        budget_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_budget();
            }
        });
        Expenses_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_expense();
            }
        });
        Charts_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_charts();
            }
        });

    }
    private void open_trans() {
        getSupportFragmentManager().beginTransaction().replace(R.id.Fagment_framlayout_home,new FragmentTransaction()).commit();
    }
    private void open_balance() {
        getSupportFragmentManager().beginTransaction().replace(R.id.Fagment_framlayout_home,new FragmentBalance()).commit();
    }
    private void open_budget() {
        getSupportFragmentManager().beginTransaction().replace(R.id.Fagment_framlayout_home,new FragmentBudget()).commit();
    }
    private void open_expense() {
        getSupportFragmentManager().beginTransaction().replace(R.id.Fagment_framlayout_home,new FragmentExpense()).commit();
    }
    private void open_charts() {
         getSupportFragmentManager().beginTransaction().replace(R.id.Fagment_framlayout_home,new FragmentCharts()).commit();
    }
    private void open_accounts() {
        getSupportFragmentManager().beginTransaction().replace(R.id.Fagment_framlayout_home,new FragmentAccounts()).commit();
    }
}