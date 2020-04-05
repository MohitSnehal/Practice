package leetcode;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        int pos = 0;
        for(int x : nums){
            if(map.containsKey(x)){
                map.get(x).add(pos);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(pos);
                map.put(x,set);
            }
            pos++;
        }
        pos = 0;
        int res[] = new int[2];
        for(int x : nums){
            int y = target - x;
            map.get(x).remove(pos);
            if(map.containsKey(y) && !map.get(y).isEmpty()){
                res[0] = pos;
                for(int pos1 : map.get(y)){
                    res[1] = pos1;
                    break;
                }
                break;
            }
            map.get(x).remove(pos);
            pos++;
        }
        return res;
    }
}
