package gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0){
            String str = br.readLine();
            System.out.println(removeDuplicates(str, str.length()));
            t--;
        }
    }

    private static String removeDuplicates(String str, int length) {
        Set<Character> set = new HashSet<>();
        String result = "";
        for(int i = 0 ; i < length ; i++){
            char curr = str.charAt(i);
            if(!set.contains(curr)){
                result += curr;
                set.add(curr);
            }
        }

        return result;
    }
}
