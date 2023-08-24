package oj.leetcode;

import java.util.Arrays;

public class BuyTwoChocolates_2706 {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        return prices[0] + prices[1] > money ? money : money - Math.addExact(prices[0], prices[1]);
    }
}
