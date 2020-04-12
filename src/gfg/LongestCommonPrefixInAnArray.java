package gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class LongestCommonPrefixInAnArray {

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0){
            int size = Integer.parseInt(br.readLine());
            String strArray[] = br.readLine().split(" ");
            System.out.println(findLongestCommonPrefix(strArray, size));
            t--;
        }
    }

    private static String findLongestCommonPrefix(String[] strArray, int size) {
        TrieNode root = new TrieNode();
        root.value = '$';

        for(String str : strArray) {
            char charArray[] = str.toCharArray();
            insertIntoTrie(charArray,root);
        }

        String prefixString = findCommonPrefixFromTrie(root , size);
        
        return prefixString;
    }

    private static String findCommonPrefixFromTrie(TrieNode root , int count) {
        String result = "";
        TrieNode currNode = root;
        while(currNode != null){
            if(currNode.adjacentNodeMap.size() == 1) {
                for(char key : currNode.adjacentNodeMap.keySet()){
                    if(currNode.adjacentNodeMap.get(key).freq == count){
                        currNode = currNode.adjacentNodeMap.get(key);
                        result += key;
                        break;
                    } else {
                        return result.equals("") ? "-1": result;
                    }
                }
            } else {
                break;
            }
        }
        return result.equals("") ? "-1": result;
    }

    private static void insertIntoTrie(char[] charArray, TrieNode root) {
        TrieNode currNode = root;
        for(char curr : charArray){
            if(currNode.adjacentNodeMap.containsKey(curr)){
                currNode.adjacentNodeMap.get(curr).freq+=1;
                currNode = currNode.adjacentNodeMap.get(curr);
            } else {
                TrieNode temp = new TrieNode();
                temp.value = curr;
                temp.freq = 1;
                currNode.adjacentNodeMap.put(curr,temp);
                currNode = temp;
            }
        }
    }
}

class TrieNode {
    char value;
    int freq;
    HashMap<Character,TrieNode> adjacentNodeMap = new HashMap<>();

}
