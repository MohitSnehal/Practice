package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BeautifulSegments {
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0){
            String ip = br.readLine();
            int n = Integer.parseInt(ip);
            String inp[] = br.readLine().split(" ");
            int arr[] = new int[n];
            for(int i = 0 ; i < n ; i++){
                arr[i] = Integer.parseInt(inp[i]);
            }
            int result = 0;
            for(int i = 0 ; i < n ;){
                int start = i;
                int mid = -1;
                while(i < n) {
                    if(i + 1 < n && arr[i] > arr[i+1]){
                        mid = i;
                        break;
                    }
                    i++;
                }
                int end = i;
                if(mid != -1){
                    while(i < n) {
                        if(i + 1 < n && arr[i] <= arr[i+1]){
                            break;
                        }
                        if(i + 1 == n-1 && arr[i] > arr[i+1]){
                            i++;
                            break;
                        }
                        i++;
                    }
                    if(mid == i) {
                        continue;
                    }
                    end = i;
                } else {
                    continue;
                }
                result += ((mid-start) * (end - mid));
                if(end == n-1) {
                    break;
                }
            }
            System.out.println(result);
            t--;
        }

    }
}
