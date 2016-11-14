package com.example.gimmyeongsu.quickcoding_generic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {


    LinkedList<String> str = new LinkedList<String>();
    int str_num = 0;
    LinkedList<Integer> ints = new LinkedList<Integer>();
    int ints_num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void Onclick_input(View view) {

        EditText edt = (EditText) findViewById(R.id.editText);
        String edttext = edt.getText().toString();

        try{
            ints_num++;
            ints.add(Integer.parseInt(edttext));
            Toast.makeText(getApplicationContext(), "Number", Toast.LENGTH_SHORT).show();
        }catch(NumberFormatException e){
            str.add(edttext);
            Toast.makeText(getApplicationContext(), "String", Toast.LENGTH_SHORT).show();
            str_num++;
        }
    }


    public void Onclick_result(View view) {
        TextView string = (TextView)findViewById(R.id.result_string);
        String rs="";
        TextView number = (TextView)findViewById(R.id.result_number);
        String rn="";


        LinkedList<String> clone_str = (LinkedList<String>)str.clone();
        LinkedList<Integer> clone_ints = (LinkedList<Integer>)ints.clone();


        //Toast.makeText(getApplicationContext(), clone_str.peek(), Toast.LENGTH_SHORT).show();



        for(int i=0; i<str_num; i++){
            rs += clone_str.peek() + " ";
            clone_str.poll();
        }


        for(int i=0; i<ints_num; i++){
            rn += clone_ints.peek() + " ";
            clone_ints.poll();
        }


        string.setText(rs);
        number.setText(rn);


    }
}
