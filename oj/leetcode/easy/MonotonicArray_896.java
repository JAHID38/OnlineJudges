package oj.leetcode.easy;

public class MonotonicArray_896 {
    public boolean isMonotonic(int[] nums) {
        if (nums.length == 1)
            return true;
        int i=1;
        while (i < nums.length-1 && nums[i] == nums[i-1])            {
            i++;
        }
        if (i == nums.length-1) return true;
        int diff = nums[i] - nums[i-1];
        if (diff > 0)
        {
            while (i < nums.length){
                if (nums[i] < nums[i-1]){
                    return false;
                }
                i++;
            }
        }
        else if (diff < 0){
            while (i < nums.length){
                if (nums[i] > nums[i-1]){
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}
