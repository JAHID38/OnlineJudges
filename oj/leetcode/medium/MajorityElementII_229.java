package oj.leetcode.medium;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
public class MajorityElementII_229 {
    public List<Integer> majorityElement(int[] nums) {
        int threshold  = nums.length/3;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums)
        {
            map.put(n, map.getOrDefault(n, 0)+1);
            if (map.get(n) > threshold){
                set.add(n);
            }
        }
        return set.stream().toList();
    }
}
