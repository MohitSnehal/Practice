package gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KadanesAlgorithm {

    public static long runAlgorithm(long[] arr , int n){
        long sum[] = new long[n];
        sum[0] = arr[0];
        long maxSum = sum[0];
        for(int i = 1 ; i < n ; i++){
            sum[i] = sum[i-1] + arr[i] >= arr[i] ? sum[i-1] + arr[i] : arr[i];
            if(sum[i] >= maxSum){
                maxSum = sum[i];
            }
        }
        return maxSum;
    }

    public static void main (String[] args) throws Exception{
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
            System.out.println(runAlgorithm(arr,n));
            t--;
        }
    }
}
