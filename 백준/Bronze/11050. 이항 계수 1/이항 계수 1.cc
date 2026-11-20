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
	int n, m;
	int number;
	scanf("%d %d", &n, &m);
	number = fact(n) / (fact(m) *fact(n - m));
	printf("%d", number);
}