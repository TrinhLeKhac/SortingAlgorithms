import java.util.Random;

public class MergeSort {

    private static void mergeSort(int[] inputArray) {
        int inputLength = inputArray.length;

        if(inputLength < 2) {
            return;
        }

        int midIndex = inputLength/2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];

        System.arraycopy(inputArray, 0, leftHalf, 0, midIndex);
        System.arraycopy(inputArray, midIndex, rightHalf, 0, inputLength - midIndex);

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        // Merge
        merge(inputArray, leftHalf, rightHalf);
    }

    private static void merge(int[] inputArray, int[] leftArray, int[] rightArray) {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < leftSize && j < rightSize) {
            if(leftArray[i] <= rightArray[j]) {
                inputArray[k] = leftArray[i];
                i++;
            } else {
                inputArray[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while(i < leftSize) {
            inputArray[k] = leftArray[i];
            i++;
            k++;
        }

        while(j < rightSize) {
            inputArray[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private static void printArray(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number);
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {

        Random rand = new Random();
        int[] numbers = new int[10];
        for(int i = 0; i < 10; i++) {
            numbers[i] = rand.nextInt(100000);
        }

        System.out.println("Before: ");
        printArray(numbers);
        mergeSort(numbers);

        System.out.println("\nAfter: ");
        printArray(numbers);
    }
}

