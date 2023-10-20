#include <stdio.h>

int main()
{
    char word[200];
    int i, j, token = 0;
    scanf("%s", word);
    for (i = 0; word[i] != '\0'; i++)
    {
    }
    i--;
    for (j = 0; j <= i; j++)
    {
        if (word[j] != word[i])
        {
            token++;
        }
        i--;
    }
    printf("%d", token == 0);
    return 0;
}