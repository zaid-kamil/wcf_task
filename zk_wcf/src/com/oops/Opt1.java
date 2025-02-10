package com.oops;
import java.util.Optional;

/*
 * Use Optional class and avoid NullPointerException from the below code:
 * String names[ ] = new String[5];
 * System.out.print(names[0].length( ));
 */

public class Opt1 {
    public static void main(String[] args) {
        String names[] = new String[5];
        Optional<String> optionalName = Optional.ofNullable(names[0]);
        System.out.print(optionalName.map(String::length).orElse(0));
    }
}
