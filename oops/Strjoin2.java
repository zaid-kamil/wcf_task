package oops;

import java.util.StringJoiner;

/*
 * Given two StringJoiners s1 and s2 which contains n city 
 * names separated by - (hyphen), display the output for the given cases:
 * i) s1 merged to s2.
 * ii) s2 merged to s1.
 */

public class Strjoin2 {
    private static String merge(StringJoiner s1, StringJoiner s2) {
        return s1.merge(s2).toString();
    }

    public static void main(String[] args) {
        // create two StringJoiners
        StringJoiner s1 = new StringJoiner("-");
        s1.add("New York").add("Chicago").add("Los Angeles");
        StringJoiner s2 = new StringJoiner("-");
        s2.add("San Francisco").add("Boston").add("Seattle");

        System.out.println(merge(s1, s2));
        System.out.println(merge(s2, s1));
    }
}
