package gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LongestIncreasingSubsequence {

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
            System.out.println(findLongestIncreasingSubsequence(arr,n));
            t--;
        }
    }

    private static int findLongestIncreasingSubsequence(long[] arr, int n) {
        int lis[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            lis[i] = 1;
        }

        for(int i = 1 ; i < n ; i++){
            for(int j = i-1 ; j >= 0 ; j--){
                if(arr[i] > arr[j] && lis[i] < lis[j]+1){
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int max = 0;
        for(int i = 0 ; i < n ; i++){
            if(max < lis[i]){
                max = lis[i];
            }
        }
        return max;
    }
}
