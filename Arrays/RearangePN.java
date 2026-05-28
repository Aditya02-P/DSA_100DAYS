import java.util.Arrays;

public class RearangePN {
    public static void main(String[] args) {
        int[]arr={3,1,-2,-5,2,-4};
        arr=rearrange2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void rearrange(int[] arr){
        if(arr==null||arr.length==0){
            return;
        }
        int len=arr.length;
        int[] positive=new int[len/2];
        int p=0,n=0;
        int[] negative=new int[len/2];
        for (int j : arr) {
            if (j >= 0) {
                positive[p++] = j;
            } else {
                negative[n++] = j;
            }
        }

        for(int i=0;i<len/2 ;i++){
            arr[i*2]=positive[i];
            arr[i*2+1]=negative[i];
        }

    }

    public static int[] rearrange2(int[] arr){
        if(arr==null||arr.length==0){
            return arr;
        }

        int[] ans=new int[arr.length];

        int posIndex=0,negIndex=1,len=arr.length;
        for(int j=0;j<len;j++){
            if(arr[j]>=0){
                ans[posIndex]=arr[j];
                posIndex+=2;
            }else{
                ans[negIndex]=arr[j];
                negIndex+=2;
            }
        }

        return ans;
    }
}
