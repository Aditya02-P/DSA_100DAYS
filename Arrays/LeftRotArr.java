import java.util.Arrays;

public class LeftRotArr {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        rotateArrLeftEff(arr, 4);
        System.out.println(Arrays.toString(arr));
    }

    //Time complexity-> BigOh(k*N) inefficient

    public static void rotateArrLeft(int[] arr, int k) {
        if (arr.length == 0 || arr.length == 1 || k == 0) {
            return;
        }
//        int fVal=arr[0];
//        for(int i=1;i<arr.length;i++){
//            arr[i-1]=arr[i];
//        }
//        arr[arr.length-1]=fVal;
        k = k % arr.length;
        while (k > 0) {

            int fVal = arr[0];
            for (int i = 1; i < arr.length; i++) {
                arr[i - 1] = arr[i];
            }
            arr[arr.length - 1] = fVal;
            k--;

        }
    }

    public static void rotateArrLeftEff(int[] arr, int k) {
        int n = arr.length;

        if (n == 0 || n == 1) {
            return;
        }

        k = k % n;

        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
        reverse(arr, 0, n - 1);
    }

    public static void reverse(int[] arr, int low, int high) {
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;

            low++;
            high--;
        }
    }


    public static void rotateArrRightEff(int[] arr, int k) {
        int n = arr.length;

        if (n == 0 || n == 1) {
            return;
        }

        k = k % n;

        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

}


