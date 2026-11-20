#include <stdio.h>
#include <string.h>
int main()
{
    char aa[100];
    int length;
    scanf("%s", aa);

    length = strlen(aa);
    for(int i=0; i< length;i++ )
    {
        printf("%c", aa[i]);
        if ((i+1) % 10 ==0)
            printf("\n");
    }
    return 0;
}