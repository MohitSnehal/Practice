package gfg;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MergeWithoutExtraSpace {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String ip[] = null;
        StringBuffer output = new StringBuffer();
        while(t > 0){
            ip = br.readLine().split(" ");
            int n1 = Integer.parseInt(ip[0]);
            int n2 = Integer.parseInt(ip[1]);
            ip = br.readLine().split(" ");
            String ip2[] = br.readLine().split(" ");

            CompositeArray arr = new CompositeArray(n1,n2);
            for(int i = 0 ; i < n1 || i < n2 ; i++){
                if(i < n1){
                    arr.arr1[i] = Integer.parseInt(ip[i]);
                }
                if(i < n2){
                    arr.arr2[i] = Integer.parseInt(ip2[i]);
                }
            }

            arr.quickSort(0,arr.n-1);
            output.append(arr.print());
            t--;
        }
        System.out.println(output);
    }

}

class CompositeArray {
    int arr1[], arr2[], n1, n2 , n;

    public CompositeArray(int n1 , int n2){
        this.arr1 = new int[n1];
        this.arr2 = new int[n2];
        this.n1 = n1;
        this.n2 = n2;
        this.n = n1+n2;
    }

    public int get(int pos){
        if(pos < n1){
            return arr1[pos];
        } else {
            return arr2[pos-n1];
        }
    }

    public void put(int pos , int val){
        if(pos < n1){
            arr1[pos] = val;
        } else {
            arr2[pos-n1] = val;
        }
    }

    public void swap(int pos1 , int pos2){
        int temp = get(pos1);
        put(pos1,get(pos2));
        put(pos2,temp);
    }

    public void quickSort(int l , int r){
        if(l<r) {
            int pi = pivot(l, r);
            quickSort(l, pi - 1);
            quickSort(pi + 1, r);
        }
    }

    private int pivot(int l, int r) {
        int pindex = l;
        for(int i = l ; i < r ; i++){
            if(get(i) < get(r)){
                swap(i,pindex);
                pindex++;
            }
        }
        swap(pindex,r);
        return pindex;
    }

    public StringBuffer print() {
        StringBuffer result = new StringBuffer();
        for(int i = 0 ; i < n ; i++){
            if(i < n1){
                result.append(arr1[i] + " ");
            }else {
                result.append(arr2[i - n1] + ((i == n - 1) ? "\n" : " "));
            }
        }
        return result;
    }
}