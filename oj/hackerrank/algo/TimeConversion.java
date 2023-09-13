package oj.hackerrank.algo;

public class TimeConversion {
    public  String timeConversion(String s) {
        // Write your code here
        int hour = Integer.parseInt(s.substring(0,2));
        hour = (s.substring(8).equals("PM")) ? 12 + (hour % 12) : hour % 12;

        return ((hour < 10) ? "0" +hour : hour)+s.substring(2,8);
    }
}
