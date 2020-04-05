package gfg;

/*
    Link : https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
    Problem : Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class SubarrayWithGivenSum {

    public static String findSubbArrayWithSum(long arr[] , int n , int x){
        int i = 0, j = 0;
        long sum = arr[i];
        while(i < n && j < n){
            if(sum == x){
                return ( (i + 1) + " " + (j + 1) );
            } else if(sum < x){
                j++;
                if(j < n) {
                    sum += arr[j];
                }
            } else {
                sum -= arr[i];
                i++;
            }
        }
        return "-1";
    }

    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String ip[] = null;
        while(t > 0){
            ip = br.readLine().split(" ");
            int n = Integer.parseInt(ip[0]);
            int x = Integer.parseInt(ip[1]);
            ip = br.readLine().split(" ");
            long arr[] = new long[n];
            for(int i = 0 ; i < n ; i++){
                arr[i] = Long.parseLong(ip[i]);
            }
            System.out.println(findSubbArrayWithSum(arr,n,x));
            t--;
        }
    }
}