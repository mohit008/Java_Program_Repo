package com.mohit.program.topic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Mohit Soni on 15-05-2018.
 */
public class ReverseString {

    static Scanner sc;

    public ReverseString() {

        //get string input from user
        sc = new Scanner(System.in);
        System.out.println("Enter a string ");
        String str = sc.nextLine();

        reverse(str);
    }

    public static void reverse(String str) {

        //get system time before process
        long t1 = System.currentTimeMillis();
        System.out.println("pre time : " + t1 + " mis");

        // initialize variable
        int init = 1;
        ArrayList<String> list = new ArrayList<String>();


        String result = "";

        //get string character of every index and add to list (0-1,1-2,2-3...)
        for (int i = 0; i < str.length(); i++) {
            list.add(str.substring(i, init));
            init++;
        }

        //get size of list
        int size = list.size();

        // get character from list in REVERSE order and save in string (decrement loop)
        for (int j = 0; j < list.size(); j++) {
            result = result.concat(list.get(size - 1));
            size--;
        }

        //get system time after process
        long t2 = System.currentTimeMillis();


        System.out.println("input : " + str);
        System.out.println("reversed string : " + result);

        System.out.println("--------------------------------------------------");
        System.out.println("post time : " + t2 + " mis");

        // evaluate time
        long time = t2 - t1;
        System.out.println("Time eclapsed to evaluate : " + time + " mis");
    }
}
