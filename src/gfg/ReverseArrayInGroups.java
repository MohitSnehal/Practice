package gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ReverseArrayInGroups {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String ip[] = null;
        while(t > 0){
            ip = br.readLine().split(" ");
            int n = Integer.parseInt(ip[0]);
            int k = Integer.parseInt(ip[1]);
            ip = br.readLine().split(" ");
            long arr[] = new long[n];
            for(int i = 0 ; i < n ; i++){
                arr[i] = Long.parseLong(ip[i]);
            }
            reverseInGroups(arr,n,k);
            for(int i = 0 ; i < n ; i++){
                System.out.print(arr[i] + ((i == n-1) ? "\n" : " "));
            }
            System.out.println();
            t--;
        }
    }

    private static void reverseInGroups(long[] arr, int n, int k) {
        for(int index = 0 ; index < n ; index += k){
            int i = index;
            int j = (i+k-1) > n-1 ? n-1 : i+k-1;
            while(i < j){
                swap(i,j,arr);
                i++;
                j--;
            }
        }
    }

    private static void swap(int i, int j, long[] arr) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
