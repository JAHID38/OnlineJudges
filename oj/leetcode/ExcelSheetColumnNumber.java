package oj.leetcode;
public class ExcelSheetColumnNumber {
    public long titleToNumber(String columnTitle) {
        int power = columnTitle.length() - 1;
        int base = 26;
        long sum = 0;
        for (char c : columnTitle.toCharArray()){
            sum += (c-64) * Math.pow(base, power--);
        }
        return sum;
    }
}
