/**
* Practice Set: Problem Solving.
* Written By: Carlisle Calabrese.
* Problem: Mini-Max Sum.
* Language Used: Java.
* Time to Solve: About 2 Days.
* Solved: 2/24/2017.
* Last Modified: 7/28/2021.
*
*
**/



import java.util.Scanner;

public class MiniMax {
	private static int iterationSums = 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inString = scanner.nextLine();
		String[] tString = inString.split(" ");
		long[] t = new long[tString.length];
		long[] sums = new long[tString.length];
		for (int i = 0; i < tString.length; i++) {
			t[i] = Long.parseLong(tString[i]);
		}
		int similar = 0;
		boolean nonRemoved = false;
		for (int i = 0; i < t.length; i++) {
			long firstNumber = t[0];
			if (firstNumber == t[i]) {
				similar ++;
			}
		}
		if (similar == t.length) {
			nonRemoved = true;
		} else if (similar != t.length) {
			nonRemoved = false;
		}
		for (int i = 0; i < t.length; i++) {
			long iteration = t[i];
			long addition = 0;
			if (nonRemoved == false) {
				for (int j = 0; j < t.length; j++) {
					if (t[j] != iteration) {
						addition += t[j];
					}
				}
			} else if (nonRemoved == true) {
				for (int j = 0; j < t.length; j++) {
					addition += t[j];
				}
				addition = addition - iteration;
			}
			sums[i] = addition;
		

		}

		long min = 0;
		long max = 0;
		for (int i = 0; i < sums.length; i++) {


			long j = sums[i];
			int less = 0;
			int more = 0;
			long comp = 0;
			for (int k = 0; k < sums.length; k++) {
				if (sums[k] != j) {
					comp = sums[k];
				} else if (j == sums[0] && sums[0 + 1] != sums[0]) {
					comp = sums[k + 1];
				}
				if (j < comp) {
					less ++;
				} else if (j > comp) {
					more++;
				}

				if (less == sums.length) {
					min = j;
				} else if (more == sums.length) {
					max = j;
				}


			}
			iterationSums ++;


		}
		
		if (iterationSums == sums.length && min == 0 && (max != 0 || max == 0)) {
			max = sums[sums.length - 1];
			min = sums[0];
		}

		String printString = "";

		printString += min;
		printString += " ";
		printString += max;

		System.out.println(printString);
	}
}