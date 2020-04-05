package interviewbit;

import java.util.ArrayList;

public class SetMatrixZeros {
    /* Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.
        Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.
    */

    public static void main(String arg[]){

    }

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        boolean rowVisited[] = new boolean[a.size()];
        boolean columnVisited[] = new boolean[a.get(0).size()];

        for(int i = 0 ; i < a.size() ; i++){
            for(int j = 0 ; j < a.get(i).size() ; j++) {
                if(a.get(i).get(j) == 0) {
                    rowVisited[i] = true;
                    columnVisited[j] = true;
                }
            }
        }

        for(int i = 0 ; i < a.size() ; i++){
            for(int j = 0 ; j < a.get(i).size() ; j++) {
                if(rowVisited[i] || columnVisited[j]){
                    a.get(i).set(j,0);
                }
            }
        }
    }
}
