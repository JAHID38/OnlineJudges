package oj.leetcode.medium;

public class MinimumNumberOfChangesToMakeBinaryStringBeautiful_2914 {
    public int minChanges(String s) {
        int diffCount = 0;
        for (int i = 0; i < s.length()-1; i+=2)
        {
            if (s.charAt(i) != s.charAt(i+1))
            {
                diffCount++;
            }
        }
        return diffCount;
    }
}
