/*
The simplest spell checker is based on a list of known words.
Every word in the checked text is searched for in this list and, if such a word was not found, it is marked as erroneous.

Write this spell checker.

The first line of the input contains d – number of records in the list of known word.
Next go d lines contain one known word per line, next — the number l of lines of the text, after which — l lines of the text.

Write a program that outputs those words from the text, which are not found in the dictionary (i.e. erroneous).
Your shell checker should be case insensitive. The words are entered in an arbitrary order.
Words, which are not found in the dictionary, should not be duplicated in the output.

 */

package map;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SpellChecker {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>();
        Set<String> otherWords = new HashSet<>();
        int dictionarySize = scan.nextInt();
        addWordsInDictionary(dictionary, dictionarySize);
        int lines = scan.nextInt();
        scan.nextLine();
        checkInDictionary(dictionary, otherWords, lines);
        for (String s : otherWords) {
            System.out.println(s);
        }
    }

    private static void addWordsInDictionary(Set<String> dictionary, int size) {
        for (int i = 0; i < size; i++) {
            String s = scan.next();
            dictionary.add(s.toLowerCase());
        }
    }

    private static void checkInDictionary(Set<String> dictionary, Set<String> otherWords, int lines) {
        for (int i = 0; i < lines; i++) {
            String line = scan.nextLine();
            String[] parts = line.split(" ");
            for (String p : parts) {
                String part = p.toLowerCase();
                if (!dictionary.contains(part)) {
                    otherWords.add(part);
                }
            }
        }
    }
}
