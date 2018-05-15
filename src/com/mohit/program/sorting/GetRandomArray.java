package com.mohit.program.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Mohit Soni on 15-05-2018.
 */
public class GetRandomArray {

    static Random generator;
    static List<Integer> array;

    /**
     * Generate new {@link Integer} from passing {@link Integer} range
     *
     * @param range
     * @return
     */
    static public Integer[] getIntegerArray(int range) {

        //initialize
        generator = new Random();
        array = new ArrayList<Integer>();

        for (int i = 0; i < range; i++) {
            //add random number to array
            array.add(generator.nextInt(range));
        }

        // print unsorted array
        System.out.println("Unsorted array");
        System.out.println(array);

        // create new integer with equal size to list
        Integer[] number_array = new Integer[array.size()];

        // input all value from list to integer
        for (int i = 0; i < array.size(); i++) {
            number_array[i] = array.get(i);
        }
        return number_array;
    }
}
