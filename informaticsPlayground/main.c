#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(void) {
    srand(time(0));
    for (int i = 1; i <= 50; ++i) {
        printf("%5d", rand() % 50);
        if (i % 10 == 0) {
            printf("\n");
        }
    }

    return 0;
}
