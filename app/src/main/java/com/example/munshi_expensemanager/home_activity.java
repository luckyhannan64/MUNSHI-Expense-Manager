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
        Intent intent = new Intent(getApplicationContext(),Fragments_buttons.class);
        intent.putExtra("key",5);
        startActivity(intent);
    }
    private void open_balance() {
        Intent intent = new Intent(getApplicationContext(),Fragments_buttons.class);
        intent.putExtra("key",4);
        startActivity(intent);
    }
    private void open_budget() {
        Intent intent = new Intent(getApplicationContext(),Fragments_buttons.class);
        intent.putExtra("key",3);
        startActivity(intent);
    }
    private void open_expense() {
        Intent intent = new Intent(getApplicationContext(),Fragments_buttons.class);
        intent.putExtra("key",2);
        startActivity(intent);
    }
    private void open_charts() {
        Intent intent = new Intent(getApplicationContext(),Fragments_buttons.class);
        intent.putExtra("key",6);
        startActivity(intent);
    }
    private void open_accounts() {
        Intent intent = new Intent(getApplicationContext(),Fragments_buttons.class);
        intent.putExtra("key",1);
        startActivity(intent);
    }
}