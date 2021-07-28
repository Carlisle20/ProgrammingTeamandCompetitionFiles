/**
* Competition: Project Euler.
* Written By: Carlisle Calabrese.
* Problem: #230 - Fibonacci Words.
* Language Used: C#.
* Time to Solve: About 1 Hour.
* Solved: 5/3/2021.
* Last Modified: 7/28/2021.
*
*
**/

using System;
using System.Collections.Generic;
using System.IO;
using System.Numerics;
class Solution {
    static void Main(String[] args) {
        var a = int.Parse(Console.ReadLine());
        for (var i = 1; i <= a; i++)
        {
            var input = Console.ReadLine().Trim().Split(' ');
            var n = BigInteger.Parse(input[2]);
            var queue = new BigInteger[3];
            var in1 = input[0];
            var in2 = input[1];
            var ln1 = (BigInteger)in1.Length;
            var ln2 = (BigInteger)in2.Length;
            var track = new List<BigInteger>();
            track.Add(ln1);
            track.Add(ln2);
            var temp = ln1 + ln2;
            var j = 1;
            do{
                temp = track[j-1]+track[j];
                track.Add(temp);
                j++;
            }while(temp < n);
            var pos = track.Count-1;
            var current = track[pos];
            while(pos > 1){
                if(n > track[pos-2]){
                    current = track[pos-1];
                    n -= track[pos-2];
                    pos-=1;
                }else{
                    current = track[pos-2];
                    pos -=2;
                }
            }
            Console.WriteLine(pos==0 ? in1[(int)n-1] : in2[(int)n-1]);
        }
    }
}
