package com.example.gimmyeongsu.project01;

/**
 * Created by gimmyeongsu on 2016. 9. 30..
 */

public class Average extends Value{

    public int GetNumber(int[] arr){
        int n=0;
        if(arr!=null) {
            for (int i = 0; i < arr.length; i++) {
                n += arr[i];
            }
            n/=arr.length;
        }
        return n;
    }

}
