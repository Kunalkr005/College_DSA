 #include <stdio.h>
#define s 100

// Function to input array elements
int* input_array(int *array, int *length) {
    int i;
    printf("Enter number of elements: ");
    scanf("%d", length);

    printf("Enter %d elements:\n", *length);
    for (i = 0; i < *length; i++) {
        scanf("%d", (array + i));
    }
    return array;
}

// Function to reverse the array
void reverse_array(int *array, int *length) {
    int i, temp;
    for (i = 0; i < (*length) / 2; i++) {
        temp = *(array + i);
        *(array + i) = *(array + (*length - i - 1));
        *(array + (*length - i - 1)) = temp;
    }

    printf("\nReversed array:\n");
    for (i = 0; i < *length; i++) {
        printf("%d ", *(array + i));
    }
    printf("\n");
}

// Function to check unique elements
int* check_unique_array(int *array, int *length) {
    static int unique[s];
    int i, j, k = 0, flag;

    for (i = 0; i < *length; i++) {
        flag = 1;
        for (j = 0; j < i; j++) {
            if (*(array + i) == *(array + j)) {
                flag = 0;
                break;
            }
        }
        if (flag) {
            unique[k++] = *(array + i);
        }
    }

    printf("\nUnique elements:\n");
    for (i = 0; i < k; i++) {
        printf("%d ", unique[i]);
    }
    printf("\n");

    return unique;
}

int main() {
    int length, array[s];
    int *base, *unique;

    printf("Max size of an array = 100\n");

    base = input_array(array, &length);
    reverse_array(base, &length);
    unique = check_unique_array(base, &length);

    return 0;
}