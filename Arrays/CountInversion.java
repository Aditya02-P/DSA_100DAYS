import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountInversion {
    public static void main(String[] args) {
        int[] arr ={5,3,2,4,1};

        findInversion(arr);
    }

    //The below is the brute force approach with time complexity of BigOh(n2)

    public static void findInversion(int[] arr){
        if(arr==null||arr.length==0){
            return;
        }

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    list.add(new ArrayList<>(List.of(arr[i],arr[j])));
                }
            }
        }

        list.forEach(li-> System.out.println(Arrays.toString(li.toArray())));
    }

    public static long countInversions(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int[] temp = new int[arr.length];
        return mergeSortAndCount(arr, temp, 0, arr.length - 1);
    }

    // Recursive function to divide the array and count inversions
    private static long mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        long invCount = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;

            // Count inversions in the left half
            invCount += mergeSortAndCount(arr, temp, left, mid);

            // Count inversions in the right half
            invCount += mergeSortAndCount(arr, temp, mid + 1, right);

            // Count cross inversions during the merge step
            invCount += mergeAndCount(arr, temp, left, mid, right);
        }

        return invCount;
    }

    // Merges two sorted halves and counts cross inversions
    private static long mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        long invCount = 0;

        // Traverse both arrays and merge them
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return invCount;
    }
}
