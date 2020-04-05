package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CanYouSolveIt {
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuffer stringBuffer = new StringBuffer();
        while(t > 0){
            String ip = br.readLine();
            int n = Integer.parseInt(ip);
            String inp[] = br.readLine().split(" ");
            int arr[] = new int[n];
            for(int i = 0 ; i < n ; i++){
                arr[i] = Integer.parseInt(inp[i]);
            }
            int exp1[] = new int[n];
            int exp2[] = new int[n];
            int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE,min2 = Integer.MAX_VALUE;
            for(int i = 0 ; i < n ; i++){
                exp1[i] = arr[i] + i;
                if(max1 <= exp1[i]) {
                    max1 = exp1[i];
                }
                if(min1 >= exp1[i]){
                    min1 = exp1[i];
                }
                exp2[i] = arr[i] - i;
                if(max2 <= exp2[i]) {
                    max2 = exp2[i];
                }
                if(min2 >= exp2[i]){
                    min2 = exp2[i];
                }
            }
            int max = Math.max(max2-min2,max1-min1);
            System.out.println(max);
            t--;
        }

    }
}
