package com.oops;

import java.util.Optional;

/*
 * Given a String address, print the address if it 
 * is not null or else print the default address as "India".
 */

public class Opt2 {
    public static void main(String[] args) {
        String address = null; // You can change this to test different values
        Optional<String> optionalAddress = Optional.ofNullable(address);
        System.out.println(optionalAddress.orElse("India"));
    }
}
