public class ArrayOperations {

    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 1, 2, 7};  // Example array

        System.out.println("Array: ");
        printArray(numbers);

        System.out.println("Sum: " + sum(numbers));
        System.out.println("Average: " + average(numbers));
        System.out.println("Minimum: " + min(numbers));
        System.out.println("Maximum: " + max(numbers));
    }

    // Function to calculate the sum of array elements
    public static int sum(int[] array) {
        int total = 0;
        for (int num : array) {
            total += num;
        }
        return total;
    }

    // Function to calculate the average of array elements
    public static double average(int[] array) {
        if (array.length == 0) return 0;
        return (double) sum(array) / array.length;
    }

    // Function to find the minimum element in the array
    public static int min(int[] array) {
        if (array.length == 0) throw new IllegalArgumentException("Array is empty");
        int minValue = array[0];
        for (int num : array) {
            if (num < minValue) {
                minValue = num;
            }
        }
        return minValue;
    }

    // Function to find the maximum element in the array
    public static int max(int[] array) {
        if (array.length == 0) throw new IllegalArgumentException("Array is empty");
        int maxValue = array[0];
        for (int num : array) {
            if (num > maxValue) {
                maxValue = num;
            }
        }
        return maxValue;
    }

    // Utility function to print the array
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
