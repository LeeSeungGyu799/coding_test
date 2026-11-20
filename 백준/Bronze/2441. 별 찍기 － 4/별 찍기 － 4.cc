#include <stdio.h>
int main()
{
	int N, i, j;
	scanf("%d", &N);
	for (i = N; i > 0; i--)
	{
		for (j = 0; j < N - i; j++)
			printf(" ");
		for (j = i; j > 0; j--)
			printf("*");
		printf("\n");
	}
	return 0;
}