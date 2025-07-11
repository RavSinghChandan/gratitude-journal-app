package org.example.baisics;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Basics {

    public static void main(String[] args) {
        String name = "banana";
        System.out.println(getCharacterCount(name));
    }
    private static Map<Character,Long> getCharacterCount(String name) {
        return name
                .chars()
                // input = "banana"
                // → IntStream of ASCII: [98, 97, 110, 97, 110, 97]

                .mapToObj(c -> (char) c)
                // → Stream<Character>: ['b', 'a', 'n', 'a', 'n', 'a']

                .collect(
                        Collectors.groupingBy(
                                c -> c, // key → 'a', 'b', 'n'
                                Collectors.counting()
                                // grouping result:
                                // 'a' → 3
                                // 'b' → 1
                                // 'n' → 2
                        )
                );
    }
}
