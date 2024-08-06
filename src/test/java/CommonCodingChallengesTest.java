import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.*;

import static org.hackerrank.Utils.print;

public class CommonCodingChallengesTest {

    @Test
    void fizzBuzz(){
        for(int i=1; i<=100; i++)
            print("%s", (i%2==0&&i%5==0? "FizzBuzz("+i+")\n" :
                    i%2==0? "Fizz("+i+")\n" : i%5==0? "Buzz("+i+")\n": ""));
    }

    @Test
    void reverseString(){
        String str = "This is a string";
        List<Character> chars = new ArrayList<>();
        for(char c: str.toCharArray()) chars.add(c);

        print("approach #1 \n");
        Collections.reverse(chars);
        chars.forEach(c -> print(String.valueOf(c))); //approach 1

        print("\n\napproach #2 \n");

        for(int i=str.length()-1; i>=0; i--)
            print(String.valueOf(str.charAt(i)));  // approach 2 less lines better!!

        print("\n\napproach #3 \n");

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++)
            stack.push(str.charAt(i));

        while(!stack.isEmpty())
            print(String.valueOf(stack.pop())); // approach 3

    }

    @Test
    void reverseWords(){
        String str = "This string is !!desrever";

        for(String word: str.split(" ")) {
            for(int i=word.length()-1; i>=0; i--)
                print("%c" ,word.charAt(i));
            print(" ");
        }
    }

    @Test
    void palindrome(){
        String str = "anona";
        StringBuilder reversed = new StringBuilder();

        for(int i=str.length()-1; i>=0; i--)
            reversed.append(str.charAt(i));

        Assertions.assertEquals(str, reversed.toString()); // works!

        boolean isPalindromeUsingStack = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++)
            stack.push(str.charAt(i));

        int idx = str.length()-1;
        while (!stack.isEmpty()){
            isPalindromeUsingStack = stack.pop().equals(str.charAt(idx));
        }

        Assertions.assertTrue(isPalindromeUsingStack);

        boolean isPalindrome = true;

        for (int i = 0; i < str.length(); i++)
            for (int j = str.length()-1; j >= 0; j --)
                isPalindrome = str.charAt(i) == str.charAt(j);

        Assertions.assertTrue(isPalindrome); // second approach
    }

    @Test
    void fibSequence(){
        BigInteger prev = BigInteger.ZERO;
        BigInteger num = BigInteger.valueOf(1L);
        int count = 2, limit = 50;

        while(count <= limit){
            BigInteger temp = num;
            num = num.add(prev);
            prev = temp;

            count ++;
        }

        print("%d", num);
        Assertions.assertEquals(BigInteger.valueOf(12586269025L), num);
    }

    @Test
    void isPrime(){
        int input = 7;
        boolean isPrime = true;

        for(int i=1; i<=input; i++)
            if(i!=1 && i!=input && input%i ==0)
                isPrime = false;

        Assertions.assertTrue(isPrime);
    }

}
