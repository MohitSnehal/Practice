package gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LongestCommonSubstring {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String ip[] = br.readLine().split(" ");
            int l1 = Integer.parseInt(ip[0]);
            int l2 = Integer.parseInt(ip[1]);
            String str1 = br.readLine();
            String str2 = br.readLine();
            System.out.println(longestCommonSubstring(str1,str2,l1,l2));
        }
    }

    private static int longestCommonSubstring(String str1, String str2, int l1, int l2) {
        int lcs[][] = new int[l1+1][l2+1];
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < l1+1 ; i++) {
            for(int j = 0 ; j < l2+1 ; j++){
                if(i == 0 || j == 0) {
                    lcs[i][j] = 0;
                } else if(str1.charAt(i-1) == str2.charAt(j-1)){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                    max = Integer.max(lcs[i][j],max);
                } else {
                    lcs[i][j] = 0;
                }
            }
        }
        return max;
    }
}
