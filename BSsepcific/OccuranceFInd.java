public class OccuranceFInd {
    public static void main(String[] args) {
        int[] arr={1,2,3,3,7,8,9,9,9,11};

        findOccurance(arr,9);
    }
    public static void findOccurance(int[] arr,int n){
        int low=0,high= arr.length-1;
        int fi=-1,li=-1;
        //First occurrence
        while(low<=high){
            int mid = low + (high - low) / 2;
            if(arr[mid]==n){
                fi=mid;
                high=mid-1;
            }
            else if(arr[mid]>n){
                high=mid-1;
            }else {
                low=mid+1;
            }
        }

        low=0;
        high=arr.length-1;

//        Last Occurrence
        while(low<=high){
            int mid = low + (high - low) / 2;
            if(arr[mid]==n){
                li=mid;
                low=mid+1;
            }
            else if(arr[mid]>n){
                high=mid-1;
            }else {
                low=mid+1;
            }
        }

        System.out.println(fi+","+li);
    }
}
