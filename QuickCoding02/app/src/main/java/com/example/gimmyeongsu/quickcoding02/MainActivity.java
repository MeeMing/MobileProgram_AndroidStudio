package com.example.gimmyeongsu.quickcoding02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private int checknum = 0;
    private int b = 100;
    private int s = 0;
    private int num = 0;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textview = (TextView) findViewById(R.id.textview_main);
        Toast.makeText(getApplicationContext(),textview.getText(),Toast.LENGTH_SHORT).show();
    }


    public void onclick_send(View view) {
        TextView textView = (TextView) findViewById(R.id.textview_result);
        num = random.nextInt(100);
        s=0;
        b=100;
        String str = "your number is " + String.valueOf(num);
        textView.setText(str);
    }


    public void onclick_Bigger(View view) {
        s = num;
        checknum++;
        TextView textView = (TextView) findViewById(R.id.textview_result);
        /*
        while(true) {
            num = random.nextInt(100);
            if (num < b && num > s) {
                break;
            }
        }
        */

        num = (s+b)/2;

        String str = "your number is " + String.valueOf(num);
        textView.setText(str);
    }

    public void onclick_smaller(View view) {
        b = num;
        checknum++;
        TextView textView = (TextView) findViewById(R.id.textview_result);
        /*
        while(true) {
            num = random.nextInt(100);
            if (num < b && num > s) {
                break;
            }
        }
        */

        num = (s+b)/2;

        String str = "your number is " + String.valueOf(num);
        textView.setText(str);
    }

    public void onclick_bingo(View view) {
        Toast.makeText(getApplicationContext(),String.valueOf(checknum),Toast.LENGTH_SHORT).show();
    }

}
