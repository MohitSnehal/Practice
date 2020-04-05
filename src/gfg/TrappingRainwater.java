package gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class TrappingRainwater {

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
            System.out.println(calculateTrappedRainwater(arr,n));
            t--;
        }
    }

    private static long calculateTrappedRainwater(long[] arr, int n) {
        long leftMax[] = new long[n];
        long rightMax[] = new long[n];

        leftMax[0] = arr[0];
        for(int i = 1 ; i < n ; i++){
            leftMax[i] = max(leftMax[i-1],arr[i]);
        }

        rightMax[n-1] = arr[n-1];
        for(int i = n-2 ; i >= 0 ; i--){
            rightMax[i] = max(rightMax[i+1],arr[i]);
        }

        long totalWater = 0;
        for(int i = 0 ; i < n ;i++){
            totalWater += (min(leftMax[i],rightMax[i]) - arr[i]);
        }
        return totalWater;
    }
}
