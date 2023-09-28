package oj.leetcode.easy;

public class SortArrayByParity_905 {
    public int[] sortArrayByParity(int[] nums) {
        int evenIdx = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] % 2 == 0)
            {
                int temp = nums[i];
                nums[i] = nums[evenIdx];
                nums[evenIdx++] = temp;
            }
        }

        return nums;
    }
}
