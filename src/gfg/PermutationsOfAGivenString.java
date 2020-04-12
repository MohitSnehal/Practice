package gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.*;
import java.util.*;

public class PermutationsOfAGivenString {

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0){
            String str = br.readLine();
            ArrayList<String> resultList = new ArrayList<>();
            printPermutations(str, 0,str.length()-1,resultList );
            Collections.sort(resultList);
            for(int i = 0 ; i < resultList.size() ; i++) {
                System.out.print(resultList.get(i) + ((i != resultList.size()-1) ? " " : "\n"));
            }
            t--;
        }
    }

    private static void printPermutations(String str , int l , int r,ArrayList<String> resultList) {
        if(l == r){
            resultList.add(str);
        } else {
            for(int i = l ; i <= r ; i++){
                str = swap(str,i,l);
                printPermutations(str,l+1,r,resultList);
                str = swap(str,i,l);
            }
        }
    }

    private static String swap(String str, int i, int j) {
        char temp;
        char[] charArray = str.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
