package com.mohit.program.math;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Mohit Soni on 15-05-2018.
 */
public class FactorialMaster {

    static Scanner sc;

    public FactorialMaster() {

        System.out.println("Enter a number");
        sc = new Scanner(System.in);
        int number = sc.nextInt();

        long t1 = System.currentTimeMillis();

        fact(number);

        // get time after process
        long t2 = System.currentTimeMillis();

        // evaluate time
        long time = t2 - t1;
        System.out.println("--------------------------------------------------");
        System.out.println("post time : " + t2 + " mis");
        System.out.println("Time eclapsed to evaluate : " + time + " mis");
    }

    /**
     * give result till value 33 then after 0 ..
     *
     * @param num
     */
    public static void fact(int num) {
        int initial = 1;
        while (num > 1) {
            initial = initial * num;
            num--;
        }
        System.out.println(initial + "");
    }

    /**
     * always give positive value ..
     *
     * @param num
     */
    public static void factBig(int num) {
        BigInteger initial = BigInteger.valueOf(1);
        BigInteger s;

        for (int i = num; i > 1; i--) {
            s = new BigInteger(num + "");
            initial = initial.multiply(s);
            s.subtract(BigInteger.valueOf(1));
            num--;
        }
        System.out.println(initial + "");
    }
}
