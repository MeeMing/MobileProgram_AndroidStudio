package com.example.gimmyeongsu.quickcoding04;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    private TextView textlat;
    private TextView textlon;
    private Button gpsbutton;

    private GpsInfo gpsInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textlat = (TextView)findViewById(R.id.tvLatitude);
        textlon = (TextView)findViewById(R.id.tvLongitude);
        gpsbutton = (Button)findViewById(R.id.GPSButton);

        gpsInfo = new GpsInfo(MainActivity.this);

        gpsbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){

                if(gpsInfo.isGetLocation){
                    double lat = gpsInfo.getLatitude();
                    double lon = gpsInfo.getLongitude();

                    textlat.setText(String.valueOf(lat));
                    textlon.setText(String.valueOf(lon));

                    Toast.makeText(getApplicationContext(), lat + ", " + lon, Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}
