package A_02_Algorithms;

public class A_10_SortAlgorithmsPerformance {
    public static void main(String[] args) {
        long startTime;
        long endTime;
        long elapsedTime;

        int[] array = {9,8,4,5,6,1,2,3,17,8,4,5,5,2,6,1,87,9,1,15,16,13,0,16};

        int[] bubbleArray = array;
        int[] selectionArray = array;
        int[] insertionArray = array;
        int[] mergeArray = array;
        int[] quickArray = array;


        startTime = System.nanoTime();

        bubbleSort(bubbleArray);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("BubbleSort:\t" + elapsedTime + " ns");

        startTime = System.nanoTime();
        selectionSort(selectionArray);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("SelectionSort:\t" + elapsedTime + " ns");

        startTime = System.nanoTime();
        insertionSort(insertionArray);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("InsertionSort:\t" + elapsedTime + " ns");

        startTime = System.nanoTime();
        mergeSort(mergeArray);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("MergeSort:\t" + elapsedTime + " ns");

        startTime = System.nanoTime();
        quickSort(quickArray, 0, quickArray.length - 1);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("QuickSort:\t" + elapsedTime + " ns");


    }

    public static void bubbleSort(int array[]) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static void selectionSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }

            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }

    private static void insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    private static void mergeSort(int[] array) {

        int length = array.length;
        if (length <= 1) return; //base case

        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0; //left array
        int j = 0; //right array

        for (; i < length; i++) {
            if (i < middle) {
                leftArray[i] = array[i];
            } else {
                rightArray[j] = array[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array) {

        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0; //indices

        //check the conditions for merging
        while (l < leftSize && r < rightSize) {
            if (leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            } else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while (l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while (r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }



    }

    private static void quickSort(int[] array, int start, int end) {

        if (end <= start) return; //base case

        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int start, int end) {

        int pivot = array[end];
        int i = start - 1;

        for (int j = start; j <= end; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i;
    }

}
