/*
QUESTION #1:

Write a Java method that takes an array of "sets" of String objects,
and determines whether _all_ sets in the array are equivalent.

Each "set" in the input array is represented as an array of String objects, in 
no particular order, and possibly containing duplicates. Nevertheless, when
determining whether two of these "sets" are equivalent, you should disregard
order and duplicates. For example, the sets represented by these arrays are
all equivalent:

{"a", "b"}
{"b", "a"}
{"a", "b", "a"}

The signature for your method should be:

public static boolean allStringSetsIdentical(String[ ][ ] sets)

Examples of the method in operation:

allStringSetsIdentical(new String[][] {{"a","b"},{"b","b","a"},{"b","a"}})
returns true

allStringSetsIdentical(new String[][] {{"a","b"},{"a"},{"b"}}) returns false
 */

package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

    }

    public static boolean allStringSetsIdentical(String[][] sets) {
        if (sets == null)
            throw new IllegalArgumentException("Parameter 'sets' cannot be null");

        if (sets.length <= 1)
            return true;

        HashSet<String> comparisonSet = addAndGetNewSet(sets[0]);

        for (int i = 1; i < sets.length; i++) {
            Set<String> set = addAndGetNewSet(sets[i]);
            if (!comparisonSet.equals(set)) {
                return false;
            }
        }

        return true;
    }

    private static HashSet<String> addAndGetNewSet(String[] set) {
        HashSet<String> newSet = new HashSet<>();
        Collections.addAll(newSet, set);

        return newSet;
    }
}