package oj.leetcode;

public class AccountBalanceAfterRoundedPurchase {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int roundedAmount  = purchaseAmount % 10 > 4 ? (purchaseAmount / 10 + 1 ) * 10 : (purchaseAmount / 10 ) * 10;


    }
}
