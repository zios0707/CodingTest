#include <stdio.h>

int main() {
	int n, m;
	scanf("%d %d", &n, &m);
	
	if (m < 45) {
		if (n <= 0) {
			n = 23;
			m += 15;
		}
		else {
			n--;
			m += 15;
		}
	}
	else {
		m -= 45;
	}
	printf("%d %d", n, m);
	
}