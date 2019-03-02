#include<stdio.h>
int main(){
	
	int x = 3;
	int y = 5;
	
	x ^= y; // x = 6
	y ^= x; // y = 3
	x ^= y; //x = 5

	printf("x:%d y:%d\n",x,y);

	return 0;
}