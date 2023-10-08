package oj.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;

public class MakeTwoArraysEqualbyReversingSubarrays_1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target,arr);
    }

}
