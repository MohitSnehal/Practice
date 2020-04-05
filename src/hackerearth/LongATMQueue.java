package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LongATMQueue {

    public static void main(String arg[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String ips[] = br.readLine().split(" ");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(ips[i]);
        }

        int count = 1;
        for(int i = 1 ; i < n ; i++){
            if(arr[i-1] > arr[i]){
                count++;
            }
        }
        System.out.println(count);
    }
}
