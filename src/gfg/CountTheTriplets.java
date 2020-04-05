package gfg;

import java.util.*;
import java.lang.*;
import java.io.*;

class CountTheTriplets {

    public static String countTriplets(long arr[] , int n){
        HashMap<Long,Integer> freq = new HashMap<>();
        for(long val : arr){
            if(freq.containsKey(val)){
                freq.put(val , freq.get(val)+1);
            } else {
                freq.put(val , 1);
            }
        }
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            long a = arr[i];
            freq.put(a , freq.get(a)-1);
            for(int j = i+1 ; j < n ; j++){
                long b = arr[j];
                freq.put(b , freq.get(b)-1);
                if(freq.containsKey(a+b) && freq.get(a+b) > 0){
                    count++;
                }
                freq.put(b , freq.get(b)+1);
            }
            freq.put(a , freq.get(a)+1);
        }
        return count == 0 ? "-1" : String.valueOf(count);
    }

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String ip[] = null;
        while(t > 0){
            ip = br.readLine().split(" ");
            int n = Integer.parseInt(ip[0]);
            ip = br.readLine().split(" ");
            long arr[] = new long[n];
            for(int i = 0 ; i < n ; i++){
                arr[i] = Long.parseLong(ip[i]);
            }
            System.out.println(countTriplets(arr,n));
            t--;
        }
    }
}