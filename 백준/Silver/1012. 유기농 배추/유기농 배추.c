#include <stdio.h>

int arr[51][51] = { 0 };

int two(int x, int y, int hx) {
	for (int i = x; (i > 0 || arr[i - 1][y] != 0); i--) { // 왼쪽으로 가며 끝 날때 까지 확인
		if (arr[i][y] == 0) {
			break;
		}
		else if (arr[i][y - 1] == 1 || arr[i][y + 1] == 1) {
			arr[i][y] = 3;
		}
		else {
			arr[i][y] = 9;
		}
	}

	for (int i = x; (i <= hx || arr[i + 1][y] != 0); i++) {
		if (arr[i][y] == 0) {
			break;
		}
		else if (arr[i][y - 1] == 1 || arr[i][y + 1] == 1) {
			arr[i][y] = 3;
		}
		else {
			arr[i][y] = 9;
		}
	}

	return 0;
}

int three(int x, int y, int hy) {
	for (int i = y; (i > 0 || arr[x][i - 1] != 0); i--) { // 아래로 가며 끝 날때 까지 확인
		if (arr[x][i] == 0) {
			break;
		}
		else if (arr[x - 1][i] == 1 || arr[x + 1][i] == 1) {
			arr[x][i] =2;
		}
		else {
			arr[x][i] = 9;
		}
	}
	for (int i = y; (i <= hy || arr[x][i + 1] != 0); i++) {
		if (arr[x][i] == 0) {
			break;
		}
		else if (arr[x - 1][i] == 1 || arr[x + 1][i] == 1) {
			arr[x][i] =2;
		}
		else {
			arr[x][i] = 9;
		}
	}
	return 0;
}

int check(int x, int y, int hx, int hy) { //hx, hy는 배열의 크기 고정값.
	int token = 0;
	if (arr[x - 1][y] == 1 || arr[x + 1][y] == 1) {
		arr[x][y] = 2;
	}
	else if (arr[x][y - 1] == 1 || arr[x][y + 1] == 1) { // 먼저 밑에 서는 0, 1, 9 외 의 숫자가 있어야만 작동 되기에 이 코드는 트리거에 가깝다.
		arr[x][y] = 3;
	}
	else {
		arr[x][y] = 9;
	}
	do {
		token = 0;
		for (int i = 1; i <= hy; i++) {
			for (int j = 1; j <= hx; j++) {
				if (arr[j][i] != 0 && // 테스트 케이스
					arr[j][i] != 1 && // 0 의 경우 0 1 1, 1 의 경우 1 0 1, 2 의 경우 1 1 1 이므로 다음 코드로 넘어간다.
					arr[j][i] != 9) { // 0이나 1, 9가 외에는 안 보인다면 체크 끝0
					token = 1;
					if (arr[j][i] == 2) {
						two(j, i, hx);
					}
					else if (arr[j][i] == 3) {
						three(j, i, hy);
					}
					else {
						arr[j][i] = 9;
					}
				}
			}
		}
	} while (token != 0); // 이상 없음 0
	return 0;
}
int block(int x, int y, int i) {
	int px, py;
	int count = 0;
	for (int j = 0; j < i; j++) {
		scanf("%d %d", &px, &py);
		px++; py++;
		arr[px][py] = 1;
	}

	for (int n = 1; n <= y; n++) {
		for (int j = 1; j <= x; j++) {
			if (arr[j][n] == 1) {
				check(j, n, x, y);
				count++;

			}
		}
	}

	return count;
}

int main() {
	int j, x, y, t;
	scanf("%d", &j);
	for (int i = 0; i < j; i++) {
		scanf("%d %d %d", &x, &y, &t);
		printf("%d\n", block(x, y, t));
		for (int n = 1; n <= y; n++) {
			for (int m = 1; m <= x; m++) {
				arr[m][n] = 0;
			}
		}
	}
}
