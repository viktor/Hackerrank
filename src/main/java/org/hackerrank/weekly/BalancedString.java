package org.hackerrank.weekly;

public class BalancedString {

    public static String isBalanced(String s) {
        char[] opening = {'(','[','{'};
        char[] closing = {')',']','}'};
        StringBuilder str = new StringBuilder(s);

        for (int i=0; i < opening.length; i++){
            String open = String.valueOf(opening[i]);
            String close = String.valueOf(closing[i]);
            int openIndex = str.indexOf(open);

            while(openIndex >= 0){
                int closeIndex = str.indexOf(close);
                if(closeIndex == -1)
                    return "NO";

                str.delete(openIndex, closeIndex+1);
                openIndex = str.indexOf(open);
            }
        }

        if(str.length() > 0) return "NO";

        return "YES";
    }


}
