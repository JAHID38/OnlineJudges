package oj.leetcode.easy;

import java.util.Arrays;

public class MaximumProductofThreeNumbers_628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int product = 1, i = nums.length-1;
        while (i > nums.length-4)
        {
            product *= nums[i];
            i--;
        }

        return Math.max(product, nums[0]*nums[1]*nums[nums.length-1]);
    }
}
