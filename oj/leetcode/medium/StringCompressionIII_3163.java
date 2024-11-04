package oj.leetcode.medium;

public class StringCompressionIII_3163 {
    public String compressedString(String word) {
        int countSameChar = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++)
        {
            if (i < word.length()-1 && word.charAt(i) == word.charAt(i+1))
            {
                countSameChar++;
            }
            else
            {
                if (countSameChar > 0)
                {
                    sb.append(countSameChar);
                    sb.append(word.charAt(i));
                }


                countSameChar = 1;
            }
            if (countSameChar == 9 )
            {

                sb.append(countSameChar);
                sb.append(word.charAt(i));
                countSameChar = 0;
            }

        }
        return sb.toString();
    }
}
