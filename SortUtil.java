package nottd;

public class SortUtil {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length-1; j++) {
                if (arr[j] < arr[i]) {
                    swap(arr, i, j);  // Refactor: 呼叫已有的 swap()
                }
            }
        }
    }

}