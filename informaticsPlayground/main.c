#include <stdio.h>
#include <limits.h>

int lessThanSqIdx(const int *arr, int arrSize) {
    int counter = 0;

    for (int i = 0; i < arrSize; i++) {
        if (i * i >= arr[i]) counter++;
    }

    return counter;
}

long productBoundaryNegs(const int *arr, int arrSize) {
    int fstNegIdx = -1, lastNegIdx = -1;
    long result = 1;
    for (int i = 0; i < arrSize; i++) {
        if (arr[i] < 0) {
            if (fstNegIdx < 0) {
                fstNegIdx = i;
            }
        lastNegIdx = i;
        }
    }
    if (lastNegIdx - fstNegIdx < 2) return 0;
    for (int i = fstNegIdx + 1; i < lastNegIdx; i++) {
        result *= arr[i];
    }
    return result;
}

void swapZeroMax(int *arr, int arrSize) {
    int lastZeroIdx = -1;
    int firstMaxIdx = -1;
    int maxValue = INT_MIN;
    int tmpValue;
    for (int i = 0; i < arrSize; i++) {
        if (maxValue < arr[i]) {
            maxValue = arr[i];
            firstMaxIdx = i;
        }
        if (arr[i] == 0) {
            lastZeroIdx = i;
        }
    }
    if (lastZeroIdx >= 0) {
        tmpValue = arr[lastZeroIdx];
        arr[lastZeroIdx] = arr[firstMaxIdx];
        arr[firstMaxIdx] = tmpValue;
        printf("Swapped %d and %d values\n", lastZeroIdx, firstMaxIdx);
    } else {
        printf("No values to swap\n");
    }

}

void test();

int main(void) {

    printf("Enter array size: \n");

    int arrSize;
    scanf("%d", &arrSize);

    int arr[arrSize];

    printf("Enter array values: \n");
    for (int i = 0; i < arrSize; i++) {
        scanf("%d", &arr[i]);
    }

    int lessThanSqIdxCount = lessThanSqIdx(arr, arrSize);
    long productBoundaryNegsVal = productBoundaryNegs(arr, arrSize);

    printf("%d\n", lessThanSqIdxCount);
    printf("%ld\n", productBoundaryNegsVal);

    swapZeroMax(arr, arrSize);

//    test();

    return 0;
}

void test() {

    int arr1[] = {0,0,0,0, 1,1,1,1, 0};
    int arr2[] = {1, 2, 5, 10, 17, 30, 0, 0, 0};
    int arr3[] = {1, 17, 13, 9, -14, 17, -15, -12, 2};

    printf("%s\n", "lessThanSqIdx");
    lessThanSqIdx(arr1, 9) == 9 ? printf("%s\n", "true") : printf("%s\n", "false");
    lessThanSqIdx(arr2, 9) == 3 ? printf("%s\n", "true") : printf("%s\n", "false");
    lessThanSqIdx(arr3, 9) == 6 ? printf("%s\n", "true") : printf("%s\n", "false");

    printf("%s\n", "productBoundaryNegs");
    productBoundaryNegs(arr1, 9) == 0 ? printf("%s\n", "true") : printf("%s\n", "false");
    productBoundaryNegs(arr2, 9) == 0 ? printf("%s\n", "true") : printf("%s\n", "false");
    productBoundaryNegs(arr3, 9) == -255 ? printf("%s\n", "true") : printf("%s\n", "false");

    printf("%s\n", "productBoundaryNegs");
    swapZeroMax(arr1, 9);
    printf("%d, %d\n", 4, 8);
    swapZeroMax(arr2, 9);
    printf("%d, %d\n", 5, 8);
    swapZeroMax(arr3, 9);
    printf("No swaps\n");

    printf("%s", "");

}
