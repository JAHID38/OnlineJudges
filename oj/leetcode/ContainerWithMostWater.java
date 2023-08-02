package oj.leetcode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        //2-pointer approach
        //leftMost & rightMost indexes
        int left = 0;
        int right = height.length - 1;
        //width = difference of both indices
        //loop: make width > 0
        while (left <= right)
        {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return maxArea;
    }
}
