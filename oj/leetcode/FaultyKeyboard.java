package oj.leetcode;

import java.util.Stack;

public class FaultyKeyboard {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray()){
            if (!c.equals('i')){
                sb.append(c);
            }
            else {
                sb.reverse();
            }
        }
        return sb.toString();
    }
}
