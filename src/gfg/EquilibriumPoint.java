package gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Math.max;

public class EquilibriumPoint {
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
            System.out.println(findEquillibriumPoint(arr,n));
            t--;
        }
    }

    private static int findEquillibriumPoint(long[] arr, int n) {
        long leftSum[] = new long[n];
        long rightSum[] = new long[n];

        leftSum[0] = 0;
        for(int i = 1 ; i < n ; i++){
            leftSum[i] = leftSum[i-1] + arr[i-1];
        }

        rightSum[n-1] = 0;
        for(int i = n-2 ; i >= 0 ; i--){
            rightSum[i] = rightSum[i+1] + arr[i+1];
        }

        for(int i = 0 ; i < n ; i++){
            if(leftSum[i] == rightSum[i]) {
                return i+1;
            }
        }
        return -1;
    }
}
