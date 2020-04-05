package gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RearrangeArrayAlternately {
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
            rearrange(arr,n);
            for(int i = 0 ; i < n ; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            t--;
        }
    }

    private static void rearrange(long[] arr, int n) {
        int maxIndex = n-1;
        int minIndex = 0;
        long maxValue = arr[maxIndex] + 1;

        for(int i = 0 ; i < n ; i++){
            if(i % 2 == 0){
                arr[i] += (arr[maxIndex] % maxValue) * maxValue;
                maxIndex--;
            } else {
                arr[i] += (arr[minIndex] % maxValue) * maxValue;
                minIndex++;
            }
        }

        for(int i = 0 ; i < n ; i++){
            arr[i] = arr[i] / maxValue;
        }
    }
}
