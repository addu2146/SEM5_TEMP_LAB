public class MergeSortedArrays {

    public static void main(String[] args) {
      
        int[] array1 = {1, 3, 5, 7};
        int[] array2 = {2, 4, 6, 8};

        
        int[] mergedArray = mergeArrays(array1, array2);

     
        System.out.println("Merged sorted array:");
        printArray(mergedArray);
    }

    //  merge two sorted arrays
    public static int[] mergeArrays(int[] array1, int[] array2) {
        int n1 = array1.length;
        int n2 = array2.length;
        int[] mergedArray = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        // Merge arrays
        while (i < n1 && j < n2) {
            if (array1[i] <= array2[j]) {
                mergedArray[k++] = array1[i++];
            } else {
                mergedArray[k++] = array2[j++];
            }
        }

        // Copy remaining elements of array1,
        while (i < n1) {
            mergedArray[k++] = array1[i++];
        }

        // Copy remaining elements of array2, if any
        while (j < n2) {
            mergedArray[k++] = array2[j++];
        }

        return mergedArray;
    }

    // Function to print the array
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
