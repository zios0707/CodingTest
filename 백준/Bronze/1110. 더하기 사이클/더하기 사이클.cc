#include <stdio.h>

int main() {
	int n,k,i = 0;
	scanf("%d", &n);
	k = n;
	do {
		n = ((n % 10) * 10) + ((n % 10 + n / 10) % 10);
		i++;
	} while (n != k);
	printf("%d", i);
}