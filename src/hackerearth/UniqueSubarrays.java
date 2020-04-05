package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;

public class UniqueSubarrays {

    public static long findSum(long n , long a){
        long sumOFN = (( n * (n+1)) / 2);
        BigInteger x = new BigInteger(String.valueOf(n)).multiply(new BigInteger(String.valueOf((n + 1))));
        BigInteger y = new BigInteger(String.valueOf(((2*n) + 1)));
        BigInteger result = x.multiply(y).divide(new BigInteger("6"));
        long sumOFNSq = (result.longValue());
        long sum = 2 * ((a+1) * (int) sumOFN - ( (int)sumOFNSq));
        if(a % 2 != 0)
            sum += ((n+1)*(n+1));
        return sum;
    }

    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuffer stringBuffer = new StringBuffer();
        while(t > 0){
            String ip = br.readLine();
            int n = Integer.parseInt(ip);
            String inp[] = br.readLine().split(" ");
            long arr[] = new long[n];
            for(int i = 0 ; i < n ; i++){
                arr[i] = Long.parseLong(inp[i]);
            }
            int i = 0;
            long count = 0;
            long commonLength = 0;
            while(i < n){
                long length = 0;
                HashMap<Long,Integer> map = new HashMap();
                while(i < n && !map.containsKey(arr[i])){
                    map.put(arr[i],i);
                    i++;
                    length++;
                }
                if(length > 1){
                    count += findSum(length/2,length);

                } else if (length == 1){
                    count += length;
                }
                if(commonLength >= 1){
                    count -= findSum(commonLength/2,commonLength);

                } else if (commonLength == 1){
                    count -= commonLength;
                }
                if(i < n) {
                    if(map.get(arr[i]) != i){
                        commonLength = i - map.get(arr[i]) - 1;
                    }
                    i = map.get(arr[i]) + 1;

                }
            }
            System.out.println(count);
            System.out.println(Long.MAX_VALUE);
            t--;
        }
    }
}