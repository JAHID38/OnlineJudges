package oj.leetcode;

public class FindtheScoreofAllPrefixesofanArray_2640 {
    public long[] findPrefixScore(int[] nums) {
        int max = -1, i = 0;
        long sum = 0;
        long [] conver = new long[nums.length];
        for (int num : nums){
            max = Math.max(max, num);
            sum += (num + max);
            conver[i++] = sum;
        }
        return conver;
    }
}
