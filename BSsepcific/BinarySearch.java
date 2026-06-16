public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 2;

        int index = binarySearchRecursive(arr, target, 0, arr.length - 1);
        System.out.println("The target value is: " + target);
    }

    public static int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int target, int low, int high) {

        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearchRecursive(arr, target, low, mid - 1);
        } else {
            return binarySearchRecursive(arr, target, mid + 1, high);
        }
    }
}




