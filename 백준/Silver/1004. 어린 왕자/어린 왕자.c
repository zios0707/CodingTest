#include <stdio.h>
#include <stdlib.h>
#include <math.h>

struct planet {
	int x;
	int y;
	int r;
};

int acc(int sx, int sy, int ex, int ey) {
	int n, count = 0;
	scanf("%d", &n);
	struct planet* planets = (struct planet*)malloc(n * sizeof(struct planet));
	for (int i = 0; i < n; i++) {
		scanf("%d %d %d", &(planets[i].x), &(planets[i].y), &(planets[i].r));
	
		if (pow(sx - planets[i].x, 2) + pow(sy - planets[i].y, 2) <= pow(planets[i].r, 2) &&
			pow(ex - planets[i].x, 2) + pow(ey - planets[i].y, 2) <= pow(planets[i].r, 2)) {

		}
		else if (pow(sx - planets[i].x, 2) + pow(sy - planets[i].y, 2) <= pow(planets[i].r, 2) ||
			     pow(ex - planets[i].x, 2) + pow(ey - planets[i].y, 2) <= pow(planets[i].r, 2)) {
			count++;
		}
	}
	
	return count;
	
}

int main() {
	int n;
	int x, y, x1, y1;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d %d %d %d", &x, &y, &x1, &y1);
		printf("%d\n", acc(x, y, x1, y1));
	}
}