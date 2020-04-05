package leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class ReverseInteger {
    public static int reverse(int x) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean isNegative = x < 0 ;
        int n = isNegative ? x*-1 : x;
        while(n != 0){
            list.add(n%10);
            n = n/10;
        }
        if(x <= 2147483647 && x >= -2147483648){
            long reversedInt = 0;
            while(!list.isEmpty()){
                reversedInt += (long)list.get(0) * powerOf10((long)list.size()-1);
                list.remove(0);
            }
            if(reversedInt <= 2147483647 && reversedInt >= -2147483648){
                return isNegative ? (int)reversedInt * -1 : (int) reversedInt;
            } else {
                return 0;
            }

        } else {
            return 0;
        }
    }

    private static long powerOf10(long numberOfDigits) {
        return (long)(Math.pow(10,numberOfDigits));
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reverse(Integer.parseInt(br.readLine())));
    }
}
