package algosAndDSImplementations;

public class KadanesAlgorithm {
    public static long runAlgorithm(long[] arr , int n){
        long sum[] = new long[n];
        sum[0] = arr[0];
        long maxSum = sum[0];
        for(int i = 1 ; i < n ; i++){
            sum[i] = sum[i-1] + arr[i] >= arr[i] ? sum[i-1] + arr[i] : arr[i];
            if(sum[i] >= maxSum){
                maxSum = sum[i];
            }
        }
        return maxSum;
    }
}