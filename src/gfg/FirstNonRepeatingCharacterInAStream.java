package gfg;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.InputStreamReader;

public class FirstNonRepeatingCharacterInAStream {

    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t > 0){
            String ip = br.readLine();
            int n = Integer.parseInt(ip);
            String string = br.readLine();
            String[] stringArray = string.split(" ");
            boolean[] charAlreadyVisited = new boolean[26];
            ArrayList<Character> list = new ArrayList<>();
            for(int i = 0 ; i < stringArray.length ; i++) {
                char currChar = stringArray[i].charAt(0);
                int position = (int)currChar - (int)'a';
                if(charAlreadyVisited[currChar - 'a']){
                    list = deleteCurrCharFromList(list,currChar);
                } else {
                    charAlreadyVisited[currChar - 'a'] = true;
                    list.add(currChar);
                }
                if(list.isEmpty()){
                    System.out.print(i == stringArray.length - 1 ? "-1" : "-1 ");
                } else {
                    System.out.print(i == stringArray.length - 1 ? list.get(0) : list.get(0) + " ");
                }
            }
            System.out.println();
            t--;
        }
    }

    private static ArrayList<Character> deleteCurrCharFromList(ArrayList<Character> list, char currChar) {
        for(int pos = 0 ; pos < list.size() ; pos++){
            if(list.get(pos).equals(currChar)){
                list.remove(pos);
            }
        }
        return list;
    }

}
