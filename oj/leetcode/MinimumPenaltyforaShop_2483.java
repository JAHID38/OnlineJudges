package oj.leetcode;

public class MinimumPenaltyforaShop_2483 {
    public int bestClosingTime(String customers) {
        int penalty = 0, minPenalty = 0, minHour = -1;
        char [] customerArr = customers.toCharArray();
        for (int curr = 0; curr < customerArr.length; curr++)
        {
            penalty += customerArr[curr] == 'Y' ? 1 : -1;
            if (penalty > minPenalty)
            {
                minPenalty = penalty;
                minHour = curr;
            }
        }
        return minHour+1;
    }
}
