package A_01_DataStructures;

import java.util.ArrayDeque;

public class A_01_Stack {
    public static void main(String[] args) {

        /*

        Stack = LIFO Data Structure. Last-In First-Out
                stores object into a sort of "vertical tower"
                push() to add to the top
                pop() to remove from the top
                peek() to see the element at the top

        Uses of stacks?
            1.Undo/Redo features in text editors
            2.Moving back/forward through browser history
            3.Backtracking algorithms  (maze, file directories)
            4.Calling functions (call stack)

         */

        ArrayDeque<String> stack = new ArrayDeque<>();

        stack.push("1 Minecraft");
        stack.push("2 TheWitcher");
        stack.push("3 FFVII");

        System.out.println(stack.isEmpty());
        System.out.println(stack);

        System.out.println("Remove(pop): " + stack.pop());

        System.out.println(stack);

        System.out.println("Peek: " + stack.peek());

        System.out.println(stack);


    }
}
