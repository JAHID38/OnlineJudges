package oj.lc.contest;

public class CheckifStringsCanbeMadeEqualWithOperationsI_7021 {
    public static boolean canBeEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;
        char s1Char[] = s1.toCharArray();
        for (int i = 0; i < s1Char.length; i++)
        {
            if (s1Char[i] != s2.charAt(i))
            {
                for (int j = i + 2; j < s1Char.length; j++)
                {
                    char temp = s1Char[j];
                    s1Char[j] = s1Char[i];
                    s1Char[i] = temp;
                    if (new String(s1Char).equals(s2))
                    {
                        return true;
                    }
                    else {
                        j++;
                    }
                }
                if (new String(s1Char).equals(s2))
                {
                    return true;
                }
            }

        }
        return false;
    }
}
