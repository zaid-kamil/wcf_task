package oops;

/*
 * Given a string, return a new string made of 'n' copies of 
 * the first 2 chars of the original string where 'n' is the length of the string.
 * Example1)
 * i/p:Wipro
 * o/p:WiWiWiWiWi
 */

public class Str3 {
    private static void copyFirstTwo(String s, int n){
        String firstTwo = s.substring(0, 2);
        for(int i = 0; i < n; i++){
            System.out.print(firstTwo);
        }
    }

    public static void main(String[] args) {
        String str1 = "Hello";
        copyFirstTwo(str1, str1.length());
    }
}
