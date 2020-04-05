package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PrasunTheDetective {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        System.out.println(correctMessageOrNot(str1,str2));
    }

    private static String correctMessageOrNot(char[] str1, char[] str2) {
        HashMap<String,Integer> charToFreqMap = new HashMap<>();
        for(int i = 0 ; i < str1.length ; i++){
            String chStr = String.valueOf(str1[i]);
            if(charToFreqMap.containsKey(chStr)){
                if(!chStr.toUpperCase().equals(chStr.toLowerCase())){
                    charToFreqMap.put(chStr.toUpperCase() , charToFreqMap.get(chStr) + 1);
                    charToFreqMap.put(chStr.toLowerCase() , charToFreqMap.get(chStr) + 1);
                } else {
                    charToFreqMap.put(chStr , charToFreqMap.get(chStr) + 1);
                }

            } else {
                if(!chStr.toUpperCase().equals(chStr.toLowerCase())){
                    charToFreqMap.put(chStr.toUpperCase() , 1);
                    charToFreqMap.put(chStr.toLowerCase() , 1);
                } else {
                    charToFreqMap.put(chStr , 1);
                }
            }
        }
        for(int i = 0 ; i < str2.length ; i++){
            String chStr = String.valueOf(str2[i]);
            if(chStr.equals(" ")){
                continue;
            }
            if(charToFreqMap.containsKey(chStr)){
                int freq = charToFreqMap.get(chStr);
                if(freq == 0){
                    return "NO";
                }
                if(!chStr.toUpperCase().equals(chStr.toLowerCase())){
                    charToFreqMap.put(chStr.toUpperCase() , --freq);
                    charToFreqMap.put(chStr.toLowerCase() , freq);
                } else {
                    charToFreqMap.put(chStr , --freq);
                }
            } else {
                return "NO";
            }
        }
        return "YES";
    }
}
