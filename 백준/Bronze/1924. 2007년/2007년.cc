#include <stdio.h>
int main()
{
    int m, d;
    int i;
    int total = 0;
    int month[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    scanf("%d %d", &m, &d);
    
    for(i=0;i<m-1;i++)
        total = total + month[i];
    total = total + d;
    switch(total%7)
    {
        case 0: printf("SUN"); break;
        case 1: printf("MON"); break;
        case 2: printf("TUE"); break;
        case 3: printf("WED"); break;
        case 4: printf("THU"); break;
        case 5: printf("FRI"); break;
        case 6: printf("SAT"); break;
    }
    return 0;
}