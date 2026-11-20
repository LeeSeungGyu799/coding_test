#include <stdio.h>
int main()
{
	int number, cycle = 0;
	int original, ten, one;

	scanf("%d", &number);
	original = number;

	while (number != original || cycle == 0)
	{
		ten = number / 10;
		one = number % 10;
		number = (ten + number) % 10 + one * 10;
		cycle++;
	}
	printf("%d", cycle);
	return 0;
}