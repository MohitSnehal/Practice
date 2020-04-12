package gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.max;

public class LongestCommonSubsequence {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String ip[] = br.readLine().split(" ");
            int l1 = Integer.parseInt(ip[0]);
            int l2 = Integer.parseInt(ip[1]);
            String str1 = br.readLine();
            String str2 = br.readLine();
            System.out.println(longestCommonSubsequence(str1,str2,l1,l2));

            
        }
    }

    private static int longestCommonSubsequence(String str1, String str2, int l1, int l2) {
        int lcs[][] = new int[l1+1][l2+1];
        for(int i = 0 ; i < l1+1 ; i++){
            for(int j = 0 ; j < l2+1 ; j++){
                if(i == 0 || j == 0){
                    lcs[i][j] = 0;
                    continue;
                }
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = max(lcs[i-1][j],lcs[i][j-1]);
                }
            }
        }
        return lcs[l1][l2];
    }
}
