import java.util.Arrays;

public class SubSetWKSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 9;;

        Boolean[][] dp =  new Boolean[arr.length+1][k+1];


        boolean ans = findSubset(arr,dp,arr.length-1,k);

        System.out.println(ans);
    }

    private static boolean findSubset(int[] arr, Boolean[][] dp, int i, int k) {
        if(i<0){
            return false;
        }
        if(k<0){
            return false;
        }

        if(dp[i][k]!=null){
            return true;
        }

        dp[i][k]=findSubset(arr,dp,i-1,k-arr[i]) || findSubset(arr,dp,i-1,k);

        return dp[i][k];
    }

    private static boolean checkSubsetWS(int[] arr, int k, int i) {

        if(i<0 || k<0) return false;

        if(k==0){
            return true;
        }


        return checkSubsetWS(arr,k-arr[i],i-1) || checkSubsetWS(arr,k,i-1);
    }




}
