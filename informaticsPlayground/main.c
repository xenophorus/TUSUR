#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int lessThanSqIdx(const int *arr, int arrSize) {
    /* The function counts the number of array elements whose values
     * are not greater than the values of the squares of their indices
     *
     * @arr int Pointer to the first element of the array
     * @arrSize int Number of array elements
     * @return int The number of array elements by condition
     * */

    int counter = 0;

    for (int i = 0; i < arrSize; i++) {
        if (i * i >= arr[i]) counter++;
    }

    return counter;
}

long productBoundaryNegs(const int *arr, int arrSize) {
    /* If the number of negative array elements is greater than two,
     * the function returns the product of the elements
     * between the first and last negative elements
     *
     * @arr int Pointer to the first element of the array
     * @arrSize int Number of array elements
     * @return long The product of the elements between the first and last negative elements
     * or zero
     * */

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

int* swapZeroMax(const int *arr, int arrSize) {
    /* Function swaps the first zero and the max values of the array
     *
     * @arr int Pointer to the first element of the array
     * @arrSize int Number of array elements
     * @return int* The pointer to the first element of the array
     * */

    int *tmpArray = (int*) malloc(sizeof(int) * arrSize);
    int lastZeroIdx = -1;
    int firstMaxIdx = -1;
    int maxValue = INT_MIN;
    int tmpValue;

    for (int i = 0; i < arrSize; i++) {
        tmpArray[i] = arr[i];
    }

    for (int i = 0; i < arrSize; i++) {
        if (maxValue < tmpArray[i]) {
            maxValue = tmpArray[i];
            firstMaxIdx = i;
        }
        if (tmpArray[i] == 0) {
            lastZeroIdx = i;
        }
    }

    if (lastZeroIdx >= 0) {
        tmpValue = tmpArray[lastZeroIdx];
        tmpArray[lastZeroIdx] = tmpArray[firstMaxIdx];
        tmpArray[firstMaxIdx] = tmpValue;
    }

    return tmpArray;
}

void printArray(const int *arr, int arraySize) {
    for (int i = 0; i < arraySize; ++i) {
        printf("%-5d", arr[i]);
    }
    printf("\n");
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
    printf("Number of array elements whose values are not greater than the square of their indices:\n");
    printf("%d\n\n", lessThanSqIdxCount);

    long productBoundaryNegsVal = productBoundaryNegs(arr, arrSize);
    printf("Product of array elements between the first and last negative elements: \n");
    printf("%ld\n\n", productBoundaryNegsVal);

    int* newArray = swapZeroMax(arr, arrSize);

    printf("Arrays after swapping array elements: \n");
    printf("Initial array: \n");
    printArray(arr, arrSize);
    printf("Resulting array: \n");
    printArray(newArray, arrSize);

    free(newArray);

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
    int *testArray1 = swapZeroMax(arr1, 9);
    printArray(arr1, 9);
    printArray(testArray1, 9);
    swapZeroMax(arr2, 9);
    int *testArray2 = swapZeroMax(arr2, 9);
    printArray(arr2, 9);
    printArray(testArray2, 9);
    swapZeroMax(arr3, 9);
    int *testArray3 = swapZeroMax(arr3, 9);
    printArray(arr3, 9);
    printArray(testArray3, 9);
}
