package queue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class StackSimulation {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> stackMax = new ArrayDeque<>();
        stackMax.addLast(0);

        int n = scan.nextInt();
        for(int i = 0; i < n; i++) {
            String command = scan.next().toLowerCase();
            if (command.equals("max")) {
                System.out.println(stackMax.peekLast());
            } else {
                if (command.equals("push")) {
                   push(stack, stackMax);
                } else if (command.equals("pop")) {
                    pop(stack, stackMax);
                }
            }
        }
    }

    private static void pop(ArrayDeque<Integer> stack, ArrayDeque<Integer> stackMax) {
        stack.pollLast();
        stackMax.pollLast();
    }

    private static void push(ArrayDeque<Integer> stack, ArrayDeque<Integer> stackMax) {
        int item = scan.nextInt();
        stackMax.addLast(Math.max(item, stackMax.peek()));
        stack.addLast(item);
    }
}
