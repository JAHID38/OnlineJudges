package oj.lc.contest;

public class FurthestPointFromOrigin_8015 {
    public int furthestDistanceFromOrigin(String moves) {
        int _count = 0, lCount = 0, rCount = 0;
        char[] charArr = moves.toCharArray();
        for (int i = 0; i < charArr.length; i++)
        {
            if (charArr[i] == 'R'){
                rCount++;
            }
            else if (charArr[i] == 'L'){
                lCount++;
            }
            else {
                _count++;
            }
        }
        return Math.abs(rCount - lCount) + _count;
    }
}
