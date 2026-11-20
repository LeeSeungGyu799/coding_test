#include <stdio.h>
int pibo(int i);
int main()
{
	int N;
	int result;
	scanf("%d", &N);
	result = pibo(N);
	printf("%d", result);
	return 0;
}
int pibo(int i)
{
	int a = 0, b = 1, p;
	int count = 0;
	while (count == 0 || count < i-1)
	{
		p = a + b;
		a = b; 
		b = p;
		count++;
	}
	return p;
}
