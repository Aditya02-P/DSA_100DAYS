public class ReversePairs {
    public static void main(String[] args) {
        int[] arr = {40, 25, 19, 12, 9, 6, 2};

        long c =countRevPair(arr);
        System.out.println(c);

//        findRevPair(arr);
    }

    public static void findRevPair(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > 2 * arr[j]) {
                    System.out.println(arr[i] + " " + arr[j]);
                    count++;
                }
            }
        }

        System.out.println("Total Count: " + count);
    }

    public static int countRevPair(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        // A single temporary array passed down saves memory allocation overhead
        int[] temp = new int[arr.length];
        return mergeSortAndCount(arr, temp, 0, arr.length - 1);
    }

    private static int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int invCount = 0;

        // 1. Sort and count left half
        invCount += mergeSortAndCount(arr, temp, left, mid);

        // 2. Sort and count right half
        invCount += mergeSortAndCount(arr, temp, mid + 1, right);

        // 3. Count cross-inversions and merge
        invCount += countAndMerge(arr, temp, left, mid, right);

        return invCount;
    }

    private static int countAndMerge(int[] arr, int[] temp, int left, int mid, int right) {
        int count = 0;
        int j = mid + 1;

        // STEP 1: Count the reverse pairs independently
        // Since both halves are sorted, if arr[i] > 2 * arr[j],
        // it will also be greater than 2 * arr[everything before j]
        for (int i = left; i <= mid; i++) {
            while (j <= right && arr[i] > 2L * arr[j]) { // 2L prevents integer overflow
                j++;
            }
            // The distance the 'j' pointer moved is the number of valid pairs for arr[i]
            count += (j - (mid + 1));
        }

        // STEP 2: Standard Merge Sort using the pre-allocated temp array
        int i = left;
        j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy the sorted elements back to the original array
        for (int x = left; x <= right; x++) {
            arr[x] = temp[x];
        }

        return count;
    }


}
/*

25 40       12 19

 */