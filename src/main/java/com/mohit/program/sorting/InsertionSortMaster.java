package com.mohit.program.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * This class use Insertion Sort Algorithm to sort an array
 *
 * @author Mohit 23-Nov-2015 12:30:01 pm </br></br>
 *         <p>
 *         <i>Insertion sort iterates, consuming one input element
 *         each repetition, and growing a sorted output list. Each
 *         iteration, insertion sort removes one element from the
 *         input data, finds the location it belongs within the sorted
 *         list, and inserts it there. It repeats until no input elements remain.</i>
 */
public class InsertionSortMaster {

    static int pivot = 0;
    static int variable = 0;
    static Scanner sc;

    public InsertionSortMaster() {
        System.out.println("Enter range");
        sc = new Scanner(System.in);

        // get input from user
        int range = sc.nextInt();

        // time before process
        long t1 = System.currentTimeMillis();

        getInsertionsortByArray(range);
        System.out.println("pre time : " + t1 + " mis");
        System.out.println("--------------------------------------------------");

        // time after process
        long t2 = System.currentTimeMillis();
        System.out.println("post time : " + t2 + " mis");

        // evaluate time
        long time = t2 - t1;
        System.out.println("Time eclapsed to evaluate : " + time + " mis");
    }

    /**
     * Input range in which you want use algorithm
     *
     * @param range
     */
    public static void getInsertionsortByArray(int range) {

        // create new Integer of present array
        Integer[] number_array = GetRandomArray.getIntegerArray(range);

        // loop to check all previous value
        for (int i = 0; i < number_array.length; i++) {

            // loop from 0 to current value
            for (int j = 0; j < i; j++) {

                // check if current number is less than pivot number
                if (number_array[pivot] < number_array[j]) {

                    // take a number to third variable
                    variable = number_array[j];

                    // interchange variable
                    number_array[j] = number_array[pivot];

                    // replace third value to current pivot
                    number_array[pivot] = variable;
                }
            }
            // increase pivot by 1 to check value
            pivot = pivot + 1;
        }

        // print sorted array
        System.out.println("Sorted array ");
        System.out.println(Arrays.toString(number_array));
    }
}
