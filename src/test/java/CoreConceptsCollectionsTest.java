import org.hackerrank.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hackerrank.Utils.print;

public class CoreConceptsCollectionsTest {

    @Test
    void javaListsAndStreams(){
        List<String> list = new ArrayList<>(Arrays.asList("abc", "def", "ghi", "jkl"));

        list.stream().forEach(Utils::print);
        print("\n \n");

        Optional<String> maxStr = list.stream().max(String::compareTo);
        Optional<String> strWithA = list.stream().filter(e -> e.contains("a")).findAny();
        boolean contains = list.stream().anyMatch(e -> e.contains("z"));
        List<String> mappedAndFiltered = list.stream().filter(e -> e.contains("d") || e.contains("g"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        List<String> reordered = list.stream().sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        Optional<String> concatenated = list.stream().reduce(String::concat);
        long count = list.stream().filter(e -> e.contains("a") || e.contains("g")).count();
        Stream<String> limitMax2 = list.stream().limit(2);

        print("\n \n ** Stream API ** \n\n");

        print("max str: %s \n", maxStr);
        print("has a: %s \n", strWithA);
        print("contains z ? %s \n", contains);
        print("filtered d g toUpperCas:  %s \n", mappedAndFiltered);
        print("reordered: %s \n", reordered.toString());
        print("reduce: %s \n", concatenated.orElse(""));
        print("count: %s \n", count);

        print("limit: ");
        limitMax2.forEach(Utils::print);
        print("\n");

        print("observing elements with peek: ");
        list.stream().peek(Utils::print).collect(Collectors.toList());


        print("\n \n ** ArrayList Example ** \n\n");

        ArrayList<String> arr = new ArrayList(Arrays.asList("abc", "def", "ghi", "jkl"));

        print("indexOf: %s \n", arr.indexOf("abc"));
        print("get: %s \n", arr.get(0));
        print("cotains: %s \n", arr.contains("abc"));

        print("\n \n ** LinkedList Example ** \n\n");


        LinkedList<String> linkedlist = new LinkedList<>(Arrays.asList("abc", "def", "ghi", "jkl"));
        linkedlist.addFirst("xyz");

        print("Descending iterator test: "); // does not use comparator for ordering in iterator, is basically reversed the order
        Iterator<String> desc= linkedlist.descendingIterator();
        while (desc.hasNext())
            print("%s", desc.next());
        print("\n");

        print("Experiment with pop: ");
        while (!linkedlist.isEmpty()){
            print("%s", linkedlist.pop());
        }
        print("\n");

    }

    @Test
    void javaSets(){
        Set<String> set = new HashSet<>(Arrays.asList("abc", "def", "ghi", "jkl"));
        TreeSet<String> tree = new TreeSet<>(Arrays.asList("abc", "def", "ghi", "jkl"));

        print("\n \n ** Set Example ** \n\n");

        print("Set add() %s \n", set.add("abc")); //should be false
        print("Printing: ");
        set.forEach(Utils::print);
        print("\n\n");

        print("\n \n ** TreeSet Example ** \n\n");

        print("first: %s \n", tree.first());
        print("last: %s \n", tree.last());
        print("higher(ghi): %s \n", tree.higher("ghi"));
        print("lower(ghi): %s \n", tree.lower("ghi"));

    }


    @Test
    void javaMaps(){
        print("\n \n ** HashMap Example ** \n\n");
        Map<String, String> map = new HashMap<>();
        map.put("vq001", "Victor Quintanilla");
        map.put("wq001", "Will Quintanilla");

        print("vq001: %s \n", map.get("vq001"));
        map.compute("cq001",(x,y) -> "Carlos Quintanilla");

        print("- Entries - \n");
        for(Map.Entry<String, String> entry: map.entrySet())
            print("entry: %s \n", entry);

    }


    @Test
    void concurrentMapTest(){
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "Value1");
        map.put("2", "Value2");

        String key = null;
        Iterator<String> keys = map.keySet().stream().iterator();
        while(keys.hasNext()){
            if(keys.next().equals("1"))
                map.remove("1");
        }

        print("results %s ", map);
    }

    @Test
    void normalMapConcurrentModificationException(){
        Map<String, String> map = new HashMap<>();
        map.put("1", "Value1");
        map.put("2", "Value2");

        Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
        while(entries.hasNext()){
            if(entries.next().getValue().equals("1"))
                Assertions.assertThrows(ConcurrentModificationException.class, () -> map.remove("1"));
        }

    }




}
