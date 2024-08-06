package org.hackerrank.weekly;

import java.text.DecimalFormat;
import java.util.List;

public class PlusMinus {

    public static void plusMinus(List<Integer> arr) {
        int negatives=0, positives=0, zeros=0, total = arr.size();
        DecimalFormat df = new DecimalFormat("0.000000");

        for(Integer element: arr){
            if(element < 0) negatives++;
            else if(element > 0) positives++;
            else zeros++;
        }

        System.out.println(df.format(((double) positives)/((double) total)));
        System.out.println(df.format(((double) negatives)/((double) total)));
        System.out.println(df.format(((double) zeros)/((double) total)));
    }

}