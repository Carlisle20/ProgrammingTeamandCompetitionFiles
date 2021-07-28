/**
* Practice Set: Problem Solving.
* Written By: Carlisle Calabrese.
* Problem: Hurdle Race.
* Language Used: Java.
* Time to Solve: About 3 Hours.
* Solved: 3/15/2018.
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

    // Complete the hurdleRace function below.
    static int hurdleRace(int k, int[] height) {
        int lrg = 0;
        int hl = 0;
        int l = 0;
        
        for (int i = 0; i < height.length; i++) {
            l = height[i];
            for (int j = 0; j < height.length; j++) {
                if (l > height[j] && l > hl) {
                    lrg = l;
                }
            }
            hl = lrg;
        }
        int d = lrg - k;
        
        if (d <= 0) {
            d = 0;
        }
        return d;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] height = new int[n];

        String[] heightItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int heightItem = Integer.parseInt(heightItems[i]);
            height[i] = heightItem;
        }

        int result = hurdleRace(k, height);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
