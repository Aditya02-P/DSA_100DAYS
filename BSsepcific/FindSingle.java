public class FindSingle {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        findSingle(arr, 0, arr.length - 1);
    }

    public static void findSingle(int[] arr, int left, int right) {
        if (left > right) return;

        int mid = left + (right - left) / 2;

        // Check if mid is the single element using safe boundary checks
        boolean leftCheck = (mid == 0) || (arr[mid] != arr[mid - 1]);
        boolean rightCheck = (mid == arr.length - 1) || (arr[mid] != arr[mid + 1]);

        if (leftCheck && rightCheck) {
            System.out.println(arr[mid]);
            return;
        }

        // Keep exploring both sides
        findSingle(arr, left, mid - 1);
        findSingle(arr, mid + 1, right);
    }

    public static void findSingle2(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Make mid even
            if (mid % 2 == 1) {
                mid--;
            }

            // Pair is correct, search right half
            if (arr[mid] == arr[mid + 1]) {
                left = mid + 2;
            }
            // Pair is broken, search left half
            else {
                right = mid;
            }
        }

        System.out.println(arr[left]);
    }
}