package com.mohit.program.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * This is example of </b>Selection Sort Algorithm</b>
 *
 * @author Mohit 16-Nov-2015 4:03:16 pm </br></br>
 *         <p>
 *         <i>The algorithm divides the input list into two parts: the sublist of items already sorted,
 *         which is built up from left to right at the front (left) of the list, and the sublist of items
 *         remaining to be sorted that occupy the rest of the list. Initially, the sorted sublist is empty
 *         and the unsorted sublist is the entire input list. The algorithm proceeds by finding the smallest
 *         (or largest, depending on sorting order) element in the unsorted sublist, exchanging (swapping)
 *         it with the leftmost unsorted element (putting it in sorted order), and moving the sublist
 *         boundaries one element to the right.</i>
 */
public class SelectionSortMaster {

    static int pivot = 0, pivot_value = 0, chek_num = 0;
    static List<Integer> array = new ArrayList<Integer>();
    static Scanner sc;

    public SelectionSortMaster() {
        System.out.println("Enter range");
        sc = new Scanner(System.in);

        // get input from user
        int range = sc.nextInt();

        // time before process
        long t1 = System.currentTimeMillis();

        getSelection_Sort(range);

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
     * Sort the give array by using {@link SelectionSortMaster} algorithm by passing range
     *
     * @param range
     */
    public static void getSelection_Sort(int range) {

        // create new Integer of present array
        Integer[] number_array = GetRandomArray.getIntegerArray(range);

        // outer loop
        for (int i = 0; i < number_array.length; i++) {

            // set pivot to current index
            pivot = i;

            // get number at current pivot
            chek_num = number_array[i];

            // inner loop over array
            for (int j = i; j < number_array.length; j++) {

                // check if chek_num is greater than number at current index
                if (chek_num > number_array[j]) {

                    // get the greater
                    chek_num = number_array[j];

                    // get replace number index
                    pivot_value = j;
                }
            }
            // swap number from respective position between smallest and large
            number_array[pivot_value] = number_array[pivot];
            number_array[pivot] = chek_num;
        }

        // print sorted array
        System.out.println("Sorted array");
        System.out.println(Arrays.toString(number_array));
    }

}
