public class PrimeNumbersInRange {

    public static void main(String[] args) {
        // Define the range
        int start = 10;
        int end = 50;

        // Print prime numbers in the range
        System.out.println("Prime numbers between " + start + " and " + end + ":");
        printPrimesInRange(start, end);
    }

    // Function to print all prime numbers in a given range
    public static void printPrimesInRange(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println(); // Print a newline after listing all prime numbers
    }

    // Function to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false; // 0 and 1 are not prime numbers
        }
        if (number <= 3) {
            return true; // 2 and 3 are prime numbers
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false; // Eliminate multiples of 2 and 3
        }

        // Check divisibility from 5 to square root of number using 6k ± 1
        int sqrt = (int) Math.sqrt(number);
        for (int i = 5; i <= sqrt; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false; // Check divisibility by i and i + 2
            }
        }
        return true;
    }
}
