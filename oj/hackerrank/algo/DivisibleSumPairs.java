package oj.hackerrank.algo;
import java.util.*;

public class DivisibleSumPairs {
    public int divisibleSumPairs(int n, int k, List<Integer> ar) {
        // Write your code here
        int count = 0;
        for (int i = 0; i < ar.size(); i++)
        {
            for (int j = i+1; j < ar.size(); j++)
            {
                if ((ar.get(i) + ar.get(j)) % k == 0)   count++;
            }
        }
        return count;


    }
}
