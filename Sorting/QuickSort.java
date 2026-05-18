import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4,1,2,3,5,6,7};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            // Sort left part
            quickSort(arr, low, pivotIndex - 1);

            // Sort right part
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        //{4,9,1,2,3,5,6,7}
        while (i < j) {

            // Move i until finding an element greater than pivot
            while (i <= high - 1 && arr[i] <= pivot) {
                i++;
            }

            // Move j until finding an element less than or equal to pivot
            while (j >= low + 1 && arr[j] > pivot) {
                j--;
            }

            // Swap if pointers have not crossed
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Put pivot into its correct position
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }
}

/*


| Case    | Time Complexity | Recursion Space |
| ------- | --------------- | --------------- |
| Best    | O(n log n)      | O(log n)        |
| Average | O(n log n)      | O(log n)        |
| Worst   | O(n²)           | O(n)            |

| Algorithm  | Best       | Average    | Worst      | Extra Space    |
| ---------- | ---------- | ---------- | ---------- | -------------- |
| Quick Sort | O(n log n) | O(n log n) | O(n²)      | O(log n) stack |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n)           |


 */