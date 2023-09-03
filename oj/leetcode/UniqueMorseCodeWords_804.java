package oj.leetcode;

import java.util.HashSet;

public class UniqueMorseCodeWords_804 {
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> uniqueMorse = new HashSet<>();
        StringBuilder concatMorse;
        String[] morseCode = new String[]
                {
                        ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
                };
        for (String word : words){
            concatMorse = new StringBuilder();
            for (char c : word.toCharArray()){
                concatMorse.append(morseCode[c-'a']);
            }
            uniqueMorse.add(concatMorse.toString());
        }
        return uniqueMorse.size();
    }
}
