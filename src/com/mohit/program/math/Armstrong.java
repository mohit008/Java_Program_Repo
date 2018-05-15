package com.mohit.program.math;

import java.util.Scanner;

/**
 * Created by Mohit Soni on 15-05-2018.
 */
public class Armstrong {

    Scanner sc;
    int numbercount = 0;
    int notnumbercount = 0;

    public Armstrong() {
        sc = new Scanner(System.in);
        System.out.println("Enter a number ");
        int start = sc.nextInt();
        System.out.println("Enter count ");
        int end = sc.nextInt();

        long t1 = System.currentTimeMillis();
        System.out.println("pre time : " + t1 + " mis");

        for (int i = start; i < end; i++) {

            if (checkArmstrongNumber(i)) {
                numbercount++;
                System.out.println(i + " is Armstrong number");
            }
            if (!checkArmstrongNumber(i)) {
                System.out.println(i + " is not Armstrong number");
                notnumbercount++;
            }
        }
        long t2 = System.currentTimeMillis();

        System.out.println("--------------------------------------------------");
        System.out.println("post time : " + t2 + " mis");

        System.out.println("Armstrong number found : " + numbercount);
        System.out.println("Non - Armstrong number found : " + notnumbercount);

        // evaluate time
        long time = t2 - t1;
        System.out.println("Time eclapsed to evaluate : " + time + " mis");
    }

    /**
     * put it !!
     *
     * @param number
     * @return
     */
    public static boolean checkArmstrongNumber(int number) {

        boolean status = false;

        int i = 1;
        int evaluatenotzero = 1;
        int count = -1;

        while (evaluatenotzero > 0) {
            evaluatenotzero = number / i;
            i = i * 10;
            count++;
        }

        int power = (int) Math.pow(10, count - 1);
        int init = number;
        int sum = 0;
        for (int j = 0; j < count; j++) {
            int pre = init / power;
            int post = init % power;
            init = post;
            System.out.println(pre);
            power = power / 10;

            sum = sum + (int) Math.pow(pre, count);
            System.out.println(sum);
        }
        if (sum == number) {
            status = true;
        }
        return status;
    }
}
