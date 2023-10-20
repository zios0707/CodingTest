#include <stdio.h>

int main() {
    int	arr[10];
    int n, k, count = 0;
    scanf("%d %d", &n, &k);
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    while (k != 0) {
        for (int i = n-1; i >= 0; i--) {
            if (k / arr[i] >= 1 &&
               arr[i] != -1) {
                k -= arr[i];
                count++;
                break;
            }
        }
    }
    printf("%d", count);
}