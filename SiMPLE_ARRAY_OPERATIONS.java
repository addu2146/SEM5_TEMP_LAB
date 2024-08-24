import java.util.ArrayList;
import java.util.Scanner;

public class SimpleArrayOperations {
    private ArrayList<Integer> arrayList;

    public SimpleArrayOperations() {
        arrayList = new ArrayList<>();
    }

    public void addElement(int element) {
        arrayList.add(element);
        System.out.println("Added " + element + " to the array.");
    }

    public void removeElement(int element) {
        if (arrayList.contains(element)) {
            arrayList.remove(Integer.valueOf(element)); // Remove the first occurrence
            System.out.println("Removed " + element + " from the array.");
        } else {
            System.out.println("Element " + element + " not found in the array.");
        }
    }

    public void displayArray() {
        System.out.println("Current array: " + arrayList);
    }

    public void getLength() {
        int length = arrayList.size();
        System.out.println("Array length: " + length);
    }

    public void accessElement(int index) {
        if (index >= 0 && index < arrayList.size()) {
            System.out.println("Element at index " + index + ": " + arrayList.get(index));
        } else {
            System.out.println("Index out of range.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleArrayOperations operations = new SimpleArrayOperations();
        
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add element");
            System.out.println("2. Remove element");
            System.out.println("3. Display array");
            System.out.println("4. Get length of array");
            System.out.println("5. Access element by index");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to add: ");
                    int addElem = scanner.nextInt();
                    operations.addElement(addElem);
                    break;
                case 2:
                    System.out.print("Enter element to remove: ");
                    int removeElem = scanner.nextInt();
                    operations.removeElement(removeElem);
                    break;
                case 3:
                    operations.displayArray();
                    break;
                case 4:
                    operations.getLength();
                    break;
                case 5:
                    System.out.print("Enter index to access: ");
                    int index = scanner.nextInt();
                    operations.accessElement(index);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}
