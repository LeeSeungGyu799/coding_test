#include <stdio.h>
int main()
{
	int N, x, i;
	int a;
	scanf("%d %d", &N, &x);
	for (i = 0; i < N; i++)
	{
		scanf("%d", &a);
		if (a < x)
			printf("%d ", a);
	}
	return 0;
}