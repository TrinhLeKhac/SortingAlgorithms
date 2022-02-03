import java.util.Random;

public class SortingAlgorithms {

    public static void insertionSort(int[] a) {
        int n = a.length;
        for(int i = 1; i < n; i++) {
            // insert a[i] in array 0..i-1
            int ai = a[i];
            int j = i - 1;
            while(j >= 0 && a[j] > ai) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = ai;
            printArray(i, a);
        }
    }

    public static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for(int j = i + 1; j < n; j++) {
                if(a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
            printArray(i, a);
        }
    }

    public static void bubbleSort(int[] a) {
        int n = a.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            printArray(i, a);
        }
    }

    public static void printArray(int i, int[] numbers) {
        System.out.print("Step " + i + ": ");
        for(int number: numbers){
            System.out.print(number);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Random rand = new Random();
        int[] numbers = new int[10];
        for(int i = 0; i < 10; i++) {
            numbers[i] = rand.nextInt(100);
        }
        selectionSort(numbers);
    }
}
