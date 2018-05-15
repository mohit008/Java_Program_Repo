package com.mohit.program.sorting;

import java.util.Arrays;
import java.util.Scanner;


/**
 * Class to use bubble sort algorithm
 *
 * @author Mohit 29-Oct-2015 3:50:14 pm </br></br>
 *         <i>Bubble sort, sometimes referred to as sinking sort, is a simple sorting
 *         algorithm that repeatedly steps through the list to be sorted, compares each
 *         pair of adjacent items and swaps them if they are in the wrong order.
 *         The pass through the list is repeated until no swaps are needed, which
 *         indicates that the list is sorted.</i>
 */
public class BubbleMaster {

    static Scanner sc;

    public BubbleMaster() {

        System.out.println("Enter range");
        sc = new Scanner(System.in);

        // get input from user
        int range = sc.nextInt();

        // time before process
        long t1 = System.currentTimeMillis();

        getBubbleSort(range);

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
     * This method evaluate Bubble sort for given array but do not generate proper output, So this method is not reliable in real time
     *
     * @param range
     */
    public static void getBubbleSortwithoutOutput(int range) {

        Integer[] number = GetRandomArray.getIntegerArray(range);

        //pivot to indicate current cursor
        int pivot = 0;

        //get initial value of array to start
        int init = number[pivot];

        //first and last element of array
        int last = 0, first = 0;

        //length of array
        int array_lenght = number.length - 1;

        for (int i = 0; i < number.length; i++) {

            //get last number of modified array
            last = number[number.length - 1];

            //get first number of modified array
            first = number[0];

            //increase pivot by 1
            pivot = pivot + 1;

            //if current number is is greater than next right to it
            if (init > number[pivot]) {

                //swap number
                number[i] = number[pivot];
                number[pivot] = init;

                //set pivot to 0,init to first number,i to less than 0, if its length is equal to array size
                if (pivot == array_lenght) {
                    init = first;
                    pivot = 0;
                    i = -1;
                }
            }

            //if current number is is less than next right to it
            if (init < number[pivot]) {
                //do nothing and set current number as pivot
                init = number[pivot];
            }

            //if init number is equal last number of array
            if (init == last) {

                //set pivot to 0,init to first number,i to less than 0, if its length is equal to array size
                init = first;
                pivot = 0;
                i = -1;
            }
            System.out.println(Arrays.toString(number));
        }
    }

    /**
     * This method sort the given array by using <b>Bubble Sort Algorithm</b>
     *
     * @param range
     */
    public static void getBubbleSort(int range) {

        Integer[] number = GetRandomArray.getIntegerArray(range);

        //main cursor to run across array
        int pivot_main = 0;

        //secondary cursor to run of each index of array
        int pivot_check = 0;

        //variable to hold current check number
        int check_num = 0;

        //run loop for array length time
        for (int i = number.length; i > 0; i--) {

            //set cursor to first number
            pivot_main = number[0];

            //loop size decreases with main loop (i - 1234 | j - 4321)
            for (int j = 0; j < i - 1; j++) {

                //set cursor to next number in loop
                pivot_check = j + 1;

                //get number at above cursor
                check_num = number[j + 1];

                //check if number at current cursor is less than number at main cursor
                if (check_num < pivot_main) {
                    //swap there position
                    number[pivot_check] = pivot_main;
                    number[j] = check_num;
                }

                //check if number at current cursor is greater than number at main cursor
                if (check_num > pivot_main) {
                    //transfer current number to main cursor
                    pivot_main = check_num;
                }
            }
            System.out.println(Arrays.toString(number));
        }
    }
}
