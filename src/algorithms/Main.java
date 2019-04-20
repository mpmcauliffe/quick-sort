package algorithms;


/**
 * Michael Paul McAuliffe -- April 2019
 **/
public class Main {

    public static void main(String[] args) {
        /**  initialize unsorted array with assigned elements **/
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };


        //  for printing only
        for (int num: intArray) { System.out.print(num + "  "); }
        System.out.print("\n");


        /** call quickSort() **/
        quickSort(intArray, 0, intArray.length);


        //  for printing only
        for (int num: intArray) { System.out.print(num + "  "); }
        System.out.print("\n");
    }

/**
 * QUICK SORT ALGORITHM
 **/
    public static void quickSort(int[] input, int start, int end) {

        /**
         *      BASECASE:
         *          If end - start < 2 then the array is only 1 element in length. An array of length 1
         *          is sorted.
         **/
        if (end - start < 2) { return; }

        /**     { 20, 35, -15, 7, 55, 1, -22 }      **/
        /**
         *      --int pivotIndex -- determines what the pivot point is in the sorted partition
         *          At this point, everything left of the pivot is smaller than the pivot and everything
         *          to the right of the pivot is larger than the pivot.
         **/
        int pivotIndex = partition(input, start, end);

        /**
         *      quickSort on left sub array     { __, __, pivotIndex, ... }
         *      quickSort on right sub array    { ..., pivotIndex, __, __ }
         **/
        quickSort(input, start, pivotIndex);
//        for (int i = 0; i < input.length; i++) {
//            System.out.print(input[i] + "  ");
//        }
//        System.out.print("\n");
        quickSort(input, pivotIndex + 1, end);
    }

    public static int partition(int[] input, int start, int end) {

        /** Using first element as pivot **/

        /**
         *      VARIABLES
         *          --int pivot     -- assigns value at pivot index
         *          --int i         -- traverses left to right
         *          --int j         -- traverses right to left
         *
         *          * the process stops when i and j cross each other
         **/
        int pivot = input[start];
        int i = start;
        int j = end;

        /**     { 20, 35, -15, 7, 55, 1, -22 }      **/
        /**
         *      OUTER LOOP
         *          TERMINATES when i crosses j
         **/
        while (i < j) {

            /** INNER LOOP serves to decrement j **/
            while (i < j && input[--j] >= pivot);

            /**
             *      CONDITION
             *          Loop terminates but we want to be sure that i < j, but that input[--j] < pivot.
             *          In this case we switch the position of i and j.
             **/
            if (i < j) {
                input[i] = input[j];
            }

            /** INNER LOOP serves to increment i **/
            while (i < j && input[++i] <= pivot);

            if (i < j) {
                input[j] = input[i];
            }
        }

        /** completes the swap **/
        input[j] = pivot;

        /** returns the pivot value to quickSort **/
        return j;
    }
/** END **/
}
