#include <stdio.h>
int main()
{
	int a, i;
	int result = 0;
	char aa[100] = { 0, };
	scanf("%d", &a);
	scanf("%s", aa);


	for (i = 0; i < a; i++)
		result = result + aa[i] - '0';

	printf("%d", result);
	return 0;
}