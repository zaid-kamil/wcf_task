package com.abeh.pkgs;

import test.Foundation;

public class AccessTest {
    public static void main(String[] args) {
        Foundation foundation = new Foundation();
        
        // Trying to access all variables
        
        // This will not compile - private variable
        // System.out.println("var1 = " + foundation.var1);
        
        // This will not compile - default variable not accessible outside package
        // System.out.println("var2 = " + foundation.var2);
        
        // This will not compile - protected variable not accessible 
        // (unless AccessTest extends Foundation)
        // System.out.println("var3 = " + foundation.var3);
        
        // This will work - public variable
        System.out.println("var4 = " + foundation.var4); 
    }   
}
