package com.example.munshi_expensemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Fragments_buttons extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_buttons);
        Intent intent =getIntent();
        if(intent.getIntExtra("key",1)==1){
            getSupportFragmentManager().beginTransaction().add(R.id.Fagment_framlayout_home,new FragmentAccounts()).commit();
        }
        else if(intent.getIntExtra("key",1)==2){
            getSupportFragmentManager().beginTransaction().add(R.id.Fagment_framlayout_home,new FragmentExpense()).commit();
        }
        else if(intent.getIntExtra("key",1)==3){
            getSupportFragmentManager().beginTransaction().add(R.id.Fagment_framlayout_home,new FragmentBudget()).commit();
        }
        else if(intent.getIntExtra("key",1)==4){
            getSupportFragmentManager().beginTransaction().add(R.id.Fagment_framlayout_home,new FragmentBalance()).commit();
        }
        else if(intent.getIntExtra("key",1)==5){
            getSupportFragmentManager().beginTransaction().add(R.id.Fagment_framlayout_home,new FragmentTransaction()).commit();
        }
        else if(intent.getIntExtra("key",1)==6){
            getSupportFragmentManager().beginTransaction().add(R.id.Fagment_framlayout_home,new FragmentCharts()).commit();
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}