package oj.leetcode.easy;

public class HarshadNumber_3099 {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int number = x;
        int sum = 0;
        while (x > 0)
        {
            sum += (x%10);
            x /= 10;
        }
        return number % sum == 0 ? sum : -1;
    }
}
