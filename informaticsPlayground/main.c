//#include <stdio.h>
//
//int main() {
//    printf("Hello, World!\n");
//    return 0;
//}


#include <stdio.h>
#include <stdlib.h>

void f() {
    char phrase[] = "My first program\n";
    printf("%s", phrase);
}

int factorial(int n) {
    if (n <= 1) {
        return 1;
    } else {
        return n * factorial(n - 1);
    }
}

int looper(int counter, int y, int acc) {
    if (counter == 0) {
        return acc;
    } else {
        return looper(counter - 1, acc, acc + y);
    }
}

int fib(int n) {
    return looper(n - 1, 1, 0);
}

//int main(int argc, char **argv) {
////    system("chcp 1251");
//    int num;
//    num = 2;
//    f();
//    int a = factorial(7);
//    printf("%d\n", a);
//    int fn1 = fib(10);
//    printf("%d\n", fn1); /*
//    for (int i = 0; i < 10; ++i) {
//        printf("%d\n", i * 2);
//
//    }*/
//    return 0;
//}

int main(void) {

    char line[] = "_________________________________________________\n";
    char stars[] = "********_________________________________________\n";

    for (int i = 0; i < 13; ++i) {
        if ((i > 0 ) && (i < 6)) {
            printf(stars);
        } else {
            printf(line);
        }
    }


    return 0;
}
