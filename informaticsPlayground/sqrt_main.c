#include <stdio.h>
#include <math.h>

double sqrt2(double num, double precision, double root) {
    double checkValue = num;
    while (fabs(checkValue * checkValue - num) > precision) {
        root = checkValue / 2 + num / (2 * checkValue);
        checkValue = root;
    }
    return root;
}

int enough(double precision, double checkValue) {
    return precision > checkValue ? 1 : 0;
}

double getTempRoot(double tmpRoot, double n) {
    double value = tmpRoot / 2 + n / (2 * tmpRoot);
    return value;
}

double helper(double num, double precision, double root, double tmpRoot) {
    root = getTempRoot(tmpRoot, num);
    if (enough(precision, fabs(root * root - num)) == 1) {
        return root;
    } else {
        return helper(num, precision, tmpRoot, root);
    }
}

double sqrt1(double num, double precision, double root) {
    return helper(num, precision, root, num);
}

int mai2(void) {
    double precision = 0.0000001;
    int num = 2;

    double root = sqrt1((double) num, precision, 0.0);

    printf("Square root of %d is %f", num, root);

    return 0;


//    int i = 1;
//    int x = 17;
//    float j;
//    for (j = 0; j < 10; j += 2.5f) {
//        printf("I = %d\n", i);
//        i++;
//    }
//    printf("J = %f", j);
//    return 0;
}
