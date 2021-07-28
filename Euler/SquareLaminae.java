/**
* Competition: Project Euler.
* Written By: Carlisle Calabrese.
* Problem: #174 - Square Laminae.
* Language Used: Java.
* Time to Solve: About 3 Hours.
* Solved: 5/6/2021.
* Last Modified: 7/28/2021.
*
*
**/




import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) throws Exception {
    final int[] s = new int[250_001];
    for (int h = 1; h < 501; h++)
      for (int p = h * h + h; p < s.length; p += h)
        s[p]++;

    for (int i = 2, sum = 0; i < s.length; i++)
      s[i] = sum += s[i] <= 10 ? 1 : 0;

    try (Scanner in = new Scanner(new BufferedInputStream(System.in))) {
      try (PrintStream out = new PrintStream(new BufferedOutputStream(System.out))) {
        for (int T = in.nextInt(); T > 0; T--)
          out.println(s[in.nextInt() >> 2]);
      }
    }
  }
}
