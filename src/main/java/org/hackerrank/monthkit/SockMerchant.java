package org.hackerrank.monthkit;

import java.util.ArrayList;
import java.util.List;

public class SockMerchant {

    public static int sockMerchant(int n, List<Integer> arr) {
        List<Integer> indexesPaired = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (Integer j = i+1; j < arr.size(); j++) {
                if(arr.get(i).equals(arr.get(j))){
                    boolean indexPaired = false;
                    for(Integer index: indexesPaired) indexPaired = index.equals(j) || index.equals(i);

                    if(!indexPaired && arr.get(i).equals(arr.get(j))){
                        indexesPaired.add(i);
                        indexesPaired.add(j);
                        count++;
                        break;
                    }
                }
            }
        }

        return count;
    }

}
