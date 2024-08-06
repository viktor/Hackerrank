package org.hackerrank.weekly;

import java.util.List;

public class DiagonalDifference {

    public static int diagonalDifference(List<List<Integer>> arr) {
        Integer leftToRight = 0, rightToLeft = 0;

        for (int i = 0; i < arr.size(); i++)
            leftToRight += arr.get(i).get(i);

        int j = arr.get(0).size()-1;
        for (int i = 0; i < arr.size(); i++)
                rightToLeft += arr.get(i).get(j--);

        return Math.abs(leftToRight - rightToLeft);
    }

}
