package java_fundamentals;

/*
 * Initialize two character variables in a program 
 * and display the characters in alphabetical order.
 * 
 * Example1) if the first character is 's' and second 
 * character is 'e' then the output should be  e,s
 * 
 * Example2) if the first character is 'a' and second 
 * character is 'e', then the output should be a,e
*/

public class Fcs4 {
    public static void main(String[] args) {
        if (args.length != 2){
            System.out.println("Please provide two arguments");
            return;
        }
        char first = args[0].charAt(0);
        char second = args[1].charAt(0);
        if (first < second){
            System.out.println(first + "," + second);
        }else{
            System.out.println(second + "," + first);
        }
    }
}
