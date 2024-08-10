import org.junit.jupiter.api.Test;

import java.util.*;

public class CodingTest {

    @Test
    void test(){
        String str = "{[()]}";
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}'); map.put('[', ']'); map.put('(', ')');
        Stack<Character> stack = new Stack<>();

        char[] chars = str.toCharArray();
        for (char c: chars)
            stack.push(c);

        Enumeration<Character> elements = stack.elements();
        while(elements.hasMoreElements()){
            Character e = elements.nextElement();
            Character pop = stack.pop();
            print("%s is closing? %s %s  %n", e, pop.equals(map.get(e)), pop);
        }
    }

    @Test
    void balancedString(){
        String str = "{[(())]}";
        Map<Character, Character> map = new HashMap<>();
        map.put('}','{');map.put(']','[');map.put(')','(');
        Stack<Character> occur = new Stack<>();

        for(Character c: str.toCharArray()){
            if(map.values().stream().anyMatch(e -> e.equals(c)))
                occur.add(c);
            else if(!map.get(c).equals(occur.pop())){
                print("ERROR: String is not balanced");
                return;
            }
        }

        print("String is balanced!!");
    }

    void print(String msg, Object... args){
        System.out.printf(msg , args);
    }


    @Test
    void sumAfterElement(){
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(7, 9, 5, 3, 1, 0));
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            Integer n = input.get(i);
            Optional<Integer> sumOpt = input.subList(i+1, input.size()).stream().reduce(Integer::sum);

            if(sumOpt.isPresent() && n > sumOpt.get())
                result.add(n);
        }

        print(result.toString());
    }

    @Test
    void sumAfterElement2(){
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(7, 9, 5, 3, 1, 0));
        ArrayList<Integer> result = new ArrayList<>();
        Integer sum = 0;

        for (int i = input.size()-1; i >= 0 ; i--) {
            Integer n = input.get(i);
            sum += n;
            if(i > 0 && input.get(i-1) > sum)
                result.add(input.get(i-1));
        }

        print(result.toString());
    }



}
