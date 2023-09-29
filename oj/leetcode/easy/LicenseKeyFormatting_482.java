package oj.leetcode.easy;

public class LicenseKeyFormatting_482 {
    public String licenseKeyFormatting(String s, int k) {
        s = s.replace("-", "").toUpperCase();
        int i = s.length();
        StringBuilder sb = new StringBuilder();
        while (i >= 0)
        {
            int start = (i - k) < 0 ? 0 : (i - k);
            sb.insert(0, s.substring(start, i));
            i -= k;
            if (i > 0)
                sb.insert(0, "-");
        }
        return sb.toString();
    }
}
