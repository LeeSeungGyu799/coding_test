#include <stdio.h>
int main()
{
	int num;
	scanf("%d", &num);
	double sco[1000];
	double max = 0.0;

	for (int i = 0; i < num; i++)
		scanf("%lf", &sco[i]);

	for (int i = 0; i < num; i++)
		if (max <= sco[i])
			max = sco[i];

	double sum=0.0;
	for (int i = 0; i < num; i++)
		sum += (sco[i] / max) * 100;
	
	printf("%0.2lf", sum / num);
	return 0;
}