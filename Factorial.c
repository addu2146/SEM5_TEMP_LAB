#include <stdio.h>

// Function prototype for recursive factorial calculation
int factorial(int n);

int main() {
    int n;

    // Prompt the user to enter a non-negative integer
    printf("Enter a non-negative integer: ");
    scanf("%d", &n);

    if (n < 0) {
        printf("Factorial is not defined for negative integers.\n");
    } else {
        // Calculate and print the factorial
        printf("Factorial of %d is %d\n", n, factorial(n));
    }

    return 0;
}

// Recursive function to calculate factorial
int factorial(int n) {
    // Base case
    if (n == 0) {
        return 1;
    } else {
        // Recursive case
        return n * factorial(n - 1);
    }
}
