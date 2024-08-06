package org.hackerrank.weekly;

public class SuperDigit {

    public static int superDigit(String input, int k) {
        String pattern = input;
        for (int i = 0; i < k-1; i++)
            input = input.concat(pattern);

        return recursiveSum(input);
    }

    public static int recursiveSum(String input) {
        if(input.length()==1)
            return Integer.parseInt(input);

        int total = 0;
        for (char digit: input.toCharArray())
            total += Integer.parseInt(Character.toString(digit));
        input = String.valueOf(total);
        return recursiveSum(input);
    }


}
