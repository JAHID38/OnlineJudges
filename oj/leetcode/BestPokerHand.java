package oj.leetcode;

import java.util.HashMap;

public class BestPokerHand {
    public String bestHand(int[] ranks, char[] suits) {
        HashMap<Character, Integer> suitHash = new HashMap<>();
        HashMap<Integer, Integer> rankHash = new HashMap<>();
        int max = -1;
        for (int i = 0; i < ranks.length; i++){
            suitHash.put(suits[i], suitHash.getOrDefault(suits[i], 0)+1);
            rankHash.put(ranks[i], rankHash.getOrDefault(ranks[i], 0)+1);
        }
        if (suitHash.get(suits[0]) == 5){
            return "Flush";
        }
        for (int i : rankHash.values()){
            max = Math.max(max, i);
        }
        if (max > 2)    return "Three of a Kind";
        else if (max == 2)  return "Pair";
        return "High Card";
    }
}
