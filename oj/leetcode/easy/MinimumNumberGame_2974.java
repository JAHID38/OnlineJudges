package oj.leetcode.easy;

import java.util.Arrays;

public class MinimumNumberGame_2974 {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i+=2)
        {
            int temp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = temp;
        }
        return nums;
    }
}
