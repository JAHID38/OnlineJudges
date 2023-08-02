package oj.leetcode;

import java.util.*;

class SmallestInfiniteSet {

    List<Integer> list = new ArrayList<>();
    public SmallestInfiniteSet() {
        for (int i = 1; i <= 1000; i++)
        {
            list.add(i);
        }
    }

    public int popSmallest() {
        return list.remove(0);
    }

    //4, 5, 6...
    //+2
    //2, 4, 5, 6...
    //+3
    //2, 3, 4, 5, 6
    public void addBack(int num) {
        for (int i = 0; i < num; i++)
        {
            if (list.get(i) > num){
                list.add(i, num);
            }
        }
    }
}

class WordFilter {
    List<String> wordList = new ArrayList<>();
    public WordFilter(String[] words) {
        Arrays.stream(words).forEach(word->wordList.add(word));
    }

    public int f(String pref, String suff) {
        int index = -1;
//        for (String word : wordList)
//        {
//            if (word.startsWith(pref) && word.endsWith(suff)) {
//                index = wordList.indexOf(word);
//            }
//        }

        for (int i = 0; i < wordList.size(); i++)
        {
            String word = wordList.get(i);
            if (word.startsWith(pref) && word.endsWith(suff))
            {
                index = i;
            }
        }

//        System.out.println(index);

        return index;
    }


}

class MinStack {

    Stack stack;
    public MinStack() {
        stack = new Stack();
    }

    public void push(int val) {
        stack.push(val);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return (int)stack.peek();
    }

    public int getMin() {
        return (int)Collections.min(stack);
    }
}

class Solution {
    public int percentageLetter(String s, char letter) {
        float totalf = s.length();
        float countf = 0;

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == letter)
            {
                countf++;
            }
        }

        float division = (countf/totalf);
        var pre_result = division*100;
        int result = (int)pre_result;

        return result;
    }

    public List<Integer> intersection(int[][] nums) {
        List<Integer> list = new ArrayList<>();
        int minArrSize = nums[0].length;
        for (int i = 0; i < nums.length; i++)
        {
            if (minArrSize > nums[i].length)
            {
                minArrSize = nums[i].length;
            }
        }
        System.out.println(minArrSize);


        return list;
    }

    public int countEven(int num) {
        int count = 0;

        while (num > 0)
        {
            if (digitSum(num) % 2 == 0)
            {
                count++;
            }
            num--;
        }
        System.out.println(count);

        return count;

    }
    private int digitSum (int num)
    {
        int sum = 0;
        while (num > 0)
        {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    public int countOperations(int num1, int num2) {

        int count = 0;
        while (num1 > 0 && num2 > 0)
        {
            if (num1 < num2)
            {
                num2 = num2 - num1;
            }
            else
            {
                num1 = num1 - num2;
            }
            count++;
        }

        System.out.println(count);
        return count;
    }

    public boolean isSameAfterReversals(int num) {

        return (reverseNumber(reverseNumber(num)) == num) ? true : false;
    }
    private int reverseNumber(int number)
    {
        int reverse = 0, remainder;
        while(number != 0)
        {
            remainder = number % 10;
            reverse = reverse*10 + remainder;
            number /= 10;
        }

        return reverse;
    }

    public long[] sumOfThree(long num) {
        long[] resultArr = new long[0];
        long quotient = -1;
        if (num % 3 == 0)
        {
            resultArr = new long[3];
            quotient = num /3;
            for (int i = 0; i < resultArr.length; i++)
            {
                resultArr[i] = quotient + i - 1;
            }
        }

        return resultArr;
    }

    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        return gcdOf2num(nums[0], nums[nums.length-1]);
    }

    private int gcdOf2num(int divisor, int dividend)
    {
        int remainder;
        while (divisor > 0)
        {
            remainder = dividend % divisor;
            dividend = divisor;
            divisor = remainder;
        }
        return dividend;
    }

    public int arraySign(int[] nums) {
        int count = 0;
        for (int val : nums)
        {
            if (val == 0) return 0;
            if (val < 0) count++;
        }

        return (count % 2 == 0) ? 1 : -1;
    }

    public int maximum69Number (int num) {
        String nineSix = String.valueOf(num);
        String sixNine = "";
        boolean isDone = false;
        for (int ind = 0; ind < nineSix.length(); ind++)
        {
            if (nineSix.charAt(ind) == '6' && !isDone)
            {
                sixNine += '9';
                isDone = true;
                continue;
            }
            sixNine += nineSix.charAt(ind);
        }
        return Integer.parseInt(sixNine);
    }

    public int countKDifference(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i+1; j < nums.length; j++)
            {
                if (Math.abs(nums[i]-nums[j]) == k)
                {
                    count++;
                }
            }
        }


        return count;
    }

    public int countKDifferences(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            int val=nums[i]+k;
            if(hm.containsKey(val)){
                count+=hm.get(val);
            }
        }
        return count;
    }

    public int majorityElement(int[] nums) {

        int major = -1;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums)
        {
            //key -> i;
            //value -> frequency
            hashMap.put(i, hashMap.getOrDefault(i,0)+1);
        }

        return Collections.max(hashMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int single = 0;
        for (int i : nums)
        {
            hashMap.put(i, hashMap.getOrDefault(i, 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue().equals(1)) {
                single = entry.getKey();
            }
        }
        return single;

    }
    public int hammingWeight(int n)
    {
        int ans=0;
        for(int i=0;i<32;i++)
        {
            ans=ans+(n&1);
            n=n>>2;
        }
        return ans;
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sHash = new HashMap<>();
        Map<Character, Integer> tHash = new HashMap<>();

        for (char cs : s.toCharArray())
        {
            sHash.put(cs, sHash.getOrDefault(cs, 0)+1);
        }

        for (char ct : t.toCharArray())
        {
            tHash.put(ct, tHash.getOrDefault(ct, 0)+1);
        }

        return sHash.equals(tHash);
    }

    public int addDigits(int num) {
        if (num < 10)
            return num;

        return addDigits(sumDigits(num));
    }
    private int sumDigits(int num)
    {
        int sum = 0;
        while (num != 0)
        {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }

    public int missingNumber(int[] nums) {

        int missing = 0;
        Arrays.sort(nums);
        if (nums[0] != 0)
            return 0;
        for (int i = 1; i < nums.length-1; i++)
        {
            if(nums[i]+1 != nums[i+1])
            {
                missing = nums[i+1];
                break;
            }
        }
        return missing;
    }

    public boolean wordPattern(String pattern, String s) {
        boolean isMatch = true;
        Map<Character, String> map = new HashMap<>();
        String[] words = s.split(" ");
        int patternLength = pattern.length();
        if (patternLength != words.length)
        {
            return false;
        }

        for (int i = 0; i < patternLength; i++)
        {
            String word = map.getOrDefault(pattern.charAt(i), "");
            if (!word.isEmpty())
            {
                if (!word.equals(words[i]))
                {
                    isMatch = false;
                }
            }
            map.put(pattern.charAt(i), words[i]);
        }


        Set<String> setMap= new HashSet<>(map.values());
        if (map.values().size() != setMap.size())
        {
            isMatch = false;
        }
        return isMatch;
    }

    public String[] findRelativeRanks(int[] score) {
        int copied[] = score;

        String ranks[] = new String[score.length];
        int sortedArr []= Arrays.stream(score).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        for (int i = 0; i < copied.length; i++)
        {
            ranks[i] = rankMe(copied[i], sortedArr);
        }

        for (String val : ranks)
        {
            System.out.println(val);
        }
        return ranks;
    }
    private String rankMe (int num, int [] score)
    {
        String index = null;
        for (int i = 0; i < score.length; i++)
        {
            if (num == score[i])
            {
                switch (i)
                {
                    case 0:
                        index = "Gold Medal";
                        break;
                    case 1:
                        index = "Silver Medal";
                        break;
                    case 2:
                        index = "Bronze Medal";
                        break;
                    default:
                        index = i+1+"";
                        break;
                }
            }
        }
        return index;
    }

    public int calPoints(String[] ops) {

        Stack<Integer> stack = new Stack<>();
        for (String op : ops)
        {
            if (op.equals("C"))
            {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2*stack.peek());
            } else if (op.equals("+")) {
                stack.push(stack.peek()+stack.get(stack.size()-2));
            }else
            {
                stack.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        for (int i : stack)
        {
            sum += i;
        }
        return sum;
    }

    public int heightChecker(int[] heights) {
        int[] copied = Arrays.stream(heights).boxed()
                .mapToInt(Integer::intValue)
                .toArray();;
        int count = 0;

        Arrays.sort(heights);
        for (int i = 0; i < heights.length; i++)
        {
            if (copied[i]!= heights[i])
            {
                count++;
            }

        }
        return count;
    }

    public boolean uniqueOccurrences(int[] arr) {
        boolean isUnique = false;
        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int val : arr)
        {
            integerMap.put(val, integerMap.getOrDefault(val, 0)+1);
        }
        Set<Integer> integerSet = new HashSet<>(integerMap.values());

        if (integerMap.size() == integerSet.size())
        {
            isUnique = true;
        }
        return isUnique;
    }

    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (count == 3)
            {
                break;
            }
            if(isOdd(arr[i]))
            {
                count++;
            }
            else
            {
                count = 0;
            }
        }
        return (count < 3) ? false : true;
    }
    private boolean isOdd (int num)
    {
        return (num % 2 == 0) ? false : true;
    }

    public String reformatDate(String date) {
        List<String> month = new ArrayList<>
                (
                        Arrays.asList(
                                "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
                        )
                );
        StringBuilder sb = new StringBuilder();

        String[] extractDate = date.split(" ");
        int index = month.indexOf(extractDate[1]);
        String monthIndex = (index+1 < 10) ? "0"+(++index) : ""+(++index);
        String day = (extractDate[0].length() == 3) ? "0"+extractDate[0].substring(0,1) : extractDate[0].substring(0,2);

        sb.append(extractDate[2]+"-" +monthIndex+"-" +day);
        return sb.toString();
    }

    public boolean strongPasswordCheckerII(String password) {
        boolean isStrong = false;
        /*
        minLength: 8
         */

        if (password.length() < 8)
        {
            return false;
        }
        if (!isLower(password))
            return false;
        if (!isUpper(password))
            return false;
        if (!isDigit(password))
            return false;
        if (!isSpecialCharacter(password))
            return false;
        if (!isAdjacent(password))
            return false;

        return true;
    }
    private boolean isLower(String password)
    {
        /*
        a-z : 97-122
         */
        for (char val : password.toCharArray())
        {
            if (val > 96 && val < 123)
            {
                return true;
            }
        }
        return false;
    }
    private boolean isUpper(String password)
    {
        /*
        A-Z : 65-90
         */
        for (char val : password.toCharArray())
        {
            if (val > 64 && val < 91)
            {
                return true;
            }
        }
        return false;
    }
    private boolean isDigit(String password)
    {
        /*
        0-9 : 48-57
         */
        for (char val : password.toCharArray())
        {
            if (val > 47 && val < 58)
            {
                return true;
            }
        }
        return false;
    }
    private boolean isSpecialCharacter(String password)
    {
        String character = "!@#$%^&*()-+";
        List<Character> sp = new ArrayList<>();
        for (char c : character.toCharArray())
        {
            sp.add(c);
        }
            /*
            0-9 : 48-57
             */
        for (char val : password.toCharArray())
        {
            if(sp.contains(val))
                return true;

        }
        return false;
    }
    private boolean isAdjacent (String password)
    {
        for (int i = 0 ; i < password.length()-1; i++)
        {
            if (password.charAt(i) == password.charAt(i+1))
                return false;
        }
        return true;
    }

    public String capitalizeTitle(String title) {
        String text = "";
        String [] words = title.split(" ");
        for (String word  : words)
        {
            if (word.length() < 3)
            {
                text += word.toLowerCase() + " ";
            }
            else
            {
                String firstLtr = ""+word.charAt(0);
                text += firstLtr.toUpperCase() + word.substring(1).toLowerCase() +" ";
            }
        }


        return text.trim();
    }

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {

        return (convertLetter(firstWord) + convertLetter(secondWord) == convertLetter(targetWord)) ? true : false;
    }
    private int convertLetter(String word)
    {
        int length = word.length()-1;
        int sum = 0;
        for (int i = length; i >= 0; i--)
        {
            sum += (int)((word.charAt(i)-97) * Math.pow(10, (length-i)));
        }

        return sum;
    }

    public int smallestEqual(int[] nums) {
        int min = 0;



        return min;
    }

    public int findKthLargest(int[] nums, int k) {
        int reverse[] = Arrays.stream(nums).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        return reverse[--k];
    }

    public int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length-1; i++)
        {
            while (nums[i] > 0)
            {
                list.add(nums[i+1]);
                nums[i]--;
            }
            i++;
        }
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int[] pivotArray(int[] nums, int pivot) {

        int leftCount = 0;
        int rightCount = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i : nums)
        {
            if (i > pivot)
            {
                rightCount++;
            }
            else if (i < pivot){
                leftCount++;
            }
        }
        int leftArr[] = new int[leftCount];
        int rightArr[] = new int[rightCount];
        for (int i : nums)
        {
            if (i > pivot)
            {
                rightArr[rightIndex++] = i;
            }
            else if (i < pivot)
            {
                leftArr[leftIndex++] = i;
            }
        }
        int leftRight = leftCount+rightCount;
        int pivotInd = nums.length - leftRight;
        int resultArr[] = new int[nums.length];
        for (int i = 0; i < leftCount; i++)
        {
            resultArr[i] = leftArr[i];
        }
        for (int i = 0; i < pivotInd; i++)
        {
            resultArr[leftCount+i] = pivot;
        }
        for (int i = 0; i < rightCount; i++)
        {
            resultArr[i+leftCount+pivotInd] = rightArr[i];
        }
        return resultArr;
    }

    public int[] rearrangeArray(int[] nums) {

        int negatives[] = new int[nums.length/2];
        int positives[] = new int[nums.length/2];
        int n = 0, p = 0, index = 0;

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] < 0)
            {
                negatives[n++] = nums[i];
            }
            else
            {
                positives[p++] = nums[i];
            }
        }

        for (int i = 0; i < nums.length-1; i++)
        {
            nums[i] = positives[index];
            nums[++i] = negatives[index];
            index++;
        }
        return nums;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1Len = nums1.length;
        int mergeLen = num1Len + nums2.length;
        int merge[] = new int[mergeLen];
        for (int i = 0; i < num1Len; i++)
        {
            merge[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++)
        {
            merge[i+num1Len] = nums2[i];
        }
        Arrays.sort(merge);
        return (mergeLen % 2 == 0) ?
                (double)(merge[mergeLen/2]+merge[(mergeLen/2)-1])/2 : merge[(mergeLen-1)/2];
    }

    public boolean digitCount(String num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int val : num.toCharArray())
        {
            map.put((val-48), map.getOrDefault((val-48), 0)+1);
        }
        for (int val : num.toCharArray())
        {
            if ((val-48) != map.getOrDefault(i++, 0))
                return false;
        }
        return true;
    }

    public String toGoatLatin(String sentence) {
        String text = "";
        ArrayList<Character> vowels = new ArrayList<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        );
        String []words = sentence.split(" ");
        for  (String word : words)
        {
            vowels.get(word.charAt(0));

        }
        return text;
    }

    public void reverseString(char[] s) {
        char temp;
        int lastIndex = s.length-1;
        for (int i = 0; i < s.length/2; i++)
        {
            temp = s[i];
            s[i] = s[lastIndex-i];
            s[lastIndex-i] = temp;
        }

        for (char c : s)
            System.out.println(c);

    }

    public boolean canWinNim(int n) {
        return (n % 4 != 0);

//        return (n % 3 == 0) ?
    }


    public String countAndSay(int n) {
        String result = "";
        while (n != 0)
        {
            result = "1";
            countAndSay(n--);
        }

        return result;
    }

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int value = 0, index = 0;

        int[] arr = new int[queries.length];

        for (int row = 0; row < queries.length; row++)
        {
            value = queries[row][0];
            index = queries[row][1];

            nums[index] += value;

            arr[row] = sumEven(nums);
        }

        return arr;
    }
    private int sumEven(int[] arr)
    {
        int sum = 0;
        for (int num : arr)
        {
            if (num % 2 == 0)
            {
                sum += num;
            }
        }
        return sum;
    }

    public int countNegatives(int[][] grid) {
        int count = 0;

        for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[row].length; col++)
            {
                if (grid[row][col] < 0)
                    count++;
            }
        }

        return count;
    }

    public int smallestEvenMultiple(int n) {
        return (n % 2 == 0) ? n : n * 2;
    }

    public int maxProductDifference(int[] nums) {
        int n = nums.length-1;
        Arrays.sort(nums);
        return  nums[0]*nums[1] - nums[n]*nums[n-1];
    }

    public double[] convertTemperature(double celsius) {

        double tempKF[] = new double[2];
        double kelvin = celsius + 273.15;
        double fahrenheit = celsius * 1.80 + 32.00;

        tempKF[0] = kelvin;
        tempKF[1] = fahrenheit;
        return tempKF;
    }

    public int[] countPoints(int[][] points, int[][] queries) {
        int []counts = new int[queries.length];

        for (int queryRow = 0; queryRow < queries.length; queryRow++)
        {
            counts[queryRow] = pointsInsideCircle(queries[queryRow], points);
        }


        return counts;
    }
    private  int pointsInsideCircle(int[]circle, int[][]points)
    {
        int count =  0;
        int x = circle[0];
        int y = circle[1];
        int r = circle[2];

        double d;
        for (int row = 0; row < points.length; row++)
        {
            d = Math.sqrt(Math.pow(x - points[row][0], 2) + Math.pow(y - points[row][1], 2));
            if (d <= r)
            {
                count++;
            }
        }

        return count;
    }

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int counts[] = new int[points.length];

        for (int i = 0; i < points.length; i++)
        {
            counts[i] = pointsInsideRectangle(points[i][0], points[i][1], rectangles);
        }


        return counts;
    }
    private int pointsInsideRectangle(int x, int y, int[][]rectangles)
    {
        int count = rectangles.length;

        for (int i = 0; i < rectangles.length; i++)
        {
            if (x > rectangles[i][0] || y > rectangles[i][1])
                count--;
        }

        return count;
    }

    public int findCenter(int[][] edges) {
        return (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1])
                ?
                edges[0][0]
                :
                edges[0][1];
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for (var list:
                items) {
            if(ruleKey.equals("type"))
            {
                if (list.get(0).equals(ruleValue))
                    count++;
            }
            else if(ruleKey.equals("color"))
            {
                if (list.get(1).equals(ruleValue))
                    count++;
            }
            if(ruleKey.equals("name"))
            {
                if (list.get(2).equals(ruleValue))
                    count++;
            }
        }
        return count;
    }

    public int countAsterisks(String s) {
        int count = 0;

        String []group = s.split("[|]");
        for (int i = 0 ; i < group.length; i+=2)
        {
            for (int g = 0; g < group[i].length(); g++)
            {
                if (group[i].charAt(g) == '*')
                    count++;
            }
        }
        return  count;
    }

    public int maximumValue(String[] strs) {

        int lengthArr[] = new int[strs.length];
        int i = 0;
        boolean numberOnly = true;

        for (String item : strs)
        {
            for (int c : item.toCharArray())
            {
                if (c < 48 || c > 57)       //check if any letter found
                {
                    numberOnly = false;
                    lengthArr[i] = item.length();
                    break;
                }
                else
                {
                    numberOnly = true;
                }
            }

            if (numberOnly)
            {
                lengthArr[i] = Integer.parseInt(item);
                numberOnly = false;
            }
            i++;
        }

        Arrays.sort(lengthArr);

        return lengthArr[lengthArr.length - 1];
    }

    public int maxSubArray(int[] nums)
    {
        int r = 0; //inclusive
        int l = 1; //exclusive
        int sum = 0;
        int max = Integer.MIN_VALUE;
        while (r < l && l <= nums.length)
        {
            sum += nums[l - 1];
            max = sum > max ? sum : max;
            if (sum <= 0)
            {
                r = l;
                sum = 0;
            }
            l++;
        }
        return max;
    }

    public boolean isCircularSentence(String sentence) {

        boolean isCircular = true;
        String []wordsArr = sentence.split(" ");
        for (int i = 0; i < wordsArr.length-1; i++)
        {
            if (!wordsArr[i].endsWith(wordsArr[i+1].charAt(0)+""))
            {
                isCircular = false;
                break;
            }
        }

        if (isCircular)
        {
            if (!wordsArr[wordsArr.length-1].endsWith(wordsArr[0].charAt(0)+""))
                isCircular = false;
        }

        return  isCircular;
    }

    public String greatestLetter(String s) {

        String ans = "";
        char[] charArr = s.toCharArray();

        Arrays.sort(charArr);

        int len = charArr.length;
        int index = len-1;

        while (index > 0)
        {
            for (int i = index-1; i >= 0; i--)
            {
                if (charArr[index] > 96)
                {
                    if ( charArr[i] < 91 && (char)(charArr[index] - 32) == charArr[i])
                    {
                        ans = charArr[i]+"".toUpperCase();
                        return ans;
                    }
                }
            }
            --index;
        }
        return ans;
    }

    public double calculateTax(int[][] brackets, int income) {
        double tax = 0.00000;
        int upper = 0;
        int lower = 0;
        int percent = 0;

        if (income == 0)
            return 0.00000;

//        income -= brackets[0][0];
//        tax +=  ((double)brackets[0][0] * brackets[0][1] / 100);

        for (int row = 0; row < brackets.length; row++)
        {
            lower = (row-1) < 0 ? lower : brackets[row-1][0];
            upper = brackets[row][0] - lower;
            percent = brackets[row][1];

            upper = (income < upper) ? income : upper;

            if (income > 0)
            {
                tax += ((double) upper * percent / 100);
                income -= upper;
            }

        }

        return tax;
    }

    public int similarPairs(String[] words) {
        int count = 0;
        HashMap<String,Integer> hm=new HashMap<>();

        for (String word : words)
        {
            HashSet<Character> charSet = new HashSet<>();

            for (char letter : word.toCharArray())
            {
                charSet.add(letter);
            }
            String newWord = "";

            for (var ch : charSet.toArray())
            {
                newWord += ch;
            }

            hm.put(newWord, hm.getOrDefault(newWord, 0)+1);

        }

        for (int i : hm.values())
        {
            if (i > 1) {
                count += i * (i-1)/2;
            }
        }

        return count;
    }

    public int countTime(String time) {
        int count = 1;
        int minuteCount = 1;

        String times[] = time.split(":");
        char []hour = times[0].toCharArray();
        char []min = times[1].toCharArray();

        if (times[0].contains("?"))
        {
            if (hour[0] == '?')
            {
                if (hour[1] == '?')
                {
                    count = 24;
                }
                else if (hour[1] > 51)
                {
                    count = 2;
                }
                else
                {
                    count = 3;
                }
            }
            else if (hour[0] == 50)
            {
                count = 4;
            }
            else if (hour[0] < 50)
            {
                count = 10;
            }
        }

        if (times[1].contains("?"))
        {
            //"07:?3"
            if (min[0] == '?')
            {
                if (min[1] == '?')
                {
                    minuteCount = 60;
                }
                else
                {
                    minuteCount = 6;
                }
            }
            else if (min[0] > 47 && min[0] < 58)
            {
                minuteCount = 10;
            }
        }

        return count * minuteCount;

    }

    public String maximumTime(String time) {
        String []times = time.split(":");
        char hh[] = times[0].toCharArray();
        char mm[] = times[1].toCharArray();

        if (hh[0] == '?')
        {
            hh[0] = (hh[1] > 51 && hh[1] < 58) ? '1' : '2';
        }
        if (hh[1] == '?')
        {
            //0?:
            //1?:
            //2?:
            //??:
            hh[1] = (hh[0] == 50) ? '3' : '9';
        }
        if (mm[0] == '?')
        {
            mm[0] = '5';
        }
        if (mm[1] == '?')
        {
            mm[1] = '9';
        }

        return new String(hh)+":"+new String(mm);
    }

    public String[] sortPeople(String[] names, int[] heights) {
        int index = 0;
        String []people = new String[names.length];

        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < heights.length; i++)
        {
            map.put(heights[i], names[i]);
        }

        SortedSet<Integer> keySet = new TreeSet<>(map.keySet()).descendingSet();

        for (var key : keySet)
        {
            people[index] = map.get(key);
            ++index;
        }

        return people;
    }

    public int[] frequencySort(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
        {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        System.out.println(map);

        int []tmp = new int[map.size()];
        int index = 0;
        Arrays.sort(map.values().toArray(new Integer[map.values().size()]));
        for (int i : map.values())
        {
            tmp[index] = i;
            index++;
        }

        Arrays.sort(tmp);
        for (int i : tmp)
        {
            System.out.println(i);
        }


        return  null;
    }

    public String removeStars(String s) {

        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++)
        {
            char c = arr[i];

            if (c != '*')
                stack.push(c);
            else {
                stack.pop();
            }

        }
        String ans = "";
        for (char c : stack)
        {
            ans += c;
        }

        return ans;
    }

    public char repeatedCharacter(String s) {

        char []chars = s.toCharArray();
        char ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars)
        {
            map.put(c, map.getOrDefault(c, 0)+1);
            if (map.get(c) == 2)
            {
                ans = c;
                break;
            }
        }

        return ans;
    }
    public String decodeMessage(String key, String message) {

        HashMap<Character, Character> map = new HashMap<>();

        char value = 97;
        for (char c : key.replace(" ", "").toCharArray())
        {
            if (map.get(c) == null)
            {
                map.put(c, value++);
            }
        }

        char []msgArr = message.toCharArray();
        int index = 0;
        for (char c : message.toCharArray())
        {
            msgArr[index++] = map.getOrDefault(c, ' ');
        }


        return new String(msgArr);
    }

    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> ransomnoteMap = new HashMap<>();
        HashMap<Character, Integer> magazineMap = new HashMap<>();

        for (char ch : ransomNote.toCharArray())
        {
            ransomnoteMap.put(ch, ransomnoteMap.getOrDefault(ch, 0)+1);
        }

        for (char ch : magazine.toCharArray())
        {
            magazineMap.put(ch, magazineMap.getOrDefault(ch, 0)+1);
        }

        System.out.println(ransomnoteMap);
        System.out.println(magazineMap);

        for (char ch : ransomnoteMap.keySet()){
            if (magazineMap.get(ch) == null)
                return false;
            if (ransomnoteMap.get(ch) > magazineMap.get(ch))
                return false;
        }
        return true;
    }

    public String largestWordCount(String[] messages, String[] senders) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < messages.length; i++)
        {
            int wordCount = messages[i].split(" ").length;
            int previous = map.getOrDefault(senders[i], 0);

            map.put(senders[i], wordCount + previous);
        }

        SortedSet<Integer> sortedValues = new TreeSet<>(map.values()).descendingSet();
        int max = sortedValues.first();

        ArrayList<String> highestSender = new ArrayList<>();

        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getValue() == max) {
                highestSender.add(entry.getKey());
            }
        }

        return new TreeSet<>(highestSender).descendingSet().first();
    }

    public String[] divideString(String s, int k, char fill) {

        char sArr[] = s.toCharArray();
        int length = (sArr.length % k == 0) ? sArr.length/k : sArr.length/k + 1;
        int count = 0;
        String word = "";
        String[]ans = new String[length];

        for (int i = 0; i < sArr.length; i++)
        {
            if (count++ < k)
            {
                word += sArr[i];
            }
            if (count == k)
            {
                count = 0;
                ans[i/k] = word;
                word = "";
            }
        }

        if (count > 0 && count < k)
        {
            while (!(count == k))
            {
                word += fill;
                count++;
            }
            ans[length-1] = word;
        }

        return ans;
    }


    public boolean detectCapitalUse(String word) {

        String comparedWord = word;

        if (comparedWord.toUpperCase().equals(word))
            return true;
        else if (comparedWord.toLowerCase().equals(word)) {
            return true;
        }
        else
        {
            for (int i = 1; i < word.length(); i++)
            {
                if (word.charAt(i) < 91)
                {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean checkString(String s) {
        int bFirstIndex = s.indexOf('b');
        return (bFirstIndex == -1) ? true : !(s.substring(bFirstIndex).contains('a'+""));
    }

    public boolean checkAlmostEquivalent(String word1, String word2) {
        HashMap<Character, Integer> wordMap = new HashMap<>();

        for (char ch : word1.toCharArray())
        {
            wordMap.put(ch, wordMap.getOrDefault(ch, 0)+1 );
        }

        for (char ch : word2.toCharArray())
        {
            if (!word1.contains(""+ch))
            {
                wordMap.put(ch, wordMap.getOrDefault(ch, 0)+1 );
            }
            else
            {
                wordMap.put(ch, wordMap.get(ch)-1);
            }
        }

        for (int i : wordMap.values())
        {
            if (Math.abs(i) > 3)
                return false;
        }



        return true;
    }

    public boolean areNumbersAscending(String s) {

        String splitted[] = s.split(" ");
        List<Integer> numberArr = new ArrayList<>();

        for (String value : splitted)
        {
            String number = "";
            for (char ch : value.toCharArray())
            {
                if (Character.isDigit(ch))
                {
                    number += ch;
                }
            }
            if (!number.isEmpty())
            {
                numberArr.add(Integer.parseInt(number));
            }
        }

        for (int i = 0; i < numberArr.size()-1; i++)
        {
            if (numberArr.get(i) >= numberArr.get(i+1))
                return false;
        }

        return true;
    }

    public int countWords(String[] words1, String[] words2) {

        int count = 0;
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (String s : words1)
        {
            map1.put( s, map1.getOrDefault(s, 0)+1 );
        }

        for (String s : words2)
        {
            map2.put( s, map2.getOrDefault(s, 0)+1 );
        }

        for (String key : map1.keySet())
        {
            if (map2.getOrDefault(key, 0) == 1 && map1.get(key) == 1)
                count++;
        }


        System.out.println(map1);
        System.out.println(map2);
        System.out.println(count);

        return count;
    }

    public String[] uncommonFromSentences(String s1, String s2) {

        List<String> list = new ArrayList<>();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (String word : s1.split(" "))
        {
            map1.put(word, map1.getOrDefault(word, 0)+1);
        }

        for (String word : s2.split(" "))
        {
            map2.put(word, map2.getOrDefault(word, 0)+1);
        }

        for (String key : map1.keySet())
        {
            if (map1.get(key) == 1 && map2.get(key) == null)
            {
                list.add(key);
            }
        }


        for (String key : map2.keySet())
        {
            if (map2.get(key) == 1 && map1.get(key) == null)
            {
                list.add(key);
            }
        }

        String []ans = new String[list.size()];
        list.toArray(ans);

        return ans;
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        for (int i : nums1)
        {
            set1.add(i);
        }

        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums2)
        {
            set2.add(i);
        }

        List<Integer> list = new ArrayList<>();

        for (int i : set1)
        {
            if (set2.contains(i))
            {
                list.add(i);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i : nums1)
        {
            map1.put(i, map1.getOrDefault(i, 0)+1);
        }

        for (int i : nums2)
        {
            map2.put(i, map2.getOrDefault(i, 0)+1);
        }

        List<Integer> list = new ArrayList<>();

        for (int key : map1.keySet())
        {
            if (map2.get(key) != null)
            {
                int i = Math.min(map1.get(key), map2.get(key));
                for (int c = 0; c < i; c++)
                {
                    list.add(key);
                }
            }
        }

        int ans[] = new int[list.size()];
        for (int i = 0 ; i < ans.length; i++)
        {
            ans[i] = list.get(i);
        }

        return ans;
    }

    public int countDigits(int num) {

        int copiedNum = num;
        int remainder = 0;
        int count = 0;
        while (num > 0)
        {
            remainder = num % 10;
            num /= 10;
            if (copiedNum % remainder == 0)
                count++;
        }

        return count;
    }

    public int commonFactors(int a, int b) {

        int count = 0;
        int max = (a > b) ? a : b;
        for (int i = 1; i <= max/2; i++)
        {
            if (a % i == 0 && b % i == 0)
                count++;
        }
        return a == b ? count+1 : count;
    }
    public int hardestWorker(int n, int[][] logs) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(logs[0][0], logs[0][1]);

        for (int i = 1; i < logs.length; i++)
        {
            map.put(logs[i][0], Math.max(map.getOrDefault(logs[i][0], 0), logs[i][1] - logs[i-1][1])  );
        }

        int maxNum = -1;

        for (int value : map.values())
        {
            maxNum = Math.max(value, maxNum);
        }

        int smallestId = Integer.MAX_VALUE;

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() == maxNum) {
                smallestId = Math.min(smallestId, entry.getKey());
            }
        }

        return smallestId;
    }

    public String thousandSeparator(int n) {

        String tmp = String.valueOf(n);
        String ans = "";
        for ( int i = 0 ; i  < tmp.length(); ++i)
        {
            ans += ((tmp.length() - (i+1)) % 3 == 0 && i != tmp.length()-1) ?
                    tmp.charAt(i)+"." : tmp.charAt(i)+"";
        }
        return ans;
    }

    public int searchInsert(int[] nums, int target) {

        if (nums.length == 1)
        {
            return (target >  nums[0]) ? 1 : 0;
        }
        if (nums.length == 2 && target > nums[1])
            return 2;
        int index = 0;
        int lower = 0;
        int upper = nums.length - 1;

        while (lower < upper) {
            int pivot = (upper + lower) / 2;

            if (target == nums[pivot]) {
                index = pivot;
                break;
            }

            if (pivot == nums.length-1)
            {
                index = nums.length;
                break;
            }

            if (pivot == 0)
            {
                if (target < nums[lower])
                {
                    index = 0;
                    break;
                }
                index = upper;
                break;
            }

            if (lower == pivot){
                if (target > nums[upper])
                {
                    index = nums.length;
                    break;
                }
                index = lower+1;
                break;
            }

            if (upper == pivot)
            {

                if (target < nums[lower])
                {
                    index = 0;
                    break;
                }
                index = upper-1;
                break;
            }

            if (nums[pivot] < target) {
                lower = pivot;
            } else if (nums[pivot] > target) {
                upper = pivot;
            }
        }

        System.out.println(target +" is at : " +index);
        return index;
    }

    public int maximumCount(int[] nums) {

        int countPos = 0, countNeg = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] < 0){
                countNeg++;
            }
            else {
                countPos++;
            }
        }
        return countNeg > countPos ? countNeg : countPos;
    }

    public int findMaxK(int[] nums) {
        int defineMin = 1001;
        int defineMax = -1001;

        System.out.println(maxMin(nums, defineMax, defineMin));
        return 0;
    }

    private int maxMin(int[] nums, int max, int min)
    {
        int defineMin = min;
        int defineMax = max;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] <= defineMin)
            {
                defineMin = nums[i];
            }
            else if (nums[i] >= defineMax)
            {
                defineMax = nums[i];
            }
        }

        if (Math.abs(defineMin) == defineMax && defineMin < 0)
            return defineMax;
        maxMin(nums, defineMin *= -1, defineMax *= -1);
        return -1;
    }

    public int differenceOfSum(int[] nums) {
        int numSum = 0, digitSum = 0;

        for (int num : nums)
        {
            if (num > 9)
            {
                while (num > 0)
                {
                    digitSum += (num % 10);
                    num /= 10;
                    System.out.println(digitSum);
                }
            }
            else
            {
                digitSum += num;
            }
            numSum += num;
        }
        return Math.abs(numSum - digitSum);
    }

    public String categorizeBox(int length, int width, int height, int mass) {

        boolean isHeavy = mass > 99 ? true : false;
        boolean isBulky = Math.max(Math.max(length, width), height) >= 10E4 ?
                true : (length * width * height) >= 10E9 ? true : false;

        if (isBulky && isHeavy) return "Both";
        else if (isBulky && !isHeavy) return "Bulky";
        else if (!isBulky && isHeavy) return "Heavy";
        return "Neither";
    }

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
        {
            if (i % 15 == 0){
                list.add("FizzBuzz");
            }
            else if (i % 3 == 0){
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            }
            else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
    public int averageValue(int[] nums) {
        int count = 0, sum = 0;
        for (int num : nums){
            if (num % 6 == 0){
                count++;
                sum += num;
            }
        }
        return count == 0 ? 0 : (int)Math.floor(sum/count);
    }
//    public int singleNumber(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums){
//            map.put(num, map.getOrDefault(map, 0)+1);
//        }
//
//        int single = 0;
//        for (Map.Entry<Integer, Integer> i : map.entrySet())
//        {
//            if (i.getValue() == 1)
//                single = i.getKey();
//        }
//        return single;
//    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length)
            return new int[0][0];
        int arr2D[][] = new int[m][n];
        int i = 0;

        for (int row = 0; row < m; row++){
            for (int col = 0; col < n; col++){
                arr2D[row][col] = original[i++];
            }
        }
        return arr2D;
    }
    public int sumOfUnique(int[] nums) {
        int sumUnique = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for (int i : nums)
        {
            if (map.get(i) == 1){
                sumUnique += i;
            }
        }

        return sumUnique;
    }
    public int repeatedNTimes(int[] nums) {
        int times = nums.length/2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
            if (map.get(num) == times){
                times = num;    break;
            }
        }
        return times;
    }

    public int getCommon(int[] nums1, int[] nums2) {
        int min = -1;
        int j = 0;
        for (int i = 0; i < nums1.length; i++){
            if (nums1[i] == nums2[j]){
                return nums1[i];
            }
            if (nums1[i] < nums2[j]){
                continue;
            }
            else {
                j++;
            }
        }
        return min;
    }

    public String largestGoodInteger(String num) {
        String ans = "";
        int max = -1;
        Map<Character, Integer> map = new HashMap<>();
        char[] charArr = num.toCharArray();
        for (int i = 0; i < charArr.length-2; i++){
            if (charArr[i] == charArr[i+1] && charArr[i+1] == charArr[i+2]){
                map.put(charArr[i], map.getOrDefault(charArr[i], 0)+3);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if (entry.getValue() > 3){
                max = Math.max(max, entry.getKey());
            }
        }

        if (max > -1){
            for (int i = 0; i < 3; i++){
                ans += (char)max;
            }
        }


        return num.contains(ans) ? ans : "";
    }

    public int countElements(int[] nums) {
        int start = 0, end = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++){
            if (nums[i+1] > nums[i]){
                start = i;
                break;
            }
        }

        for (int i = nums.length-1; i > 0; i++){
            if (nums[i] > nums[i-1]){
                end = nums[i];
                break;
            }
        }
        return end-start;
    }

    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        boolean isTrue = true;
        int b = map.get(s.charAt(0));

        for (char key : map.keySet()){
            if(map.get(key) != b){
                isTrue = false;
                break;
            }
        }
        return isTrue;
    }

    public int findJudge(int n, int[][] trust) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < trust.length; i++) {
            set.add(trust[i][0]);
            map.put(trust[i][1], map.getOrDefault(trust[i][1], 0) + 1);
        }

        int maxFreq = -1, expectedJudge = 0, count = 0;
        for (int i : map.values()){
            maxFreq = Math.max(i, maxFreq);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() == maxFreq){
                count++;
                expectedJudge = entry.getKey();
            }
        }
        if (count > 1)
            return -1;
        for (int i = 0; i < trust.length; i++){
            if (trust[i][0] == expectedJudge){
                return -1;
            }
        }
        if (n - set.size() > 1)
            return -1;
        return expectedJudge;
    }
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < items1.length; i++){
            map.put(items1[i][0], map.getOrDefault(items1[i][0], 0) +items1[i][1]);
        }
        for (int i = 0; i < items2.length; i++){
            map.put(items2[i][0], map.getOrDefault(items2[i][0], 0) +items2[i][1]);
        }

        List<List<Integer>> list = new ArrayList<>();

        for (var entry : map.entrySet())
        {
            ArrayList<Integer> l = new ArrayList<>();
            l.add(entry.getKey());
            l.add(entry.getValue());
            list.add(l);
        }

        return list;
    }
    public int alternateDigitSum(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        int sum = 0, i = 0;
        while (n > 0){
            arr.add(n % 10);
//            sum += (i++ % 2 == 0) ? remainder : -remainder;
            n /= 10;
        }
        for (int l = arr.size()-1; l >= 0; l--){
            sum += (i++ % 2 == 0) ? arr.get(l) : -arr.get(l);
        }
        return sum;
    }

    public int dominantIndex(int[] nums) {
        int max = -1, maxIndex = 0, secondMax = -1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
            if (nums[i] > secondMax && nums[i] < max)
            {
                secondMax = nums[i];
            }
        }
        System.out.println(secondMax);
        return (secondMax*2 < max) ? maxIndex : -1;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean shouldAdd = false;

        for (int num = left; num <= right; num++)
        {
            int i = num;
            while (i > 0){
                int rem = i % 10;
                if (rem == 0){
                    shouldAdd = false;
                    break;
                }
                if (num % rem != 0){
                    shouldAdd = false;
                    break;
                }
                shouldAdd = true;
                i /= 10;
            }
            if (shouldAdd){
                list.add(num);
                shouldAdd = false;
            }

        }
        return list;
    }

    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i <= num/2; i++)
        {
            if (num % i == 0)
            {
                sum += i;
            }
        }
        return sum == num;
    }
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.reverse().toString().equals(sb.toString());
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        int n = 1, i = 0;

        while (i < nums.length){
            if (n == nums[i]){
                n++;
            }
            else if (n > nums[i]){
                i++;
                continue;
            }
            else {
                list.add(n++);
                continue;
            }

            i++;
        }
        return list;
    }
    int guess(int num){
        return
                1240808008;
    }
    public int guessNumber(int n) {
        int low = 1, high = n;
        int myGuess = 0;
        while (low > 0){
//            myGuess = (high + low)/2;
            myGuess = low + (high-low)/2;

            int match = guess(myGuess);

            if (match == 0){
                return myGuess;
            }
            else if (match == -1){
                high = myGuess-1;
            }
            else {
                low = myGuess+1;
            }
        }

        return 0;

    }
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums){
            set.add(i);
            int reverse = 0;
            while (i > 0){
                reverse = reverse * 10 + (i % 10);
                i /= 10;
            }
            set.add(reverse);
        }
        return set.size();
    }

    public int tribonacci(int n) {
        if (n < 2) return 1;
        int first = 0, second = 1, third = 1, sum = 0;
        while(n-2 > 0){
            sum = first + second + third;
            first = second;
            second = third;
            third = sum;
            n--;
        }

        return sum;
    }

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        HashSet<Double> set = new HashSet<>();
        int i = 0, j = nums.length-1;
        while (i < j){
            set.add((double)(nums[i++] + nums[j--])/2);
        }
        return set.size();
    }

    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < word1.length() && j < word2.length()){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));

            if (i < word1.length()){
                i++;
            }
            if (j < word2.length()){
                j++;
            }
        }
        return sb.toString();
    }
    public boolean squareIsWhite(String coordinates) {

        return        (coordinates.charAt(0) % 2 == 0) ? (coordinates.charAt(1) % 2 == 0) ? false : true : (coordinates.charAt(1) % 2 == 0) ? true : false;
    }

    public int pivotInteger(int n) {
        if (n == 1) return 1;
        int i = 1, j = n, sumLeft = 0, sumRight = 0;
        while (i != j){
            sumLeft += i++;

            if (sumLeft == sumRight && i == j){
                return i;
            }
            if (sumLeft > sumRight){
                sumRight += j--;
            }
        }
        return -1;
    }

    public int[] sumZero(int n) {
        int arr[] = new int[n];
        int i = 0, num = n/2;

        while (num != 0){
            arr[i] = -1* (num);
            arr[i+1] = num--;
            i+=2;
        }

        return arr;
    }
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int sum = carry;
            if(i >= 0){
                sum += a.charAt(i) - '0';
                i--;
            }
            if(j >= 0){
                sum += b.charAt(j) - '0';
                j--;
            }
            carry = sum > 1 ? 1 : 0;
            res.append(sum % 2);
        }
        if(carry != 0){
            res.append(carry);
        }
        return res.reverse().toString();    }

    public int[] plusOne(int[] digits) {
        if (digits[digits.length-1] < 9){
            ++digits[digits.length-1];
        }

        //89 + 1 =  90
        //99 + 1 = 100
        ArrayList<Integer> list = new ArrayList<>();
        int i = digits.length-1;

        while (i >= 0){

        }


        return digits;
    }

    public List<Integer> addToArrayForm(int[] num, int k) {
        int newNum = 0;
        for (int i = 0; i < num.length; i++){
            newNum = newNum*10 + num[i];
        }
        newNum += k;
        ArrayList<Integer> list = new ArrayList<>();

        while (newNum > 0)
        {
            list.add(newNum % 10);
            newNum /= 10;
        }
        Collections.reverse(list);
        return list;
    }
    public int[] leftRightDifference(int[] nums) {
        int answer[] = new int[nums.length];
        int i = 0, leftSum, rightSum;

        while (i < nums.length){
            leftSum = 0;
            rightSum = 0;
            for (int l = 0; l < i; l++){
                leftSum += nums[l];
            }
            for (int r = i+1; r < nums.length; r++){
                rightSum += nums[r];
            }
            answer[i++] = Math.abs(leftSum-rightSum);
        }
        return answer;
    }
    public int pivotIndex(int[] nums) {

        return -1;
    }
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] num : nums1){
            map.put(num[0], map.getOrDefault(num[0], 0)+num[1]);
        }
        for (int[] num : nums2){
            map.put(num[0], map.getOrDefault(num[0], 0)+num[1]);
        }
        return map.entrySet().stream()
                .map(e -> new int[]{e.getKey(), e.getValue()})
                .toArray(int[][]::new);
    }
    public long findTheArrayConcVal(int[] nums) {
        int i = 0;
        long sum = 0;
        while (i < nums.length/2){
            sum += Long.parseLong(nums[i]+""+nums[nums.length-1-i]);

            i++;
        }
        return ((nums.length & 1) == 0) ? sum : sum + nums[i+1];
    }
    public int compress(char[] chars) {
        String result = "";
        int count = 1;

        for (int i = 1; i < chars.length; i++){
            if (chars[i] == chars[i-1]){
                count++;
            }
            else {
                result += chars[i-1] + "";
                result += (count == 1) ? "" : count;
                count = 1;
            }
        }
        result += count == 1 ? chars[chars.length-1] + "" : chars[chars.length-1] +""+ count;

        for (int i = 0; i < result.length(); i++){
            chars[i] = result.charAt(i);
        }
        return result.length();
    }

    public int passThePillow(int n, int time) {
        boolean flag = false;
        int i = 1;
        while (time-- > 0){
            if (!flag){
                i++;
                if (i == n) flag = true;
            }
            else {
                i--;
                if (i == 1) flag = false;
            }
        }
        return (time > n) ? (time+1)/n : n-1;
    }
    public long coloredCells(int n) {
        return (long)(Math.pow(n, 2)+Math.pow(n-1, 2));
    }
    public int reverse(int x) {
        try{
            if (x > Integer.MAX_VALUE/2 || x < Integer.MIN_VALUE){
                return 0;
            }
            int n = Math.abs(x);
            int reverse = 0;
            while (n > 0){
                reverse = reverse * 10 + n%10;
                n/=10;
            }
            return x < 0 ? reverse*-1 : reverse;
        }
        catch (Exception ex){
            return 0;
        }
    }
}

public class LeetcodeProblem {
    public static void main (String args[]) {
        Solution sol = new Solution();


        System.out.println(Integer.MAX_VALUE/2);
        System.out.println(Integer.MIN_VALUE/2);
        System.out.println( -2147483412);

        System.out.println("reverse: " +sol.reverse(-2142));
//        sol.passThePillow(4, 15);
        int arr1D[] = {
                5,14,13,8,12

        };

        int one[][] = {
                {9,3},
                {1,2},
                {2,3},
                {4,5}
        };
        int two[][] = {
                {1,4},
                {3,2},
                {4,1}
        };



        sol.areOccurrencesEqual("mmmccmcccccmcccccmmmcmccmmccccmmmcmmcmcmcmcmmmmmmmmmcccmmcmmmcmmcmcmcmmmcmmmcmmccccmcmccmmcmccmmmcmmccccmcmmccmcmmcccmmcmmcmmcmccmmccmcmmcmmccmmccmcccmmcccmmcccccmcmmmmcmccmmmmmmcmmccmccmmcccccccccmcccmmmccmmccccmmcmcmcmcmmcmmcmcmcmccccmmcccmmmccmmcmmmcmmmcmccccmcmcccmmccmm"
        );
        sol.findMaxK(arr1D);
//        String word1 = "1 box has 3 blue 4 red 6 green and 12 yellow marbles", word2 = "cdecdhhfgdieiifhhifffcgddeehgbciceggedbdggbigiieidgcceccgfhiecdefdhighbfdcdbgcfddeebbgibcihe";

        String s1 = "apple apple", s2 = "banana";

//        new WordFilter(str1D).f(word, ptn);

        int arr11D[] = {2, 4};
        int arr2D[][] = {
                {2,2},
                {1,3},
                {1,3},
                {1,3},

//                {0,10},
//                {1,20},
//                {12,25}
        };
        int arr2D1[][] = {
                {7,1},
                {2,2},
                {1,4}
                //                {0,10},
                //                {1,20},
                //                {12,25}
        };

        sol.mergeSimilarItems(arr2D, arr2D1);
        char charArr[] = {'h', 'e', 'l', 'l', 'o'};

    }
}
