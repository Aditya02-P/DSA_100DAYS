package SpecialAlgos;

import java.util.Arrays;

public class DutchNationalFlagAlgo {
    public static void main(String[] args) {
        int[] arr = {0,1,2,0,1,2,1,2,0,0,0,1};
        dnfSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void dnfSort(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {

            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;

                low++;
                mid++;
            }

            else if (arr[mid] == 1) {
                mid++;
            }

            // arr[mid] == 2
            else {
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;

                high--;
            }
        }
    }
}
