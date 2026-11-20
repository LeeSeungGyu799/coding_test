#include <stdio.h>
int main()
{
	int input, result = 1;
	int a;
	int number[10];
	for (int i = 0; i < 10; i++)
		number[i] = 0;
	for (int i = 0; i < 3; i++) 
	{
		scanf("%d", &input);
		result *= input;
	}
	while(result != 0)
	{
		a = result % 10;
		number[a] += 1;
		result = result / 10;
	}
	for (int i = 0; i < 10; i++)
		printf("%d\n", number[i]);
}