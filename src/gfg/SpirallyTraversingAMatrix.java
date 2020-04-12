package gfg;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SpirallyTraversingAMatrix {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String ip[] = null;
        while(t > 0){
            ip = br.readLine().split(" ");
            int m = Integer.parseInt(ip[0]);
            int n = Integer.parseInt(ip[1]);
            ip = br.readLine().split(" ");
            int arr[][] = new int[m][n];
            for(int i = 0 ; i < m ; i++){
                for(int j = 0 ; j < n ; j++){
                    arr[i][j] = Integer.parseInt(ip[i*n + j]);
                }
            }
            printMatrixSpirally(arr,m,n);
            t--;
        }
    }

    private static void printMatrixSpirally(int[][] arr, int m, int n) {
        int h1 = 0 , h2 = n-1;
        int v1 = 0 , v2 = m-1;
        String result = "";
        while(h1 <= h2 && v1 <= v2) {
            for(int i = h1 ; i <= h2 ; i++){
                result += arr[v1][i] + " ";
            }
            v1++;

            for(int i = v1 ; i <= v2 ; i++){
                result += arr[i][h2] + " ";
            }
            h2--;

            if(v1 < v2) {
                for(int i = h2 ; i >= h1 ; i--){
                    result += arr[v2][i] + " ";
                }
                v2--;
            }

            if(h1 <= h2){
                for(int i = v2 ; i >= v1 ; i--){
                    result += arr[i][h1] + " ";
                }
                h1++;
            }

        }
        result = result.substring(0,result.length()-1);
        System.out.println(result);

    }
}
