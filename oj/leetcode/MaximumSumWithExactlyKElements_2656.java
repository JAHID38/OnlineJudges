package oj.leetcode;

public class MaximumSumWithExactlyKElements_2656 {
    public int maximizeSum(int[] nums, int k) {
        int maxVal = -1;
        for (int num : nums){
            maxVal = Math.max(maxVal, num);
        }
        int sum = maxVal;
        while (k-- > 1){
            sum += (++maxVal);
        }
        return sum;
    }
}
