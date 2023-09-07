package oj.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;

public class CounttheNumberofConsistentStrings_1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> allowedSet = new HashSet<>();
        int count = 0;
        for (char c : allowed.toCharArray())
        {
            allowedSet.add(c);
        }
        for (String word : words)
        {
            boolean isConsistent = true;
            for (char c : word.toCharArray())
            {
                if (!allowedSet.contains(c)) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent) {
                count++;
            }
        }
        return count;
    }
}
