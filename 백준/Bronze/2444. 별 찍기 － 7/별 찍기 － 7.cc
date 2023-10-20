#include <stdio.h>

int main(void)
{
    int i, j, n, m;
    m = 0;
    scanf("%d", &n);
    for (i = 0; i <= n - 1; i++)
    {
        for (j = 0; j <= n - 2 - i; j++)
        {
            printf(" ");
        }
        for (m = 1; m <= 1 + (i * 2); m++)
        {
            printf("*");
        }
        printf("\n");
    }
    for (i = n - 2; i >= 0; i--)
    {
        for (j = 0; j <= n - 2 - i; j++)
        {
            printf(" ");
        }
        for (m = 1; m <= 1 + (i * 2); m++)
        {
            printf("*");
        }
        printf("\n");
    }
    return 0;
}