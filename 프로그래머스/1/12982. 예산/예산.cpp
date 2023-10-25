#include <iostream>
#include <stdio.h>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int solution(vector<int> d, int budget) {
    int count = 0, sum = 0;
    sort(d.begin(), d.end());
    for(int i = 0; i < d.size(); i++) {
        sum += d[i];
        if(sum > budget) break;
        count++;
    }
    return count;
}