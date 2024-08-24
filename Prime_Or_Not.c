#include <stdio.h>
#include <stdbool.h>

bool isPrime(int n);

int main() {
    int number;

    // Prompt the user to enter a number
    printf("Enter a positive integer: ");
    scanf("%d", &number);

    if (number <= 1) {
        printf("%d is not a prime number.\n", number);
    } else {
        // Check if the number is prime
        if (isPrime(number)) {
            printf("%d is a prime number.\n", number);
        } else {
            printf("%d is not a prime number.\n", number);
        }
    }

    return 0;
}

// Function to check if a number is prime
bool isPrime(int n) {
    // Base case for numbers less than 2
    if (n <= 1) {
        return false;
    }
    // Check for factors from 2 to sqrt(n)
    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0) {
            return false;
        }
    }
    return true;
}
