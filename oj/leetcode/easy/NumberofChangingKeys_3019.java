package oj.leetcode.easy;

public class NumberofChangingKeys_3019 {
    public int countKeyChanges(String s) {
        int count = 0;
        s = s.toLowerCase();
        for(int i = 1; i < s.length(); i++)
        {
            if(s.charAt(i) != s.charAt(i-1))
                count++;
        }
        return count;
    }
}
