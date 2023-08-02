package oj.leetcode;

public class NumberOfEmployeesWhoMetTarget {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int numberOfEmployees = hours.length;
        for (int hour : hours){
            if (hour < target){
                numberOfEmployees--;
            }
        }
        return numberOfEmployees;
    }
}
