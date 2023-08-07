package oj.leetcode;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++){
                if (target == matrix[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
}
