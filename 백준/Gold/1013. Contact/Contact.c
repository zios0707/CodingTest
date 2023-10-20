#include <stdio.h>
#include <string.h>

int main() { // https://www.acmicpc.net/problem/1013
	int k, count = 0;
	char a[202] = { 0 };
	char aa[202] = { 0 };
	scanf("%d", &k);
	for (int i = 0; i < k; i++) {
		int idx = 0, zCnt = 0, oCnt = 0, soCnt = 0;
		scanf("%s", &a);
		for (int j = 0; a[j] != '\0'; j++) {
			if (j == 0 && a[j] == '0' && a[j + 1] == '1') {
				a[j] = 9;
				a[j + 1] = 9;
			}
			else if ((a[j] == '1' || a[j] == ' ' || a[j] == 9) &&
				a[j + 1] == '0' && a[j + 2] == '1') {
				// 이 문제를 풀기 위해서는 해당칸을 삭제하는 것이 아닌 칸으로 구분 하는 것이 더 용이 하다
				a[j + 1] = 9;
				a[j + 2] = ' ';
			}
		}
		for (int j = 0; ; j++) {
			if (a[j] != 9) {
				aa[idx++] = a[j];
			}
			if (a[j] == '\0') {
				aa[idx++] = -1;
				break;
			}
		}
		idx = 0;
		for (int j = 0; aa[j] != -1; j++) {
			if (aa[j] == ' ' || aa[j + 1] == -1) {		//끝 마디 or 끝에 도달 했을 경우
				if (oCnt == 0 &&
					zCnt == 0 &&
					soCnt == 0) {
				}
				else if (oCnt != 1 ||
					zCnt < 2 ||
					soCnt < 1 ||
					(j >= 2 && aa[j - 2] == 1)) {
					count = 1;
					oCnt = 0; zCnt = 0; soCnt = 0;
					break;
				}
				else {
					oCnt = 0; zCnt = 0; soCnt = 0;
				}
			}
			else if (zCnt == 0 &&
				aa[j] == '1') {
				oCnt++;
			}
			else if (aa[j] == '0') {
				if (soCnt > 1) {
					soCnt = 0;
					zCnt = 0;
				}
				else if (soCnt == 1) {
					count = 1;
					break;
				}
				if (oCnt == 0) {
					count = 1;
					break;
				}
				zCnt++;
			}
			else if (aa[j] == '1') {
				if (zCnt < 2) {
					count = 1;
					break;
				}
				soCnt++;
			}
			else {
				count = 1;
				break;
			}
		}
		for (int j = 0; aa[j] != -1; j++) {
			aa[j] = 0;
		}
		if (count == 1) printf("NO\n");
		else if (count == 0) printf("YES\n");
		memset(aa, ' ', 202 * sizeof(char));
		count = 0;
	}
}