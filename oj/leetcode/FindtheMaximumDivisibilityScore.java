package oj.leetcode;

public class FindtheMaximumDivisibilityScore {
    public int maxDivScore(int[] nums, int[] divisors) {
        int sum, maxCount = -1, maxVal = Integer.MAX_VALUE;
        for (int divisor : divisors){
            sum = 0;
            for (int num : nums){
                if (num % divisor == 0){
                    sum++;
                }
            }
            if (sum >= maxCount){
                maxVal = (maxCount == sum) ? Math.min(maxVal, divisor) : divisor;
                maxCount = sum;
            }
        }
        return maxVal;
    }}
