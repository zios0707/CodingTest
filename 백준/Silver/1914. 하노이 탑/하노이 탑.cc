#include <stdio.h>
	
void hanoi(int n, int a, int b, int c) {
	if (n == 1) printf("%d %d\n", a, b);
	else {
		hanoi(n - 1, a, c, b);
		printf("%d %d\n", a, b);
		hanoi(n - 1, c, b, a);
	}
}

int main() {
	unsigned long long ten = 1;
	int a;
	unsigned long long val = 1;
	unsigned long long val2 = 0;
	scanf("%d", &a);
	for (int i = 0; i < a; i++) {
		if (val > 500000000000000000) {
			val2 += val % 10 * ten;
			val /= 10;
			val *= 2;
			ten *= 10;
		}
		else {
			val *= 2;
		}
		val2 *= 2;
		if (val2 >= ten) {
			val += val2 / ten;
			val2 %= ten;
		}
	}
	if (val2 != 0) {
		printf("%lld", val);
		printf("%lld\n", val2 - 1);
	}
	else printf("%lld\n", val - 1);
	
	if (a <= 20) {
		hanoi(a, 1, 3, 2);
	}
}