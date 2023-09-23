package oj.leetcode.easy;

public class IsSubsequence_392 {
    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        char [] cs = s.toCharArray();
        char [] ct = t.toCharArray();

        if (cs.length > 0 && ct.length > 0)
        {
            for (int i = 0; i < ct.length; i++)
            {
                if (cs[sIndex] == ct[i]){sIndex++;}
                if (sIndex == cs.length)    break;
            }

        }

        return sIndex == cs.length;
    }
}
