#include <stdio.h>

int main(void)
{
	int array[1000];
	int save[1000];
	int i, j, n, m, e, a, b, c, d;
	scanf("%d %d", &e, &j);
	for (i = 1; i <= e; i++)
	{
		array[i] = i;
	}
	for (i = 1; i <= j; i++)
	{
		scanf("%d %d %d", &n, &m, &a);
		c = 1;
		for (b = a; b <= m; b++)
		{
			save[c] = array[b];
			c++; 
		}
		for (b = n; b <= a-1; b++)
		{
			save[c] = array[b];
			c++;
		}
		c = 0;
		for (b = n; b <= m; b++)
		{
			c++;
			array[b] = save[c];
		}
	}
	for (i = 1; i <= e; i++)
	{
		printf("%d ", array[i]);
	}
	return 0;
}

