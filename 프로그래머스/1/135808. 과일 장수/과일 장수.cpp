#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int k, int m, vector<int> score) {
    int answer = 0, cnt = 0, low = 10;
    int l = score.size();
    sort(score.begin(), score.end(), greater<int>());
    
    for(int i = 0; i < score.size()/m; i++) {
        for(int j = 0; j < m; j++) {
            if(low > score[cnt]) {
                low = score[cnt];
            }
            cnt++;
        }
        answer += low * m;
        low = 10;
    }
    return answer;
}