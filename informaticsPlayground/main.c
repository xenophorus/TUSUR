#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

#define N 5

int arrSum(const int *arr, int arrLen) {
    int s = 0;
    for (int i = 0; i < arrLen; ++i) {
        s = s + arr[i];
    }
    return s;
}


int main(void) {

    char *str = "Hello world";
    int l = strlen(str);

    printf("%d\n", l);

    for (; *str != '\0'; str++) {
        printf("%c\n", *str);
    }

    int* x = (int*) malloc(sizeof(int) * 16);

    for (int i = 0; i < 11; ++i) {
        x[i] = i * i;
    }

    int a = sizeof(x);
    printf("%d\n", *x);

    for (int i = 1; i < 101; ++i) {
        printf("%10d", x[i]);
        if (i % 10 == 0) {
            printf("\n");
        }
    }

    free(x);

    double y[5] = {1.1, 2.2, 3.3, 4.4, 0.05};

    for (int i = 0; i < 5; ++i) {
        printf("%d - %f", i, y[i]);
    }

    return 0;

    // p. 66, 4.3.2 Структуры
}
