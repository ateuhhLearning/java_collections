/*
Write a program that implements a simple load balancer.

The program must read tasks from the standard input and distribute them between two queues.
Tasks will be processed by a system (in future). Each task has a unique identifier and a number indicating the load on the system (in parrots).

The balancer should distribute tasks between queues by the following rule - the task is added to the lower-load queue (by the total load).
If both queues have the same total load indicator, the task must be added to the first queue.

It's guaranteed, the input data contain at least two tasks.
 */

package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleBalancer {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Integer> firstQueue = new ArrayDeque<>();
        Deque<Integer> secondQueue = new ArrayDeque<>();
        int totalFirstWeight = 0;
        int totalSecondWeight = 0;
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int item = scan.nextInt();
            int weight = scan.nextInt();
            if (totalSecondWeight < totalFirstWeight) {
                totalSecondWeight = addElement(secondQueue, totalSecondWeight, item, weight);
            } else {
                totalFirstWeight = addElement(firstQueue, totalFirstWeight, item, weight);
            }
        }
        for (Integer i : firstQueue) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (Integer i : secondQueue) {
            System.out.print(i + " ");
        }
    }

    private static int addElement(Deque<Integer> queue, int totalWeight, int item, int weight) {
        queue.addLast(item);
        return totalWeight + weight;
    }
}
