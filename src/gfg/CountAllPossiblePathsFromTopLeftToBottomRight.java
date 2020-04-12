package gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountAllPossiblePathsFromTopLeftToBottomRight {

    static final long MOD_VALUE = 1000000007l;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String ip[] = br.readLine().split(" ");
            int m = Integer.parseInt(ip[0]);
            int n = Integer.parseInt(ip[1]);
            System.out.println(countAllWays(m,n));
        }
    }

    private static long countAllWays(int m, int n) {
        long mat[][] = new long[m][n];

        for(int i = 0 ; i < m ; i++){
            mat[i][0] = 1;
        }
        for(int i = 0 ; i < n ; i++){
            mat[0][i] = 1;
        }

        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                mat[i][j] = (mat[i-1][j] + mat[i][j-1]) % MOD_VALUE;
            }
        }

        return mat[m-1][n-1];
    }
}
