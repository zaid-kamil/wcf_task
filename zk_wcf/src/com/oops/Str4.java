package com.oops;

/*
 * Write a java program that will return the first half of the string, 
 * if the length of the string is even. Else it should return null for odd length string.
 * 
 * Example1)
 * i/p:TomCat
 * o/p:Tom
 * 
 * Example2)
 * i/p:Apron
 * o/p:null
 */

public class Str4 {
    private static String getFirstHalf(String s){
        if(s.length() % 2 == 0){
            return s.substring(0, s.length()/2);
        }
        return null;
    }

    public static void main(String[] args) {
        String str1 = "TomCat";
        String str2 = "Apron";
        String str3 = "Chlorine";
        System.out.println(getFirstHalf(str1));
        System.out.println(getFirstHalf(str2));
        System.out.println(getFirstHalf(str3));
    }
}
