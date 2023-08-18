package oj.leetcode;

public class RowWithMaximumOnes {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int countOne, rowIndex = 0, maxCount = -1, minVal = 101;
        int [] indexCount = new int[2];
        for (int row[] : mat){
            countOne = 0;
            for (int col : row){
                if (col == 1){
                    countOne++;
                }
            }
            if (countOne > maxCount){
                minVal = (minVal == rowIndex) ? Math.min(minVal, rowIndex) : rowIndex;
                maxCount = countOne;
                indexCount[1] = maxCount;
                indexCount[0] = minVal;
            }
            rowIndex++;
        }
        return indexCount;
    }
}
