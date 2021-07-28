/**
* Competition: Project Euler.
* Written By: Carlisle Calabrese.
* Problem: #2 - Even Fibonacci Numbers.
* Language Used: Java.
* Time to Solve: About 4 Hours.
* Solved: 5/2/2021.
* Last Modified: 7/28/2021.
*
*
**/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            
            System.out.println(findSum(n));
            
        }
        
    }
    
    
    public static long findSum(long input) {
        long first = 0;
        long second = 1;
        long sum = 0;
        long sumeven =0;

        while(second <= input){
            sum = first+second;
            first = second;
            second = sum; 
            if(sum%2==0 && sum<input){
                sumeven += sum;
            }
        }
        return sumeven;
    }
}