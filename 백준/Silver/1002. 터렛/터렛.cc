#include <stdio.h>
#include <math.h>

struct loc
{
    int x;
    int y;
    int r;
};

int main()
{
    int i, sr, br, loc, n, token, sumr;
    double dist;
    // loc이 1인 경우 에는 두 점으로 만남.
    // 2의 경우 에는 한 점에서 만남.
    // 3의 경우 에는 원이 서로 만나지 않음.
    // 4의 경우 에는 겹침.
    struct loc l1;
    struct loc l2;
    struct loc ab;
        
    scanf("%d", &n);
    for (i = 0; i < n; i++)
    {
        scanf("%d %d %d %d %d %d", &l1.x, &l1.y, &l1.r, &l2.x, &l2.y, &l2.r);
        ab.x = abs(l1.x - l2.x); // 서로의 x의 거리
        ab.y = abs(l1.y - l2.y); // 서로의 y의 거리
        ab.r = abs(l1.r - l2.r); // 반지름의 차
        sumr = l1.r + l2.r; // 반지름의 합
        dist = sqrt(pow(ab.x, 2) + pow(ab.y, 2)); // 서로의 거리
        sr = (l1.r < l2.r) ? l1.r : l2.r;
        br = (l1.r > l2.r) ? l1.r : l2.r;
        
        if (dist == 0){
            loc = 4;
        }
        else if (sumr < dist) {
            loc = 3;
        }
        else if (sumr == dist) {
            loc = 2;
        }
        else if (sumr > dist) {
            loc = 1;
        }

        if (loc == 3) {
            token = 0;
        }
        else if (loc == 4 && l1.r == l2.r) {
            token = -1;
        }
        else if (loc == 4) {
            token = 0;
        }
        else if (loc == 2) {
            token = 1;
        }
        else if ((dist + sr) < br) {
            token = 0;
        }
        else if ((dist + sr) == br) {
            token = 1;
        }
        else if ((dist + sr) > br){
            token = 2;
        }
            


        printf("%d\n", token); // 조건 여부 결과 배출
    }
}