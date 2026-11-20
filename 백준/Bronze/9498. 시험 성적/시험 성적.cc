#include <stdio.h>
int main()
{
    int N;
    scanf("%d", &N);
    if (N <= 100 && N >=90)
        printf("A");
    else if (N<90 && N>=80)
        printf("B");
    else if (N<80 && N>=70)
        printf("C");
    else if (N<70 && N>=60)
        printf("D");
    else
        printf("F");
    return 0;
}