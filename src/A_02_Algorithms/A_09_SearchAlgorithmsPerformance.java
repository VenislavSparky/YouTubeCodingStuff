package A_02_Algorithms;

import java.util.Scanner;


public class A_09_SearchAlgorithmsPerformance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long startTime;
        long endTime;
        long elapsedTime;

       int[] array =  createArrayWithLength(Integer.parseInt(scanner.nextLine()));

        startTime = System.nanoTime();
        linearSearch(array,array.length/3);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("LinerSearch:\t" + elapsedTime + " ns");

        startTime = System.nanoTime();
        binarySearch(array,array.length/3);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("BinarySearch:\t" + elapsedTime + " ns");

        startTime = System.nanoTime();
        interpolationSearch(array,array.length/3);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("InterpolationSearch:\t" + elapsedTime + " ns");


    }

    private static int[] createArrayWithLength(int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        return array;
    }

    private static boolean linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value)
                return true;
        }
        return false;
    }
    private static int binarySearch(int[] array, int target) {

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {

            int middle = low + (high - low) / 2;
            int value = array[middle];

          //  System.out.println("middle: " + value);

            if (value < target) low = middle + 1;
            else if (value > target) high = middle - 1;
            else return middle; //target found
        }

        return -1;
    }
    private static int interpolationSearch(int[] array, int value) {

        int high = array.length - 1;
        int low = 0;

        while (value >= array[low] && value <= array[high] && low <= high) {

            int probe = low + (high - low) * (value - array[low]) /
                    (array[high] - array[low]);


            //System.out.println("probe: " + probe);

            if (array[probe] == value) {
                return probe;
            } else if (array[probe] < value) {
                low = probe + 1;
            } else {
                high = probe - 1;
            }
        }

        return -1;
    }
}
