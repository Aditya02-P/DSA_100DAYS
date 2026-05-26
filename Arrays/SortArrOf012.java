import java.util.Arrays;

public class SortArrOf012 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,0,1,2,1,2,0,0,0,1};
        sortArr2(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void sortArr(int[] arr){
        int _0count = 0;
        int _1count = 0;
        int _2count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                _0count++;
            }
            if(arr[i] == 1){
                _1count++;
            }
            if(arr[i] == 2){
                _2count++;
            }
        }
        for(int i =0;i<arr.length;i++){
            if(_0count != 0 ){
                arr[i]=0;
                _0count--;
                continue;
            }
            if(_1count != 0){
                arr[i]=1;
                _1count--;
                continue;
            }
            if(_2count != 0 ){
                arr[i]=2;
                _2count--;
            }
        }
    }

    //The below logic is the implementation ofDutch National Flag algorithm.

    /*
        | Algorithm                     | Time Complexity  | Space Complexity                   |
    | ----------------------------- | ---------------- | ---------------------------------- |
    | Brute Force Sorting           | (O(n \log n))    | (O(1)) or (O(n)) depending on sort |
    | Counting 0s,1s,2s             | (O(2n)) → (O(n)) | (O(1))                             |
    | Dutch National Flag Algorithm | (O(n))           | (O(1))                             |

     */

    public static void sortArr2(int[] arr) {
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
