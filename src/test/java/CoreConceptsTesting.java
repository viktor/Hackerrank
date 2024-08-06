
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static org.hackerrank.Utils.print;

public class CoreConceptsTesting {

    @Test
    void test(){
        String[] strs = { "aBc", "FGH", "Cde", "BcD","cdE" };
        Collections.sort(Arrays.asList(strs), String::compareTo);
        System.out.println(Arrays.asList(strs));
    }

    @Test
    void test2(){
        String[] strs = { "aBc", "FGH", "Cde", "BcD","cdE" };
    }

    @Test
    void streams1(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        List<String> parsed = list.stream().map(String::valueOf).collect(Collectors.toList());
        System.out.println(parsed);
    }

    @Test
    void streams2(){
        int max1 = 0, max2 = 0;
        int k = 5;
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        OptionalInt index = IntStream.range(0, list.size()).filter(i -> list.get(i).equals(k)).findFirst();

        if(index.isPresent()){
            max1 = list.subList(0, index.getAsInt() + 1).stream().max(Integer::compareTo).get();
            max2 = list.subList(index.getAsInt(), list.size()).stream().max(Integer::compareTo).get();
        }

        System.out.println(max1 + " " + max2);
    }

    class GCExample{
        @Override
        protected void finalize() throws Throwable {
            print("GCExample.finalize() was called \n");
            super.finalize();
        }
    }

    @Test
    void garbageCollector(){
        GCExample example = new GCExample();
        example = null;
        System.gc();
        System.runFinalization();
    }

}
