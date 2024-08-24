#include <stdio.h>

// Recursive function to calculate Fibonacci number
int fibonacci(int n) {
    // Base cases
    if (n == 0) {
        return 0;
    } else if (n == 1) {
        return 1;
    } else {
        // Recursive case
        return fibonacci(n - 1) + fibonacci(n - 2);
    }}

int main() {
    int n, i;

    // Prompt the user to enter the number of Fibonacci numbers to print
    printf("Enter the number of Fibonacci numbers to print: ");
    scanf("%d", &n);

    if (n <= 0) {
        printf("Please enter a positive integer.\n");
    } else {
        // Print the first n Fibonacci numbers
        printf("The first %d Fibonacci numbers are:\n", n);
        for (i = 0; i < n; i++) {
            printf("%d ", fibonacci(i));
        }
        printf("\n");
    }

    return 0;
}
