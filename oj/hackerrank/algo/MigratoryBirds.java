package oj.hackerrank.algo;
import java.util.*;
public class MigratoryBirds {
    public  int migratoryBirds(List<Integer> arr) {
        // Write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr)
        {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int maxFreq = 0, minType = arr.size()+1;
        for (int value : map.values())
        {
            maxFreq = Math.max(value, maxFreq);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if (entry.getValue() == maxFreq)
            {
                minType = Math.min(minType, entry.getKey());
            }
        }
        return minType;
    }
}
