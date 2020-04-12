package gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrintKElementsOfArray {

    static void print(int arr[]  ,int n , int r){
        int data[] = new int[r];

        printUtil(arr,data,0,n-1,0,r);
    }

    private static void printUtil(int[] arr, int[] data, int start, int end, int index, int r) {

        if(index == r){
            for(int val : data){
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start ; i <= end && end-i+1 >= r-index ; i++){
            data[index] = arr[i];
            printUtil(arr,data,i+1,end,index+1,r);
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ip[] = br.readLine().split(" ");
        int n = Integer.parseInt(ip[0]);
        int k = Integer.parseInt(ip[1]);
        int arr[] = new int[n];
        ip = br.readLine().split(" ");
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(ip[i]);
        }
        print(arr,n,k);
    }
}
