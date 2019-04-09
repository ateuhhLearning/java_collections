/*
Write a program that reads key-value pairs and outputs pairs whose keys belongs to the specified range (inclusive) in the ascending order by the key.

Input data format

The first line contains two values - range borders. The second line contains the number of key-value pairs.
Next lines contain pair (an integer key and a string value separated by a space).

Output data format

All pairs whose keys belong to the range.
Each pair in a new line. The key and the value of a pair must be separated by a space.
 */

package map;

import java.util.*;

public class Slice {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        SortedMap<Integer, String> map = new TreeMap<>();
        int begin = scan.nextInt();
        int end = scan.nextInt();
        int n = scan.nextInt();
        mapCreator(map, n);
        NavigableMap<Integer, String> slice = ((TreeMap<Integer, String>) map).subMap(begin, true, end, true);
        sliceCreator(slice);
    }

    private static void mapCreator(Map<Integer, String> map, int n) {
        for (int i = 0; i < n; i++) {
            int key = scan.nextInt();
            String value = scan.next();
            map.put(key, value);
        }
    }

    private static void sliceCreator(Map<Integer, String> map) {
        for (Integer i : map.keySet()) {
            System.out.println(i + " " + map.get(i));
        }
    }
}
