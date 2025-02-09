package oops;

/*
 * Write a Program to check whether a given String is Palindrome or not.
 */

public class str1 {
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("one text argument is required");
            return;
        }
        String str = args[0];
        if(isPalindrome(str)){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }
    }

    private static boolean isPalindrome(String str){
        int i = 0;
        int j = str.length() - 1;
        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
