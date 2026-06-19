public class SearchRotArrii {
    public static void main(String[] args) {
        int[]arr={6,6,7,8,9,1,2,3,4,5,6,6,6,6,6};
        int target =6;

        findTarget(arr,target);
    }

    public static void findTarget(int[] arr,int target){

        if(arr.length==0){
            return;
        }
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){
                System.out.println("Index: "+mid);
                return;
            }

            /*The below if statement is what helps us to trim the array if all the element at low , mid and high are equal which was stoping to trim the array if
            duplicates elements are present, this is the case we were looking to solve if the array contain duplicates and sorted array
             */
            if(arr[low]==arr[mid] && arr[high]==arr[mid]){
                low++;
                high--;
                continue;
            }
            if(arr[low]<=arr[mid]){
                if(target >= arr[low] && target <= arr[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }else{
                if(target >= arr[mid] && target <= arr[high]){
                    low=mid+1;
                }else {
                    high=mid-1;
                }
            }
        }

    }
}
