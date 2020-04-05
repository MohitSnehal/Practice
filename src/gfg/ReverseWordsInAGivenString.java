package gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ReverseWordsInAGivenString {

    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String ip = null;
        Stack<String> stringStack = null;
        while(t > 0){
            ip = br.readLine();
            stringStack = new Stack<>();
            String curr = "";
            char[] strArray = ip.toCharArray();
            for(char currChar : strArray){
                if(currChar == '.'){
                    stringStack.push(curr);
                    curr = "";
                } else {
                    curr += currChar;
                }
            }
            if(!curr.equals("")){
                stringStack.push(curr);
            }
            printStack(stringStack);
            t--;
        }
    }

    private static void printStack(Stack<String> stringStack) {
        while(!stringStack.isEmpty()){
            String curr = stringStack.pop();
            System.out.print(stringStack.isEmpty() ? curr + "\n" : curr + ".");
        }
    }
}
