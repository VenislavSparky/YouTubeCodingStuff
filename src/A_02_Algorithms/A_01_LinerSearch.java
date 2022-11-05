package A_02_Algorithms;

public class A_01_LinerSearch {
    public static void main(String[] args) {

        /*
        linear search = iterate through a collection one element at a time
                     runtime complexity: O(n)

                    Disadvantages:
                    1. Slow for large data sets

                    Advantages:
                    1. Fast for searches of small to medium data sets
                    2. Does not need to be sorted
                    3. Useful for data structures that do now have random access
         */

        int[] array = {9, 5, 2, 4, 5, 6, 4, 8, 5,};

        System.out.println("LinearSearch 1: "+linearSearch(array,1));
        System.out.println("LinearSearch 6: "+linearSearch(array,6));

    }

    private static boolean linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value)
                return true;
        }
        return false;
    }

}
