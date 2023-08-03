package oj.leetcode;

import java.util.*;

public class SplitWordsBySeparator {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> wordList = new ArrayList<>();
        words.forEach(word -> {
            String [] splittedWord = word.split("[" +separator+ "]+");
            for (String sw : splittedWord) {
                if (sw.length() > 0){
                    wordList.add(sw);
                }
            }

        });
        return wordList;
    }
}
