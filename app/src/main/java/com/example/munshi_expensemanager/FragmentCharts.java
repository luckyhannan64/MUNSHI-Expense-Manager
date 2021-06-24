package com.example.munshi_expensemanager;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import javax.xml.transform.Templates;


public class FragmentCharts extends Fragment {


    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barlist;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_charts, container, false);
        barChart= view.findViewById(R.id.barchart);
        getentries();
        barDataSet= new BarDataSet(barlist,"DATA SET");
        barData=new BarData((barDataSet));
        barChart.setData(barData);
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);
        return view;

    }
    private void getentries(){
        barlist=new ArrayList<>();
        barlist.add(new BarEntry(1f,2));
        barlist.add(new BarEntry(2f,3));
        barlist.add(new BarEntry(3f,4));
        barlist.add(new BarEntry(5f,7));
        barlist.add(new BarEntry(7f,1));
    }
}