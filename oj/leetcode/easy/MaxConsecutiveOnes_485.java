package oj.leetcode.easy;

public class MaxConsecutiveOnes_485
{
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0, tmpCount = 0;
        for (int num : nums)
        {
            if (num == 1){
                tmpCount++;
            } else if (num == 0) {
                maxCount = Math.max(maxCount, tmpCount);
                tmpCount = 0;
            }
        }
        return Math.max(maxCount, tmpCount);
    }
}
