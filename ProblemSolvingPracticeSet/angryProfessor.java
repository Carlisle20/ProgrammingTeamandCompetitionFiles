/**
* Practice Set: Problem Solving.
* Written By: Carlisle Calabrese.
* Problem: Angry Professor.
* Language Used: Java.
* Time to Solve: About 2 Days.
* Solved: 5/1/2018.
* Last Modified: 7/28/2021.
*
*
**/


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        
        testCases: 
        for(int i = 0; i < T; i++)
        {
            int n = input.nextInt();
            int k = input.nextInt();
            int onTime = 0;
            for(int j = 0; j < n; j++)
            {
                int arrivalTime = input.nextInt();
                if(arrivalTime <= 0)
                {
                    onTime++;
                }
            }
            if(onTime >= k)
            {
                System.out.println("NO");
            }
            else
            {
                System.out.println("YES");   
            }
        }
    }
}
