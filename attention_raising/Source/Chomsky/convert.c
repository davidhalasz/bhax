#include <stdio.h>

int main()
{
	int a;
	int count = 0;

	printf("Adj meg egy természetes számot\n");
	scanf("%d", &a);
	printf("A beírt szám unáris alakban:");
	
	for (int i = 0; i < a; ++i)
	{
		printf("1");
		count++;
	}
	
	printf("\n");
	return 0;
}
	