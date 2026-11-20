#include <stdio.h>
int main()
{
	int A, B;
	int a, b, c;
	scanf("%d %d", &A, &B);

	a = B / 100;
	b = (B - a * 100) / 10;
	c = (B - a * 100 - b * 10);

	printf("%d\n", c * A);
	printf("%d\n", b * A);
	printf("%d\n", a * A);
	printf("%d\n", B * A);

	return 0;
}