package oj.leetcode.easy;

public class MaximumAverageSubarrayI_643 {
    public double findMaxAverage(int[] nums, int k) {
        double avg = 0, sum = 0;

        int i = 0;
        for (i = 0; i < k; i++)
        {
            sum += nums[i];

        }
        avg = sum/k;

        //window sliding:
        for (int idx = i; idx < nums.length; idx++)
        {
            int prev = nums[idx-k];
            sum -= prev;
            sum += nums[idx];
            if (sum/k > avg){
                avg = sum/k;
            }
        }

        return avg;
    }
}
