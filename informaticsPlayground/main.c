#include <stdio.h>

int main(void) {

    int a = 27;
    printf("%d ", a);
    while (a != 1) {
        if (a % 2 == 0) {
            a = a / 2;
        } else {
            a = a * 3 + 1;
        }
        printf("%d ", a);
    }
    printf("\n\n");
    for (int i = 31; i < 128; ++i) {
        if (i % 10 == 0) {
            printf("%7d - %c\n", i, i);
        } else {
            printf("%7d - %c", i, i);
        }
    }
    printf("\n\n");
    for (int i = 1; i < 10; ++i) {
        for (int j = 1; j < 10; ++j) {
            printf("%4d", i * j);
        }
        printf("\n");
    }

    return 0;
}
