/*
Given a string consisting of brackets, write a program to examine whether the pairs and the orders of "{", "}", "(", ")", "[", "]" are correct (balanced).
For example, the program should print true for the string [()]{}{[()()]()} and false for ()[]}.

The classic algorithm for solving this problem relies on using a stack.

1. create an instance of a stack;
2. traverse the input string;
2.1. if the current character is a starting bracket "(" or "{" or "{" then push it to the stack;
2.2. if the current is a closing bracket ")" or "}" or "]" then remove (pop) the top element from the stack;
     if the popped bracket is the matching starting bracket then fine else parenthesis are not balanced;
3. after completing traversal, if there are some starting brackets left in the stack, then the parenthesis are not balanced.
 */

package queue;

import java.util.*;

public class Brackets {
    private static List<String> list = Arrays.asList("(", "[", "{", "}", "]",")");
    private static Deque<Integer> deque = new ArrayDeque();
    private static  boolean checker = true;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String brackets = scan.next();
        int length = list.size() - 1; // index of last closed bracket
        int middle = (length / 2) + 1; // index of first closed bracket

        for(int i = 0; i < brackets.length(); i++) {
            String c = Character.toString(brackets.charAt(i));
            int index = getIndex(c);
            if (index < middle) {
                deque.add(index);
            } else {
                if (deque.peek() != null && index != -1) {
                    int last = deque.pollLast();
                    if (last + index != length) {
                        checkerFalse();
                        break;
                    }
                } else {
                    checkerFalse();
                    break;
                }
            }
        }
        if (checker){
            result();
        }

    }

    private static int getIndex(String c) {
        int index = -1;
        for(int i = 0; i < 6; i++) {
            if (c .equals(list.get(i))) {
                index = i;
                break;
            }
        }
        return index;
    }

    private static void checkerFalse() {
        checker = false;
        System.out.print("false");
    }

    private static void result() {
        if (deque.peek() == null) {
            System.out.print("true");
        } else {
            System.out.print("false");
        }
    }
}
