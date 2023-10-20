#include <stdio.h>

int main() {
	long long int a, b, c, flex, count = 0, val = 0;
	int token = 0;
	scanf("%lld %lld %lld", &a, &b, &c);
	if (a > 0 && b >= c) {
		token = 1;
	}
	flex = c - b;
	count = a / flex + 1;



	if (token == 1) {
		printf("-1");
	}
	else {
		printf("%d", count);
	}
}