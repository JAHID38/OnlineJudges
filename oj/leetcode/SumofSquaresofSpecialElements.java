package oj.leetcode;

public class SumofSquaresofSpecialElements {
    public int sumOfSquares(int[] nums) {
        int sum = 0, i = 0, length = nums.length;
        while (i < length){
            if (length % (i+1) == 0){
                sum += Math.pow(nums[i], 2);
            }
            i++;
        }
        return sum;
    }
}
