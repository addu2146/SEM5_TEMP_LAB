public class BubbleSortExample {

    public static void main(String[] args) {
        // Example array
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        // Perform bubble sort
        bubbleSort(array);

        // Print the sorted array
        System.out.println("Sorted array:");
        printArray(array);
    }

    // Function to perform bubble sort
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Perform a pass over the array
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if the element found is greater than the next element
                if (array[j] > array[j + 1]) {
                    // Swap elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped by inner loop, then the array is sorted
            if (!swapped) break;
        }
    }

    // Function to print the array
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
