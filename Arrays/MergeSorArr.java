public class MergeSorArr {

    public static void main(String[] args) {
        int[]   arr1 = {1, 3, 5, 7};
        int[]   arr2 = {0, 2, 6, 8, 9};

        printSorted1(arr1, arr2);


        for (int elem : arr1) {
            System.out.print(elem + " ");
        }
        for (int elem : arr2) {
            System.out.print(elem + " ");
        }
    }


    // This approach is naive approach with space complexity of BigOh(l+r) , there are multiple loops running

    public static void printSorted(int[] arr1, int[] arr2) {

        int l = arr1.length;
        int r = arr2.length;
        int[] temp = new int[l + r];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < l && j < r) {
            if (arr1[i] <= arr2[j]) {
                temp[k++] = arr1[i++];
            } else {
                temp[k++] = arr2[j++];
            }
        }
        while (i < l) {
            temp[k++] = arr1[i++];
        }
        while (j < r) {
            temp[k++] = arr2[j++];
        }

        for (int index = 0; index < l + r; index++) {
            if (index < l) {
                arr1[index] = temp[index];
            } else {
                arr2[index - l] = temp[index];
            }
        }


    }

    public static void printSorted1(int[] arr1, int[] arr2) {
        int l = arr1.length - 1;
        int r = 0;

        while (l >= 0 && r < arr2.length) {
            if (arr2[r] < arr1[l]) {
                int temp = arr2[r];
                arr2[r] = arr1[l];
                arr1[l] = temp;
                l--;
                r++;
            } else {
                break;
            }
        }

        sort(arr1);
        sort(arr2);

    }

    private static void sort(int[] arr) {
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
    1 3 5 7 | 0 2 6 8 9
*/
