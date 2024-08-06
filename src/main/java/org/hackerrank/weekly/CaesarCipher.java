package org.hackerrank.weekly;


public class CaesarCipher {
    static String exclusions = "'-.$?!+=@#%^&*~\",<>[]{}:;_`/\\()";
    static String abc = "abcdefghijklmnopqrstuvwxyz";
    static char[] lower = abc.toCharArray();
    static char[] upper = abc.toUpperCase().toCharArray();

    public CaesarCipher(){
        super(); //calls parent constructor
//        this(); calls same constructor
    }

    public static String caesarCipher(String str, int rotation) {
        StringBuilder builder = new StringBuilder();
        for (char c: str.toCharArray())
            builder.append(rotation(c, rotation));
        return builder.toString();
    }

    public static char rotation(char c, int rotation){
        if(Character.isDigit(c) || exclusions.contains(String.valueOf(c)))
            return c;

        for (int i = 0; i < abc.length(); i++) {
            if(abc.charAt(i) == Character.toLowerCase(c)){
                if(Character.isUpperCase(c))
                    return upper[(i+rotation>abc.length()-1) ?
                            Math.floorMod((i + rotation) , abc.length()):
                            (i+rotation)];
                else if(Character.isLowerCase(c))
                    return lower[(i+rotation>abc.length()-1) ?
                            Math.floorMod((i + rotation) , abc.length()):
                            (i+rotation)];
                else return c;
            }
        }

        return 0;
    }


}
