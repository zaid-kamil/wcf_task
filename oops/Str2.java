package oops;

/*
 * Write a java program that will concatenate 2 strings and return the result. The result should be in lowercase.
 * 
 * Note:If the concatenation creates a double-char, then one of the characters need to be omitted.
 * 
 * Example1)
 * i/p:Sachin,Tendulkar
 * o/p:sachin tendulkar
 * 
 * Example2)
 * i/p:Mark,kate
 * o/p:markate
 */

public class Str2 {
    public static void main(String[] args) {
        String str1 = "Sachin, Tendulkar";
        String str2 = "Mark, Kate"; 
        String str3 = "Zaid, Kamil";
        System.out.println(fixString(str1));
        System.out.println(fixString(str2));
        System.out.println(fixString(str3));
    }

    private static String fixString(String str) {
        String[] strArr = str.split(",");
        String result = strArr[0].trim() +" "+ strArr[1].trim();
        return result.toLowerCase();
    }
}
