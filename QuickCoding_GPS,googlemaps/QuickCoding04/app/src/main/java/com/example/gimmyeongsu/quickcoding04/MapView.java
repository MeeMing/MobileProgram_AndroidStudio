package com.example.gimmyeongsu.quickcoding04;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by gimmyeongsu on 2016. 11. 16..
 */

public class MapView extends FragmentActivity{

    GoogleMap mMap;
    MarkerOptions marker;
    //LatLng seoul = new LatLng(0, 0);



    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_map);

        DataList datalist = new DataList();
        LatLng seoul = new LatLng(datalist.lat.get(datalist.lat.size()-1),datalist.lng.get(datalist.lat.size()-1));
        CameraPosition cp = new CameraPosition.Builder().target(seoul).zoom(15).build();

        mMap = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.maps)).getMap();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));


        for(int i = 0 ; i < datalist.lat.size(); i++){
            LatLng pinmark = new LatLng(datalist.lat.get(i),datalist.lng.get(i));
            marker = new MarkerOptions().snippet(datalist.item.get(i)).position(pinmark).title(datalist.intext.get(i));
            mMap.addMarker(marker);
        }



    }


}
