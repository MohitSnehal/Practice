package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class TheNormalType {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String inp[] = br.readLine().split(" ");// Reading input from STDIN
        int arr[] = new int[n];
        HashSet<Integer> totalDistinctNumbers = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(inp[i]);
            if(!totalDistinctNumbers.contains(arr[i])){
                totalDistinctNumbers.add(arr[i]);
            }
        }
        long count = 0;
        for(int i = 0 ; i < n ; i++){
            HashSet<Integer> setOfCurrrentDistinct = new HashSet<>();
            for(int j=i ; j < n ; j++){
                setOfCurrrentDistinct.add(arr[j]);
                if(setOfCurrrentDistinct.size() == totalDistinctNumbers.size()){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
