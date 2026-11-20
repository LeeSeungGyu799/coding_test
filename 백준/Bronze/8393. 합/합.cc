#include <stdio.h>
int main()
{
    int N, res=0;
    int i;
    scanf("%d",&N);
    for(i=1;i<=N;i++)
        res = res + i;
    printf("%d",res);
    return 0;
}