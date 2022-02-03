import java.util.Random;

public class QuickSort {

    private static void quickSort(int[] inputArray, int lowIndex, int highIndex) {

        if (lowIndex >= highIndex) {
            return;
        }

        int pivot = inputArray[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while(leftPointer < rightPointer) {
            while(inputArray[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while(inputArray[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(inputArray, leftPointer, rightPointer);
        }
        swap(inputArray, leftPointer, highIndex);

        quickSort(inputArray, lowIndex, leftPointer - 1);
        quickSort(inputArray, leftPointer + 1, highIndex);
    }

    private static void swap(int[] inputArray, int index1, int index2) {
        int temp = inputArray[index1];
        inputArray[index1] = inputArray[index2];
        inputArray[index2] = temp;
    }

    private static void printArray(int[] inputArray) {
        for(int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i]);
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {

        Random rand = new Random();
        int[] numbers = new int[10];

        for(int i = 0; i < 10; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before: ");
        printArray(numbers);

        quickSort(numbers, 0, numbers.length - 1);

        System.out.println("\nAfter: ");
        printArray(numbers);
    }

}

