package com.example.gimmyeongsu.project01;

/**
 * Created by gimmyeongsu on 2016. 9. 30..
 */

public class Minimum extends Value {
    public int GetNumber(int[] arr){
        int n;
        if(arr!=null) {
            n=arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (n > arr[i]) {
                    n = arr[i];
                }
            }
        }
        else{
            n = 0;
        }
        return n;
    }
}
