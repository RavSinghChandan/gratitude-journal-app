package org.example.baisics;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Basics {

    public static void main(String[] args) {
        removeDuplicates();
        secondHighestNumber();
        countElementOccurrences();
        characterFrequency();
        evenOddNumbers();
        reverseWordsInSentence();
        listToCommaSeparated();
        sortListInReverseOrder();
        firstNonRepeatingCharacter();
        mergeListsAndRemoveDuplicates();
    }

    // 1. Remove duplicates from a list
    public static void removeDuplicates() {
        List<Integer> list = List.of(1, 2, 2, 3, 4, 4, 5);
        List<Integer> result = list.stream().distinct().toList();
        System.out.println("Remove Duplicates: " + result);
    }

    // 2. Find the second highest number in a list
    public static void secondHighestNumber() {
        List<Integer> list = List.of(3, 1, 4, 5, 2, 5);
        Optional<Integer> secondHighest = list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        System.out.println("Second Highest: " + secondHighest.orElse(null));
    }

    // 3. Count occurrence of each element in a list
    public static void countElementOccurrences() {
        List<String> list = List.of("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> freq = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Element Frequencies: " + freq);
    }

    // 4. Find frequency of characters in a String
    public static void characterFrequency() {
        String str = "hello world";
        Map<Character, Long> freq = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c != ' ')
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Character Frequencies: " + freq);
    }

    // 5. Get only even/odd numbers from a list
    public static void evenOddNumbers() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> evens = list.stream().filter(n -> n % 2 == 0).toList();
        List<Integer> odds = list.stream().filter(n -> n % 2 != 0).toList();
        System.out.println("Evens: " + evens);
        System.out.println("Odds: " + odds);
    }

    // 6. Reverse each word in a sentence
    public static void reverseWordsInSentence() {
        String sentence = "Hello Java Stream";
        String result = Arrays.stream(sentence.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println("Reversed Words: " + result);
    }

    // 7. Convert List to comma-separated String
    public static void listToCommaSeparated() {
        List<String> items = List.of("Java", "Python", "C++");
        String result = String.join(", ", items);
        System.out.println("Comma Separated: " + result);
    }

    // 8. Sort a list in reverse order
    public static void sortListInReverseOrder() {
        List<Integer> list = List.of(5, 2, 8, 1, 3);
        List<Integer> sorted = list.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("Sorted Descending: " + sorted);
    }

    // 9. Find the first non-repeating character in a String
    public static void firstNonRepeatingCharacter() {
        String str = "swiss";
        Character result = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> Collections.frequency(str.chars()
                        .mapToObj(x -> (char)x)
                        .toList(), c) == 1)
                .findFirst()
                .orElse(null);
        System.out.println("First Non-Repeating Character: " + result);
    }

    // 10. Merge two lists and remove duplicates
    public static void mergeListsAndRemoveDuplicates() {
        List<Integer> list1 = List.of(1, 2, 3, 4);
        List<Integer> list2 = List.of(3, 4, 5, 6);
        List<Integer> merged = Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .toList();
        System.out.println("Merged without Duplicates: " + merged);
    }
}
