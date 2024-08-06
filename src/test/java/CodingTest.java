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

}
