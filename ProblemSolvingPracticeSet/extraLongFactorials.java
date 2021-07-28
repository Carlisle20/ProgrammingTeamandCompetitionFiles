/**
* Practice Set: Problem Solving.
* Written By: Carlisle Calabrese.
* Problem: Extra Long Factorials.
* Language Used: Java.
* Time to Solve: About 2 Days.
* Solved: 4/17/2017.
* Last Modified: 7/28/2021.
*
*
**/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
        BigInteger t = BigInteger.valueOf(1);
        
        int a = 1;
        long[] factor = new long[n];
        
        for (int i = 0; i < n; i++) {
            factor[i] = n - i;
        }
        
        for (int i = 0; i < n; i++) {
            t = t.multiply(BigInteger.valueOf(factor[i]));
        }
        System.out.println(t);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
