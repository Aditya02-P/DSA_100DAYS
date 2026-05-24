import java.util.ArrayDeque;
import java.util.Arrays;

public class ReDupesSoArr {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3};
        solve3(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void solve(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return;
        }

        int index = 0;
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] != arr[i - 1]) {
                arr[++index] = arr[i];
            }
        }
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = 0;
        }

    }

    public static void solve2(int[] arr) {
        //two pointer approach
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return;
        }
        int i=0,j=1;
        while (j < arr.length) {
            if (arr[i] == arr[j]) {
                j++;
            }
            else if (arr[i] != arr[j]) {
                arr[++i] = arr[j];
            }
        }
        for(int k =arr.length-1;k>i;k--){
            arr[k] = 0;
        }

    }

    public static void solve3(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return;
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int j : arr) {
            if (stack.isEmpty() || j != stack.peek()) {
                stack.push(j);
            }
        }

        int size = stack.size();

        for(int j = size-1;j>=0;j--){
            arr[j] = stack.pop();
        }

        for(int j = size;j<arr.length;j++){
            arr[j] = 0;
        }
    }

}

