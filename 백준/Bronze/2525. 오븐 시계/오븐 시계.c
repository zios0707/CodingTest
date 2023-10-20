#include <stdio.h>

int main() {
	int n, m, t, th, tm;
	scanf("%d %d %d", &n, &m, &t);

	th = t / 60;
	tm = t % 60;
	if (m + tm >= 60) {
		n += 1;
		m -= 60;
		if (n + th >= 24) {
			n -= 24;
		}
	}
	else {
		if (n + th >= 24) {
			n -= 24;
		}
	}
	m += tm;
	n += th;
	printf("%d %d", n, m);

}