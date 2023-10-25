#include <string>
#include <iostream>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    int s_len = s.size();
    int st = 0;
    for(int i = 0; i < s_len; i++) {
        if(s[i] == '(') {
            st++;
        }else if(s[i] == ')') {
            st--;
        }
        if(st < 0) {
            break;
        }
    }
    if(st == 0) {
        answer = true;
    }else {
        answer = false;
    }
    return answer;
}