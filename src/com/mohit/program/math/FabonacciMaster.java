package com.mohit.program.math;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Mohit Soni on 15-05-2018.
 */
public class FabonacciMaster {

    Scanner sc;

    public FabonacciMaster() {
        sc = new Scanner(System.in);
        System.out.println("Enter a number ");
        int f = sc.nextInt();
        System.out.println("Enter count ");
        int c = sc.nextInt();

        fabonacci(BigInteger.valueOf(f), c);
    }

    /**
     * give position value till 44 loop, because of {@link Integer} limit (-2147483648 - 2147483647)
     *
     * @param n
     * @param count
     */
    public void fabonacci(int n, int count) {
        ArrayList<Integer> value = new ArrayList<Integer>();
        value.add(0);
        value.add(n);
        int sum = 0 + n;
        for (int i = 0; i < count; i++) {
            value.add(sum);
            int pre = value.get(i + 1);
            int post = value.get(i + 2);
            sum = pre + post;
        }
        System.out.println(value);
    }

    /**
     * always give positive value ..
     *
     * @param n
     * @param count
     */
    public static void fabonacci(BigInteger n, int count) {
        ArrayList<String> value = new ArrayList<String>();

        // add fist and second element to array
        value.add(0 + "");
        value.add(n + "");
        BigInteger zero = BigInteger.valueOf(0);
        BigInteger sum = zero.add(n);

        // get time before process
        long t1 = System.currentTimeMillis();
        System.out.println("previous time : " + t1 + " mis");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < count - 2; i++) {
            value.add(sum + "");
            // pre-value
            BigInteger pre = new BigInteger(value.get(i + 1));
            //post-value
            BigInteger post = new BigInteger(value.get(i + 2));

            sum = pre.add(post);
        }

        // get time after process
        long t2 = System.currentTimeMillis();

        System.out.println(value);
        System.out.println("--------------------------------------------------");
        System.out.println("post time : " + t2 + " mis");

        // evaluate time
        long time = t2 - t1;
        System.out.println("Time eclapsed to evaluate : " + time + " mis");
    }
}
