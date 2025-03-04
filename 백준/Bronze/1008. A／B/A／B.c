#include <stdio.h>
int main(void) {
	double a=0, b=0;
	scanf("%lf %lf", &a,&b);
	printf("%.9lf",(double)a/b);
	return 0;
}