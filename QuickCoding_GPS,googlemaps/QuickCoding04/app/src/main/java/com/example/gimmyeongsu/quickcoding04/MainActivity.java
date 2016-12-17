package com.example.gimmyeongsu.quickcoding04;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {





    private TextView textlat;
    private TextView textlon;
    private Button gpsbutton;
    private Button mapbutton;
    private Button addbutton;
    private EditText addedittext;
    private GpsInfo gpsInfo;
    private Button statisticsbutton;
    private TextView statisticstext;

    public DataList datalist = new DataList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] iTem = new String[1];
        Spinner s = (Spinner)findViewById(R.id.spinner);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                iTem[0] = (String) parent.getItemAtPosition(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });




        textlat = (TextView)findViewById(R.id.tvLatitude);
        textlon = (TextView)findViewById(R.id.tvLongitude);
        gpsbutton = (Button)findViewById(R.id.GPSButton);
        //gpsInfo = new GpsInfo(MainActivity.this);

        gpsbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                gpsInfo = new GpsInfo(MainActivity.this);
                if(gpsInfo.isGetLocation){
                    double lat = gpsInfo.getLatitude();
                    double lon = gpsInfo.getLongitude();

                    textlat.setText(String.valueOf(lat));
                    textlon.setText(String.valueOf(lon));
                    //Toast.makeText(getApplicationContext(), iTem[0], Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), lat + ", " + lon, Toast.LENGTH_SHORT).show();
                }

            }
        });


        mapbutton = (Button)findViewById(R.id.button_Maps);
        mapbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent map = new Intent (getApplicationContext(), MapView.class);
                startActivity(map);
            }
        });




        addbutton = (Button)findViewById(R.id.button_add);
        addedittext = (EditText)findViewById(R.id.editText_intext);
        addbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(gpsInfo.isGetLocation){
                    double lat = gpsInfo.getLatitude();
                    double lon = gpsInfo.getLongitude();
                    String intext = addedittext.getText().toString();


                    datalist.lat.add(lat);
                    datalist.lng.add(lon);
                    datalist.intext.add(intext);
                    datalist.item.add(iTem[0]);

                    Toast.makeText(getApplicationContext(), datalist.intext.get(datalist.intext.size()-1), Toast.LENGTH_SHORT).show();

                }
            }
        });

        statisticstext = (TextView)findViewById(R.id.textview_statistic);
        statisticsbutton = (Button)findViewById(R.id.button_statistic);
        statisticsbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int num1=0;
                int num2=0;
                int num3=0;
                int num4=0;

                for(int i=0;i<datalist.item.size();i++){
                    if(datalist.item.get(i).equals("식사")){
                        num1++;
                    }
                    else if(datalist.item.get(i).equals("여가")){
                        num2++;
                    }
                    else if(datalist.item.get(i).equals("공부")){
                        num3++;
                    }
                    else if(datalist.item.get(i).equals("기타")){
                        num4++;
                    }
                }


                String text = "식사 : " + num1 + "\n" + "여가 : " + num2 + "\n" +"공부 : " + num3 + "\n" + "기타 : " + num4;
                statisticstext.setText(text);
            }
        });




    }
}
