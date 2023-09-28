package oj.leetcode.easy;

import java.util.HashMap;

public class DecryptStringfromAlphabettoIntegerMapping_1309 {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < 26; i++)
        {
            map.put(i+1, (char)(i+97));
        }
        int index = s.length()-1;
        while (index >= 0)
        {
            if (s.charAt(index) == '#'){
                sb.append(map.get(Integer.parseInt(s.substring(index-2, index))));
                index -= 3;
            }
            else{
                sb.append(map.get(Integer.parseInt(s.charAt(index)+"")));
                index--;
            }
        }
        return sb.reverse().toString();
    }
}
