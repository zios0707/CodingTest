#include <stdio.h>

int main() {
	int str[10][10] = { 0 };
	int i, j, num = 0, x, y;
	for (i = 1; i <= 9; i++)
	{
		for (j = 1; j <= 9; j++)
		{
			scanf("%d", &str[i][j]);
			if (num <= str[i][j])
			{
				num = str[i][j];
				x = i;
				y = j;
			}
			
		}
	}
	printf("%d\n%d %d", num, x, y);

}