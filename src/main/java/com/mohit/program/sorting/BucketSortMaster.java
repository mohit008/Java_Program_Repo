package com.mohit.program.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Mohit Soni on 15-05-2018.
 */
public class BucketSortMaster {

    static int big_num = 0;
    static int pivot = 1;
    Integer[] number_array = {17, 29, 25, 3, 4927, 38, 19, 35, 404, 8594};

    public BucketSortMaster() {

        // time before process
        long t1 = System.currentTimeMillis();

        getSortedArray(number_array);

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
     * Method to return sorted array
     */
    public static void getSortedArray(Integer[] number_array) {

        /**
         *  Get the biggest number by iteration over array and
         * finding 10 power to it so we can find how much big array
         * we have to make
         */
        for (int i = 0; i < number_array.length; i++) {
            if (number_array[i] > number_array[pivot]) {
                if (number_array[i] > big_num) {
                    big_num = number_array[i];
                }
            }
            if (pivot < number_array.length) {
                pivot = pivot + 1;
            }
            if (pivot == number_array.length) {
                pivot = i;
            }
        }

        // get biggest number
        String big_num_length = big_num + "";

        // get 10 power to number of digit of biggest number
        int tens = (int) Math.pow(10, big_num_length.length());
        System.out.println(tens + "");

        // generate full array from 0 to ten power (0-999)
        int[] main_array = new int[tens];
        for (int i = 0; i < tens; i++) {
            main_array[i] = i;
        }
        System.out.println(Arrays.toString(main_array));

        /**
         *  Create Buckets of array according to value in input array
         * and mapping then to integer
         */

        // every array contain only 0-10 element
        int from = 0;
        int to = 10;

        // hash map to map array with integer
        HashMap<Integer, Integer[]> map = new HashMap<>();

        // increment for 10 every time for loop
        for (int i = 0; i < tens; i += 10) {

            // make bucket arrays of length 10
            Integer[] bucket_array = new Integer[10];

            // insert every value to array from index 0-9 for 0-tens
            for (int j = from; j < to; j++) {
                bucket_array[j % 10] = j;
            }

            // map array with key (1,2,3...)
            map.put(i, bucket_array);
            System.out.println(Arrays.toString(bucket_array));

            // increment by 10
            from = from + 10;
            to = to + 10;
        }

        /**
         *  Finding pivot/index value from input array in Bucket arrays
         * created in previous section and replacing then with 0
         */

        // make array to length 10
        Integer check_current[] = new Integer[10];

        // new map to get array sorted arrays
        HashMap<Integer, Integer[]> new_map = new HashMap<>();

        // iterate over input array length
        for (int i = 0; i < number_array.length; i++) {

            // set pivot to input array index
            pivot = number_array[i];
            for (int j = 0; j < map.size(); j++) {

                // get array from map key
                check_current = map.get(j * 10);

                // check if current pivot is between first and last value of array
                if (pivot <= check_current[9] || pivot > check_current[0]) {

                    // iterate over desired array and find which value is equal to pivot
                    for (int z = 0; z < check_current.length; z++) {
                        if (pivot == check_current[z]) {

                            // replace the value with 0 if equal to pivot
                            check_current[z] = 0;

                            // map new array to hashmap
                            new_map.put(j, check_current);
                            System.out.println(Arrays.toString(new_map.get(j)));
                            break;
                        }
                    }
                }

                // do nothing if pivot is greater then last value of array
                if (pivot > check_current[9]) {
                }
            }
        }


        /**
         *  Scanning all array in map and removing the duplicate one by
         * comparing there array first index value to next
         */

        // get first number of current array
        Integer chk_first_num_new = 0;

        // get first number of last array scanned
        Integer chk_first_num_old = 1;
        Integer map_array[] = new Integer[10];

        // set gets all key from hash map
        Set<Integer> first_index_array = new_map.keySet();

        // make an array of keys
        Integer[] index_value_array = first_index_array.toArray(new Integer[first_index_array.size()]);

        // sorting set array in increment order
        Integer pivot_to_sort_set = 0;
        int temp_set_value = 0;
        for (int i = 0; i < index_value_array.length; i++) {

            // set pivot to check number
            pivot_to_sort_set = index_value_array[i];

            // decrement loop
            for (int j = index_value_array.length - 1; j > i; j--) {

                // replace value if greater
                if (pivot_to_sort_set > index_value_array[j]) {
                    temp_set_value = index_value_array[j];
                    index_value_array[j] = pivot_to_sort_set;
                    index_value_array[i] = temp_set_value;
                    pivot_to_sort_set = index_value_array[i];
                }
            }
        }

        // iterate over keys
        for (int i = 0; i < index_value_array.length; i++) {

            // get current array associated with current key
            map_array = new_map.get(index_value_array[i]);

            // get its first value
            chk_first_num_new = map_array[0];

            // check if current value to same as value of previous array first value
            if (chk_first_num_new == chk_first_num_old) {

                // remove that key from map
                new_map.remove(index_value_array[i]);
            }
            chk_first_num_old = chk_first_num_new;
            System.out.println(Arrays.toString(new_map.get(index_value_array[i])));
        }

        /**
         *  Finally generating sorting array from all array
         * we have hash map
         */

        // first number of array
        Integer first_num_array = 0;

        // pre-final array to update
        Integer final_pre_array[] = new Integer[10];

        // final array to sorted value
        Integer final_array[] = new Integer[number_array.length + 1];

        // set pivot to 0 for setting value in final array
        pivot = 0;
        for (int i = 0; i < index_value_array.length; i++) {

            // get array of associate to current key
            final_pre_array = new_map.get(index_value_array[i]);

            // get first number of array
            first_num_array = final_pre_array[0];
            for (int j = 0; j < final_pre_array.length; j++) {

                // find where 0 is present in array
                if (final_pre_array[j] == 0) {

                    // index where 0 is present is added to first value of array in inserted to final array
                    final_array[pivot] = first_num_array + j;

                    // set to next index
                    pivot = pivot + 1;
                }
            }
            System.out.println(Arrays.toString(new_map.get(index_value_array[i])));
        }
        System.out.println(Arrays.toString(final_array));

    }
}
