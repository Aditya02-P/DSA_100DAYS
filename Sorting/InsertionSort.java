import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};
        for (int i =1;i<arr.length;i++){
           int j =i;
           while (j>0 && arr[j]<arr[j-1]){
               int temp = arr[j];
               arr[j] = arr[j-1];
               arr[j-1] = temp;
               j--;
           }
        }
        System.out.println(Arrays.toString(arr));

        //the standard implementation is with fewer assignments.
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }
}
/*

| Case                        | Complexity |
| --------------------------- | ---------- |
| Best Case (already sorted)  | O(n)       |
| Average Case                | O(n²)      |
| Worst Case (reverse sorted) | O(n²)      |

 */