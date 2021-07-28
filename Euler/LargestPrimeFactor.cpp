/**
* Competition: Project Euler.
* Written By: Carlisle Calabrese.
* Problem: #3 - Largest Prime Factor.
* Language Used: C++, Initially Used Java but had to Switch to C++ Due to Timeout Issue.
* Time to Solve: 2 Hours.
* Solved: 4/27/2021.
* Last Modified: 7/28/2021.
*
*
**/


#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <unordered_map>
#include<bits/stdc++.h>

using namespace std;

int main() {
    
    int t;
    cin>>t;
    
    while(t != 0){
        
        long long n;
        
        cin>>n;
        
        long long div = 2LL;
        
        while(div<=floor(sqrt(n))){
            if(n%div==0LL){
                n  /= div;
            }else{
                div++;
            }
        }
        
        cout<<n<<endl;
        
        t--;
    }
    
    return 0;
}
