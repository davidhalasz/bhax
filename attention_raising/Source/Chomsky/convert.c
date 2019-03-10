#include <stdio.h>
#include <math.h>  // pow()

int DecToBase(int base, int n);

int main() {

	int i = 0;
	int base = 2;

	for(i=0; i<=25; i++)
		printf("The decimal number %d in base %d is %d \n", i, base, DecToBase(base, i));
	return 0;
}

/*
	n = number in base 10 = 4
	base = the base that we want to convert to = 2

	4 / 2 = 2 M 0
	2 / 2 = 1 M 0
	1 / 2 = 0 M 1
*/

int DecToBase(int base, int n) {
	int num = 0;
	int quotient = n;
	int remainder = 0;
	int i = 0;

	while(quotient !=0) {
		remainder = quotient % base;
		quotient = quotient / base;

		num = (remainder * pow(10,i)) + num;
		i++;

	}
	return num;
}