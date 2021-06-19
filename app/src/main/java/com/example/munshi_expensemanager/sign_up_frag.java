package com.example.munshi_expensemanager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class sign_up_frag extends Fragment {

   View view;

    public sign_up_frag() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_sign_up_frag, container, false);
        return view;
    }
}