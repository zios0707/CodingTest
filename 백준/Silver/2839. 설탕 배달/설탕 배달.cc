#include <stdio.h>

int main() {
	int n, count = 0;
	scanf("%d", &n);
	
	while (n != 0) {
		if (n % 3 == 0 && n % 5 != 0){
			n -= 3;
			count++;
		}
		else if (n >= 5) {
			n -= 5;
			count++;
		}
		else if (n == 3) {
			n = 0;
			count++;
		}
		else if (n == 1 || n == 2 || n == 4) {
			count = -1;
			break;
		}
	}
	printf("%d", count);
}