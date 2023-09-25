package oj.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class FindtheDifference_389 {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (char c : s.toCharArray())
        {
            sMap.put(c, sMap.getOrDefault(c, 0)+1);
        }
        for (char c : t.toCharArray())
        {
            tMap.put(c, tMap.getOrDefault(c, 0)+1);
        }
        System.out.println(sMap);
        System.out.println(tMap);
        for (char c : tMap.keySet())
        {
            if (tMap.get(c) != sMap.get(c))
            {
                System.out.println(c);
                return c;
            }
        }
        return t.charAt(0);
    }
}

