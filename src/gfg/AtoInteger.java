package gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AtoInteger {

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = (br.readLine());
        int x = atoi(str,0);
        System.out.println(x);
    }

    private static int atoi(String str, int i) {
        if(i == str.length()){
            return 0;
        }
        return ((str.charAt(i) - '0') * (int)Math.pow(10,str.length()-i-1)) + atoi(str,i+1);
    }

}
