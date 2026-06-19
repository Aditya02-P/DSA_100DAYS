public class FindRotArr {
    public static void main(String[] args) {
        int[]arr={7,8,9,1,2,3,4,5,6};
        int target =1;

//        findTarget(arr,target);

        findRotPoint(arr);

    }

    public static void findTarget(int[] arr,int target){
        if (arr.length==0){
            System.out.println("The array is empty");
            return;
        }

        int left=0,right=arr.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==target){
                System.out.println(arr[mid]+"The Index is: "+left);

                return;
            }
            else if(arr[left]<=arr[mid]){
                if(target >= arr[left] && target <= arr[mid]){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }else{
                if(target >= arr[mid] && target <= arr[right]){
                    left=mid+1;
                }else {
                    right=mid-1;
                }
            }
        }




    }

    public static void findRotPoint(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        System.out.println("Rotation point: " + low);
        System.out.println("Minimum element: " + arr[low]);
        System.out.println("Rotated "+high);
    }
}
