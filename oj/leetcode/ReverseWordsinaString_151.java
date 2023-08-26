package oj.leetcode;

import java.util.StringJoiner;

public class ReverseWordsinaString_151 {
    public String reverseWords(String s) {
        StringBuilder reverseString = new StringBuilder();
        String words [] = s.split(" ");
        for (int i = words.length-1; i >= 0; i--)
        {
            if (!words[i].isEmpty()){
                reverseString.append(words[i]);
                reverseString.append(" ");
            }
        }
        return reverseString.toString().trim();
    }
}
