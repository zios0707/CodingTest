#include <stdio.h>
#include <stdlib.h>

int main() {

    int i, j, k, n, m = 0;
    int* arr;
    int* oparr;
    scanf("%d %d", &n, &k);
    arr = (int*)malloc((n + 1) * sizeof(int));
    oparr = (int *)malloc((n + 1) * sizeof(int));
    for (i = 1; i < n + 1; i++) {
        arr[i] = i;
    }
    for (i = 1; i < n + 1; i++) {
        m = (m + k - 1) % (n - i + 1);
        oparr[i] = arr[m + 1];
        for (j = m + 1; j < n; j++) {
            arr[j] = arr[j + 1];
        }
    }
    printf("<");
    for (i = 1; i <= n; i++) {
        printf("%d", oparr[i]);
        if (i < n) {
            printf(", ");
        }
    }
    printf(">");

    free(arr);
    free(oparr);
    return 0;
}