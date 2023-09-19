package oj.leetcode.medium;

import java.util.HashMap;

public class FindtheDuplicateNumber_287 {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
        {
            map.put(num, map.getOrDefault(num, 0)+1);
            if (map.get(num) > 1)
            {
                return num;
            }
        }
        return 0;
    }
}
