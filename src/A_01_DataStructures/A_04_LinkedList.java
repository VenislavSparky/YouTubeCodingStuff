package A_01_DataStructures;

import java.util.ArrayList;
import java.util.LinkedList;

public class A_04_LinkedList {
    public static void main(String[] args) {

        /*
         LinkedLists = Manipulation with LinkedList is faster
            than ArrayList because it uses a doubly linked list,
            so no bit shifting is required in memory.
            LinkedList is better for manipulating data.

            Stores nodes in 2(data + address)
            or 3(address + data + address) parts

         Advantages ?
            1. Dynamic Data Structure (allocates needed memory while running)
            2. Insertion and Deletion of Nodes is easy. O(1)
            3. No/Low memory waste.

         Disadvantages ?
            1. Greater memory usage (additional pointer)
            2. No random access of elements (no index [i])
            3. Accessing/searching elements is more time-consuming. O(n)

         Uses ?
            1. implements Stack/Queue
            2. GPS navigation
            3. music playlists

         */

        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        linkedList.add("F");

        System.out.println("Original: " + linkedList);

        linkedList.add(4, "E");
        System.out.println("Added 'E': " + linkedList);

        linkedList.remove(0);
        System.out.println("Removed index 0: "+linkedList);

    }
}
