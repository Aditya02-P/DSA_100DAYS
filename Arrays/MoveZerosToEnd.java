import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        moveZerosToEnd(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveZerosToEnd(int[] arr) {
        int p1 = 0;

        // place non-zero elements
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[p1++] = arr[i];
            }
        }

        // fill remaining places with 0
        while (p1 < arr.length) {
            arr[p1++] = 0;
        }
    }
}


