package org.hackerrank.weekly;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextEditor {
    StringBuilder content = new StringBuilder();
    List<String> operations = new ArrayList<>();

    public void append(String value){
        content.append(value);
        operations.add("1"+value);
    }

    public void delete(int index){
        content.delete(index, content.length()-1);
        operations.add("2"+index);
    }

    public void undo(){
        String last = operations.get(operations.size()-1);

        if(last.charAt(0) == '1')
            content.delete(Integer.parseInt(last.substring(1)), content.length()-1);
        else
            content.append(last.substring(1));

        operations.remove(operations.size()-1);
    }

    public void print(int charPosition){
        System.out.println(content.charAt(charPosition));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor solution = new TextEditor();

        while(true){
            String input = scanner.nextLine();
            char operation = input.charAt(0);

            try{
                switch (operation){
                    case '1':
                        solution.append(input.substring(2));
                        break;
                    case '2':
                        solution.delete(Integer.parseInt(input.substring(2)));
                        break;
                    case '3':
                        solution.print(Integer.parseInt(input.substring(2)));
                        break;
                    case '4':
                        solution.undo();
                        break;
                }
            }catch (Exception e){
                System.err.println(e.getMessage());
            }

        }

    }

}