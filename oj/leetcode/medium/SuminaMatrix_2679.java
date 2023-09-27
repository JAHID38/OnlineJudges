package oj.leetcode.medium;

import java.util.Arrays;

public class SuminaMatrix_2679 {
    public int matrixSum(int[][] nums) {


        for (int [] unsortedRows : nums)
        {
            Arrays.sort(unsortedRows);

        }
        int max, sum = 0, rows = nums.length, cols = nums[0].length, colIdx = 0;
        while (colIdx < cols)
        {
            max = -1;
            for (int rowIdx = 0; rowIdx < rows; rowIdx++)
            {
                max = Math.max(nums[rowIdx][colIdx], max);
            }
            System.out.println(max);
            sum += max;
            colIdx++;
        }
        return sum;
    }
}
