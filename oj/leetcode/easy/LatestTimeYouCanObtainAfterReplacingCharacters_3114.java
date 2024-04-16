package oj.leetcode.easy;

public class LatestTimeYouCanObtainAfterReplacingCharacters_3114 {
    public String findLatestTime(String s) {
        StringBuilder sb = new StringBuilder();
        char[] digit = s.toCharArray();
        if (digit[0] == '?')
        {
            if (digit[1] == '0' || digit[1] == '1' || digit[1] == '?')
            {
                sb.append('1');
            }
            else
            {
                sb.append('0');
            }
        }
        else
            sb.append(digit[0]);
        if (digit[1] == '?')
        {
            sb.append(digit[0] == '0' ? '9' : '1');
        }
        else
            sb.append(digit[1]);
        sb.append(digit[2]);
        if (digit[3] == '?')
        {
            sb.append('5');
        }
        else
            sb.append(digit[3]);
        if (digit[4] == '?')
        {
            sb.append('9');
        }
        else
            sb.append(digit[4]);
        return sb.toString();
    }
}
