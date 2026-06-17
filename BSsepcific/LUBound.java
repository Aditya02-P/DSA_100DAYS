public class LUBound {
    public static void main(String[] args) {
        int[] arr={1,2,3,3,7,8,9,9,9,11};
                 //0,1,2,3,4,5,6,7,8,9

        occurrence(arr,9);
    }

    public static int lowerBound(int[] arr, int n){
        int index=arr.length;

        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=n){
                index=mid;
                high=mid-1;
            }else if(arr[mid]<n){
                low=mid+1;
            }
        }

        System.out.println("The lower bound of "+n+" is "+index);

        return index;
    }

    public static int upperBound(int[] arr,int n){
        int index=arr.length;
        int low=0;
        int high=arr.length-1;


        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]<=n){
                low=mid+1;
            }else if(arr[mid]>n){
                index=mid;
                high=mid-1;
            }
        }

        System.out.println("The upper bound of "+n+" is "+index);
        return index;

    }

    public static void occurrence(int[] arr,int n){

        int occ = upperBound(arr,n)-lowerBound(arr,n);

        System.out.println("The occurrence of "+n+" is "+occ);
    }


}
