package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaximumGoodness {

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String ips[] = br.readLine().split(" ");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(ips[i]);
            if(arr[i] == 0) {
                arr[i] = -1;
            }
        }
        int maxSoFar = Integer.MIN_VALUE , maxEndingHere = 0;
        int start = 0 , end = 0 , s = 0;
        int length = 0;
        for(int i = 0 ; i < n ; i++){
            maxEndingHere += arr[i];
            if (maxSoFar <= maxEndingHere){
                maxSoFar = maxEndingHere;
                start = s;
                end = i;
            }

            if (maxEndingHere < 0){
                maxEndingHere = 0;
                s = i + 1;
            }
            if(end-start >= length){
                length = end-start+1;
            }
        }
        System.out.println(length);
    }
}
