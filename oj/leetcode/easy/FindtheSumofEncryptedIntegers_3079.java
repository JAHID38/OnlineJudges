package oj.leetcode.easy;

public class FindtheSumofEncryptedIntegers_3079 {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int num : nums)
        {
            sum += encryptedNumber(num);
        }
        return sum;
    }
    private int encryptedNumber(int num)
    {
        int maxDigit = -1;
        int digitCount = 0;
        while (num > 0)
        {
            digitCount++;
            maxDigit = Math.max(maxDigit, (num % 10));
            num /= 10;
        }
        int number = maxDigit;
        for (int i = 1; i < digitCount; i++)
        {
            number = number*10 + maxDigit;
        }
        return number;
    }
}
