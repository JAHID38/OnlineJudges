package oj.hackerrank.algo;
import java.util.*;

public class BirthdayCakeCandles {
    public int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        int freqArr[] = new int[candles.size()+1];
        int max = -1, maxIdx = 1;
        for (int i = 0; i < candles.size(); i++)
        {
            if (candles.get(i) > max)
            {
                maxIdx = 1;
                max = candles.get(i);
                freqArr[maxIdx] = max;
            }
            else if (candles.get(i) == max)
            {
                freqArr[++maxIdx] = max;
            }
        }
        for (int i = freqArr.length-1; i > 0; i--)
        {
            if (max == freqArr[i])  return i;
        }
        return 0;
    }
}
