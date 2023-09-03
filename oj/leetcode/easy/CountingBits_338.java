package oj.leetcode.easy;

import java.util.*;

public class CountingBits_338 {

    public int[] countBits(int n) {
        int countArr[] = new int[n+1];
        countArr[0] = 0;
        Queue<String> queue = new LinkedList<>();
        int count, length = countArr.length - 1;
        queue.add("1");
        while (n-- > 0)
        {
            count = 0;
            String head = queue.poll();
            for (char c : head.toCharArray())
            {
                if (c == '1')   count++;
            }
            countArr[length - n] = count;
            queue.add(head + "0");
            queue.add(head + "1");
        }
        return countArr;
    }
}
