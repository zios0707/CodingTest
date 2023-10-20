#include <stdio.h>

int main()
{
	
	int i,j,n,m;
	
	scanf("%d", &n);
	for (i = 1; i <= n; i++)
	{
		for (j = 1; j <= n-i; j++)
		{
		printf(" ");
		
		}
		for(m = 1; m <= i; m++)
		{
			printf("\*");
		}
        if(i == n)
        {
            break;
        }else
        {
		printf("\n");
        }
	}
	
	return 0;
}