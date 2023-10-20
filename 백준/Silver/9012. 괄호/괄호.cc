#include <stdio.h>
#include <string.h>

int main() {
	int n;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		char str[51] = { 0 };
		int stack = 0;
		scanf("%s", str);
		for (int j = 0; str[j] != '\0'; j++) {
			if (str[j] == '(') stack++;
			else if (str[j] == ')') stack--;
			if (stack < 0) break;
		}
		if (stack == 0) printf("YES\n");
		else printf("NO\n");
	}
}