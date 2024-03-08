#include "stdio.h"
#include "math.h"


int belongsToFigure(double x, double y) {
    double absY = fabs(y);
    return absY <= 2 && absY >= fabs(x) * 2 ? 1 : 0;
}


void messages(double x, double y) {
    int isInFigure;
    isInFigure = belongsToFigure(x, y);

    if (isInFigure == 1) {
        printf("%s %.2lf %.2lf %s\n" , "The point", x, y, "belongs to the specified area");
    } else {
        printf("%s %.2lf %.2lf %s\n" , "The point", x, y, "does not belong to the specified area");
    }
}


void mainProgram() {
    double x, y;

    printf("%s\n", "Enter x and y: \n");
    scanf("%lf%lf", &x, &y);

    messages(x, y);
}

void tests();


int lab1(void) {

//    mainProgram();

    tests();

    return 0;
}


void tests() {

    double xs[] = {0, 0.5, 0.99, 1.01, 1.5, 1.99, 2, 2.01,
                   -0.25, -0.5, -0.99, -1.01, -1.5, -1.99, -2, -2.01};

    int arrSize = sizeof(xs) / sizeof(double);

    for (int i = 0; i < arrSize; i++) {
        for (int j = 0; j < arrSize; j++) {
            double x = xs[i];
            double y = xs[j];
            int testRes = fabs(x) <= fabs(y) * 0.5 && fabs(y)  <= 2.0 ? 1 : 0;
            int funcRes = belongsToFigure(x, y);
            if (testRes == funcRes) {
                if (funcRes == 0) {
                    printf("Point (%0.2lf, %0.2lf) does not belong to figure\n", x, y);
                } else {
                    printf("Point (%0.2lf, %0.2lf) belongs to figure\n", x, y);
                }
            } else {
                printf("\t\t%s: %0.2lf, %0.2lf\n", "ERROR", x, y);
            }
        }
    }
}