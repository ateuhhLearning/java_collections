/*
At some point in the Bioinformatics Institute, biology students no longer understood what did the computer science students said:
they spoke a strange set of sounds.

And one of the biologists had suddenly discovered the secret of computer science students:
they used the substitution cipher in their communication, i.e. they replaced each symbol of the initial message to the corresponding another symbol.
Biologists gained the key to the cipher and now they need help:

Write a program that can encode and decode the substitution cipher.
The program accepts two input strings of the same length;
the first line contains the characters of the original alphabet, the second line - the symbols of a resulting alphabet,
then goes a line you need to encode by the transmitted key, and another line to be decrypted.
 */

package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cipher {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Character, Character> pairEncode = new HashMap<>();
        Map<Character, Character> pairDecode = new HashMap<>();
        String key = scan.nextLine();
        String value = scan.nextLine();
        for (int i = 0; i < key.length(); i++) {
            char decodeItem = key.charAt(i);
            char encodeItem = value.charAt(i);
            mapCreator(pairEncode, decodeItem, encodeItem);
            mapCreator(pairDecode, encodeItem, decodeItem);
        }
        String toEncode = scan.nextLine();
        handler(pairEncode, toEncode);
        String toDecode = scan.nextLine();
        handler(pairDecode, toDecode);
    }

    private static void mapCreator(Map<Character, Character> map, Character key, Character value) {
        if (!map.containsKey(key)) {
            map.put(key, value);
        }
    }

    private static void handler(Map<Character, Character> map, String line) {
        StringBuilder handlerString = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char item = line.charAt(i);
            if (map.containsKey(item)) {
                handlerString.append(map.get(item));
            }
        }
        System.out.println(handlerString.toString());
    }
}
