package hackerearth;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class InAnArray {

    private static int findCountOfUnorderedPairs(int[] arr, int n, int k, int x, int y) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            } else {
                map.put(arr[i],1);
            }
        }
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            map.put(arr[i],map.get(arr[i])-1);
            int a1 = reverseModulusForSum(k,arr[i],x);
            int a2 = reverseModulusForProduct(k,arr[i],x);
            System.out.println(arr[i] + " " + a1 + " " + a2);
            if(a1 == a2 && map.get(a1) > 0){
                count++;
            }
            map.put(arr[i],map.get(arr[i])+1);
        }
        return count;
    }

    private static int reverseModulusForProduct(int div, int a, int remainder)
    {
        if(remainder >= div){
            return -1;
        }
        if(a < remainder)
            return remainder / a;
        return (div + remainder) / a;
    }

    private static int reverseModulusForSum(int div, int a, int remainder)
    {
        if(remainder >= div){
            return -1;
        }
        if(a < remainder)
            return remainder - a;
        return div + remainder - a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        int n = Integer.parseInt(ip[0]);
        int k = Integer.parseInt(ip[1]);
        int x = Integer.parseInt(ip[2]);
        int y = Integer.parseInt(ip[3]);
        ip = br.readLine().split(" ");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(ip[i]);
        }
        System.out.println(findCountOfUnorderedPairs(arr,n,k,x,y));
    }
}
