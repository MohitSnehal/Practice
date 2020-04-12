package gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class RecursivelyRemoveAllAdjacentDuplicates {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0){
            char[] str = br.readLine().toCharArray();
            System.out.println(removeDuplicates(str,str.length));
            t--;
        }
    }

    private static String removeDuplicates(char[] str, int length) {
        Stack<Character> resultStack = new Stack<>();

        for(int i = 0 ; i < length ; i++){
            if(resultStack.isEmpty()) {
                resultStack.push(str[i]);
                continue;
            }
            char stackTop = resultStack.pop();
            if(stackTop == str[i]){
                while(i < length && stackTop == str[i]){
                    i++;
                }
                i--;
            } else {
                resultStack.push(stackTop);
                resultStack.push(str[i]);
            }
        }

        String resultString = "";
        while(!resultStack.isEmpty()){
            resultString = String.valueOf(resultStack.pop()) + resultString;
        }
        return resultString;
    }

}
