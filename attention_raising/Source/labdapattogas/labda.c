#include <stdio.h>
#include <stdlib.h>
#include <curses.h>
#include <unistd.h>

int main (void)
{
    int xj = 0, xk = 0, yj = 0, yk = 0;
    int mx, my;

    WINDOW *ablak;
    ablak = initscr ();


    for (;;)
    {
    	getmaxyx (ablak, my, mx);
        xj = (xj - 1) % mx;
        xk = (xk + 1) % mx;

        yj = (yj - 1) % my;
        yk = (yk + 1) % my;

        clear ();

        mvprintw (abs (yj + (my - yk)),
                  abs (xj + (mx - xk)), "o");

        refresh ();
        usleep (100000);

    }
    return 0;
}