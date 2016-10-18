package com.example.gimmyeongsu.project01;

// make button that min,avg button -> toast


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int checknum = 0;
    public int[] number=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.TextView);
        Toast.makeText(getApplicationContext(),textView.getText(),Toast.LENGTH_SHORT).show();
    }


    public void OnClick(View view) {
        Random r = new Random();
        int num = r.nextInt(20);
        String n = "Add " + num;
        Toast.makeText(getApplicationContext(),n,Toast.LENGTH_SHORT).show();
        TextView textnumber = (TextView) findViewById(R.id.TextView_number);
        String text = "" + textnumber.getText() + num + " ";
        textnumber.setText(text);
        checknum++;


        number = new int[checknum];
        String[] number_string = text.split(" ");
        for(int i=0;i<checknum;i++){
            number[i] = Integer.parseInt(number_string[i]);
        }

    }

    public void OnClick_Average(View view) {
        Average avg = new Average();
        Toast.makeText(getApplicationContext(), String.valueOf(avg.GetNumber(number)), Toast.LENGTH_SHORT).show();
    }

    public void OnClick_minimum(View view) {
        Minimum min = new Minimum();
        Toast.makeText(getApplicationContext(), String.valueOf(min.GetNumber(number)), Toast.LENGTH_SHORT).show();
    }
}
