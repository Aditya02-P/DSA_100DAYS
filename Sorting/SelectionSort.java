import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};

        // Optimize: arr.length - 1 because a single remaining element is already sorted
        for (int i = 0; i < arr.length - 1; i++) {
            // Scope minIndex to the outer loop; reset it for every pass
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                // Track the index of the smallest element found so far
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
/*
Time Complexity: BigOh(n^2)
good when the data set is very small
 */