package com.oops;

/*
 * Given a string, if the first or last chars are 'x', 
 * return the string without those 'x' chars, 
 * otherwise return the string unchanged. 

 * If the input is "xHix", then output is "Hi".
 * If the input is "America", then the output is "America".
 */

public class Str7 {
    private static String withoutX(String str) {
        if (str.charAt(0) == 'x') {
            str = str.substring(1);
        }
        if (str.charAt(str.length() - 1) == 'x') {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    public static void main(String[] args) {
        String str = "xHix";
        String str2 = "India";
        System.out.println(withoutX(str));
        System.out.println(withoutX(str2));
    }
}
