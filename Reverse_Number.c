#include <stdio.h>

// Function to reverse the integer part of a number
int reverse(int x) {
    int reverse = 0;
    int rem;
    
    while (x != 0) {
        rem = x % 10;          // Get the last digit
        reverse = reverse * 10 + rem;  // Append digit to the reversed number
        x = x / 10;            // Remove the last digit
    }
    
    return reverse;
}

int main() {
    int num;
    printf("Enter a number: ");
    scanf("%d", &num);
    
    // Call the reverse function and print the result
    printf("Reversed integer: %d\n", reverse(num));
    
    return 0;
}
