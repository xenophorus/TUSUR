#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define N 5

int len(const int *arr) {
    int arrLen = sizeof(arr);
    if (arrLen == 0) {
        return 0;
    }
    int el = sizeof(arr[0]);
    return arrLen / el;
}


int main(void) {
    srand(time(0));
    for (int i = 1; i <= 50; ++i) {
        printf("%5d", rand() % 50);
        if (i % 10 == 0) {
            printf("\n");
        }
    }

//    int arrI[N];
//
//    for (int i = 0; i < N; ++i) {
//        printf("%p\n", &arrI[i]);
//
//    }

    int arrSize = 10;
    int array[arrSize];
    int *fourthEl = &array[3];

    for (int i = 0; i < 3; i++) {
        printf("%p\n", fourthEl + i);
    }

    printf("%lu\n", sizeof(array));
    printf("%lu\n", sizeof(fourthEl));

    printf("%d\n", len(array));

    return 0;
}
