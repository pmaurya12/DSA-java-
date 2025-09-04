package sorting;

public class quicksort {
    public static int partition(int arr[], int start, int end) {
        int pivot = arr[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;

        return i;
    }

    public static void quicksort(int[] arr, int start, int end) {
        if (start < end) {
            int p = partition(arr, start, end);
            quicksort(arr, start, p - 1);
            quicksort(arr, p + 1, end);
        }

    }

    public static void main(String[] args) {
        int arr[] = { 10, 1, 9, 2, 8, 3, 7, 6, 5, 4 };
        int n = arr.length;
        quicksort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] +" ");
        }
    }
}