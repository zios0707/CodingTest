#include <stdio.h>
long long Z[41] = { 0 };
long long O[41] = { 0 };
	

int calZ(int n) {

	if (Z[n] != 0) return Z[n];
	if (n == 0) return 1;
	else if (n == 1) return 0;
	else {
		Z[n] = calZ(n - 1) + calZ(n - 2);
		return Z[n];
	}

}
int calO(int n) {

	if (O[n] != 0) return O[n];
	if (n == 0) return 0;
	else if (n == 1) return 1;
	else {
		O[n] = calO(n - 1) + calO(n - 2);
		return O[n];
	}

}

int main() {
	int idx;
	scanf("%d", &idx);
	for (int i = 0; i < idx; i++) {
		int m;
		scanf("%d", &m);
		printf("%d %d\n", calZ(m), calO(m));
	}

}