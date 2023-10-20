#include <stdio.h>

int main()
{
    float arr[1001] = { 0 };
    float scor, count = 0;
    int i, j, n, m = 0;
    scanf("%d", &n);
    for (i = 1; i <= n; i++)
    {
        scanf("%d", &m);
        for (j = 0; j < m; j++)
        {
            scanf("%f", &scor);
            arr[j] = scor;
        }
        scor = 0;
        for (j = 0; j < m; j++)
        {
            scor += arr[j];
        }
        scor /= m;
        count = 0;
        for (j = 0; j < m; j++)
        {
            if (scor < arr[j])
            {
                count++;
            }
        }
        printf("%.3f%%\n", (count / (float)m) * 100);
    }
    return 0;
}