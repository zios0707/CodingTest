#include <stdio.h>


int main() {
	int m = 0, n, s = 0, o = 0, pr = 0,mins = 1000, mino = 1000;
	scanf("%d %d", &m, &n);
	for (int i = 0; i < n; i++) {
		scanf("%d %d", &s, &o);
		if (mins > s) {
			mins = s;
		}
		if (mino > o) {
			mino = o;
		}
	}
	if ((mino * 6) < mins) {
		mins = (mino * 6);
	}
	while (m != 0) {
		if (m >= 6 || mino * m > mins) {
			m -= 6;
			if (m < 0) {
				m = 0;
			}
			pr += mins;
		}
		else {
			m--;
			pr += mino;
		}
	}
	printf("%d", pr);
} 