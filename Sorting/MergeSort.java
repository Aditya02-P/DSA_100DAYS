import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        // 1. Calculate sizes and create temporary arrays
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] l = new int[n1];
        int[] r = new int[n2];

        // 2. Copy data to temporary arrays using local boundaries
        for (int i = 0; i < n1; i++) {
            l[i] = arr[low + i];
        }
        for (int j = 0; j < n2; j++) {
            r[j] = arr[mid + 1 + j];
        }

        int i = 0; // Initial index of first sub-array
        int j = 0; // Initial index of second sub-array
        int k = low; // Initial index of merged sub-array

        // 3. Merge the temporary arrays back into arr[]
        while (i < l.length && j < r.length) {
            if (l[i] <= r[j]) {
                arr[k] = l[i++];
            } else {
                arr[k] = r[j++];
            }
            k++;
        }

        // 4. Copy remaining elements of l[], if any
        while (i < l.length) {
            arr[k] = l[i++];
            k++;
        }

        // 5. Copy remaining elements of r[], if any
        while (j < r.length) {
            arr[k] = r[j++];
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 1, 5, 2, 6, 4};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}

/*
| Operation                    | Time Complexity | Extra Space Complexity | Explanation                                                                                             |
| ---------------------------- | --------------- | ---------------------- | ------------------------------------------------------------------------------------------------------- |
| `sort(arr, low, high)`       | O(n log n)      | O(n)                   | Array is recursively divided into two halves, and each level processes all `n` elements during merging. |
| `merge(arr, low, mid, high)` | O(n)            | O(n)                   | Creates two temporary arrays and merges them in linear time.                                            |
| Best Case                    | O(n log n)      | O(n)                   | Merge sort always divides and merges regardless of input order.                                         |
| Average Case                 | O(n log n)      | O(n)                   | Same number of divisions and merges on average.                                                         |
| Worst Case                   | O(n log n)      | O(n)                   | Performance remains consistent even for reverse-sorted arrays.                                          |
| Recursion Stack              | O(log n)        | Included in total      | Due to recursive calls until single-element subarrays are reached.                                      |

 */