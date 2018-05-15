package com.mohit.program.math;

import java.util.Scanner;

/**
 * Created by Mohit Soni on 15-05-2018.
 */
public class Exchange_Without_Variable {

    Scanner sc;

    public Exchange_Without_Variable() {


        // get input from user
        sc = new Scanner(System.in);
        System.out.println("Enter first number ");
        int f = sc.nextInt();
        System.out.println("Enter second number ");
        int s = sc.nextInt();

        interchange(f, s);
    }

    /**
     * interchange
     *
     * @param first
     * @param second
     */
    public static void interchange(int first, int second) {
        System.out.println("input : " + first + " : " + second);

        // get value works as third variable
        first = second - first;

        // set first variable value to second by calculation
        second = second - first;

        // finally get value for first variable from second
        first = second + first;

        System.out.println("ouput : " + first + " : " + second);
    }
}
