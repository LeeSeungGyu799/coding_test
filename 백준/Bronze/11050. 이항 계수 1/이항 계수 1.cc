#include <stdio.h>
int fact(int a)
{
	int p = 1;
	for (int i = 1; i <= a; i++)
		p = p * i;
	return p;
}
int main()
{
	int n, k;
	int number;
	scanf("%d %d", &n, &k);
	number = fact(n) / (fact(k) *fact(n - k));
	printf("%d", number);
}