#include <string>
#include <vector>
#include <queue>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    queue<int> pr;
    queue<int> sp;
    int j = 1, count = 0;
    
    int psiz = progresses.size();
    for (int i = 0; i < psiz; i++) {
        pr.push(progresses[i]);
        printf("%d ", progresses[i]);
    }
        printf("\n");
    for (int i = 0; i < psiz; i++) {
        sp.push(speeds[i]);
        
        printf("%d ", speeds[i]);
    }
        printf("\n");
    while(1) {
        printf("| %d | %d + %d = %d", j, pr.front(), sp.front()*j, pr.front() + sp.front()*j);
        if (pr.front() > 99 || sp.front() > 99) {
            pr.pop();
            sp.pop();
        }
        else if((pr.front() + (sp.front() * j)) >= 100) {
            count++;
            pr.pop();
            sp.pop();
            continue;
        }else if(count > 0) {
            answer.push_back(count);
            printf(" %d", count);
            count = 0;
        }else if(pr.empty() || sp.empty()) break;
        else if(j > 99) break;
        j++;
        printf("\n");
    }
    return answer;
}