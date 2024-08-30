public class LargestElementFinder {

    public static void main(String[] args) {
        // Example array
        int[] numbers = {10, 45, 78, 23, 56, 89, 12};

        // Find the largest element
        int largest = findLargest(numbers);

        // Print the result
        System.out.println("The largest element in the array is: " + largest);
    }

    // Function to find the largest element in the array
    public static int findLargest(int[] array) {
        // Check if the array is empty
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int largest = array[0]; // Assume the first element is the largest

        for (int i = 1; i < array.length; i++) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }

        return largest;
    }
}
