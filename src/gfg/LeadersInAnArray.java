package gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

import static java.lang.Math.max;

public class LeadersInAnArray {

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
            System.out.println(findLeader(arr,n));
            t--;
        }
    }

    private static String findLeader(long[] arr, int n) {
        long maxFromRight = 0;
        String result = "";
        for(int i = n-1 ; i >= 0 ; i--) {
            if(maxFromRight <= arr[i]){
                result += arr[i] + (i == 0 ? "" : " ");
                maxFromRight = arr[i];
            }
        }

        return result;
    }
}
