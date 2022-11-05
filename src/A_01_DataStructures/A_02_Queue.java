package A_01_DataStructures;

import java.util.ArrayDeque;

public class A_02_Queue {
    public static void main(String[] args) {

        /*

         Queue = FIFO Data Structure. First-In First-Out
                 A collection designed for holding elements prior to processing
                 Linear data structure (works like queue in a supermarket)
                 offer() to add to the tail
                 poll() to remove from the head
                 peek() to see the element at the head

          Uses of Queues ?
                 1. Keyboard Buffer
                 2. Printer Queue
                 3. Used in LinkedLists, PriorityQueues, Breadth-first search

         */

        ArrayDeque<String> queue = new ArrayDeque<>();

        queue.offer("1 Karen");
        queue.offer("2 Chad");
        queue.offer("3 Toshko");

        System.out.println(queue.isEmpty());
        System.out.println(queue);

        System.out.println("Remove(poll): " + queue.poll());

        System.out.println(queue);

        System.out.println("Peek: " + queue.peek());

        System.out.println(queue);

    }
}
