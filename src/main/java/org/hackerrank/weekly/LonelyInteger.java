package org.hackerrank.weekly;

import java.util.ArrayList;
import java.util.List;

public class LonelyInteger {

    public static int lonelyinteger(List<Integer> elements) {
        Integer uniqueElement = 0;

        for (int i = 0; i < elements.size(); i++) {
            Integer element = elements.get(i);
            List<Integer> copy = new ArrayList<>(elements);
            boolean isUnique = copy.stream().filter(e -> e.equals(element)).count() == 1;

            if(isUnique){
                uniqueElement = element;
                break;
            }
        }

        return uniqueElement;
    }

}
