package com.mohit.program.math;

import java.util.Scanner;

/**
 * Created by Mohit Soni on 15-05-2018.
 */
public class PrimeMaster {

    static Scanner sc;
    static String result = "";
    static int prime_count = 0;
    static int non_prime_count = 0;

    public PrimeMaster() {
        getPrimefromRange();
    }

    /**
     * calculate if given number is prime or not
     */
    public static void findIFnumberIsPrime() {
        sc = new Scanner(System.in);
        System.out.println("Enter a number ");
        int number = sc.nextInt();

        if (number > 1) {
            for (int i = 1; i < number - 1; i++) {
                int j = i + 1;
                if (number % j != 0) {
                    result = "Number is prime";
                }
                if (number % j == 0) {
                    result = "Number is not prime";
                    break;
                }
            }
        }
        System.out.println(result);
    }

    /**
     * Get all prime and non prime number from given range
     */
    public static void getPrimefromRange() {

        sc = new Scanner(System.in);
        System.out.println("Enter a start number ");
        int start = sc.nextInt();
        System.out.println("Enter a end number ");
        int end = sc.nextInt();

        long t1 = System.currentTimeMillis();

        if (start > 1) {
            for (int s = start; s < end; s++) {
                for (int i = 1; i < s - 1; i++) {
                    int j = i + 1;
                    if (s % j != 0) {
                        result = "Number is prime";
                    }
                    if (s % j == 0) {
                        result = "Number is not prime";
                        break;
                    }
                }
                if (result.equals("Number is prime")) {
                    prime_count++;
                }
                if (result.equals("Number is not prime")) {
                    non_prime_count++;
                }
                System.out.println(s + ":" + result);
            }

            long t2 = System.currentTimeMillis();

            System.out.println("pre time : " + t1 + " mis");
            System.out.println("--------------------------------------------------");
            System.out.println("post time : " + t2 + " mis");
            System.out.println("--------------------------------------------------");
            System.out.println("prime number found : " + prime_count);
            System.out.println("--------------------------------------------------");
            System.out.println("non prime number found : " + non_prime_count);
            System.out.println("--------------------------------------------------");

            // evaluate time
            long time = t2 - t1;
            System.out.println("Time eclapsed to evaluate : " + time + " mis");
            System.out.println("--------------------------------------------------");

        }
        if (start == 1 || end == 1) {
            System.out.println("1 is a prime number");
            System.out.println("--------------------------------------------------");
        }
        if (start == 2 || end == 2) {
            System.out.println("2 is a prime number");
            System.out.println("--------------------------------------------------");
        }
        if (start < 1 || end < 1 || start == end) {
            System.out.println("No valid range");
            System.out.println("--------------------------------------------------");
        }
    }
    public void betweenRange() {
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();
        int end = sc.nextInt();
        boolean result = false;
        int prime_count =0;

        if (line > 0) {
            if (line == 1 || line == 2) {
                prime_count = +1;
                line = 3;
            }
            for (int s = line; s < end; s++) {
                for (int i = 1; i < s - 1; i++) {
                    int j = i+1;
                    if (s % j != 0) {
                        result = true;
                        continue;
                    }
                    if (s % j == 0) {
                        result =false;
                        break;
                    }
                }
                if (result) {
                    prime_count++;
                }
            }
        }
        System.out.println(prime_count);
    }
}
