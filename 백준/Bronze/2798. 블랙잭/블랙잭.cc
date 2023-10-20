#include <stdio.h>

int main () {
	int n, m;
	scanf("%d %d", &n, &m);

	int num[100];
	int sum, max = 0;
	int i, j, k;

	for (i = 0; i < n; i++) {
		scanf("%d", &num[i]);
	}
	
	for (i = 0; i < n; i++) {
		for (j = i + 1; j < n; j++) {
			for (k = j + 1; k < n; k++) {
				sum = num[i] + num[j] + num[k];
					if (sum > max && sum <= m)
						max = sum;

			}
		}
	}

	printf("%d\n", max);
	return 0;
}
