package A_01_DataStructures;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class A_03_PriorityQueues {
    public static void main(String[] args) {
         /*

        Priority Queue = FIFO Data Structure that serves elements
                         with the highest priorities first
                         before the elements with lower priority

         */

        ArrayDeque<Double> queue = new ArrayDeque<>(); // normal queue for reference

        queue.offer(3.3);
        queue.offer(1.1);
        queue.offer(4.4);
        queue.offer(2.2);

        System.out.println("Queue:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        //=========================================================

        PriorityQueue<Double> priorityQueue = new PriorityQueue<>();
//        PriorityQueue<Double> priorityQueue
//          =  new PriorityQueue<>(Collections.reverseOrder());
//        Using comparator we can reverse the order of the Priority Queue!!

        priorityQueue.offer(3.3);
        priorityQueue.offer(1.1);
        priorityQueue.offer(4.4);
        priorityQueue.offer(2.2);

        System.out.println("Priority Queue:");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }


    }
}
