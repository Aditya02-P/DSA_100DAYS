package SpecialAlgos;

public class MooresAlgo {
    public static void main(String[] args) {
        int[]arr={2,2,3,3,1,4,4};
        int ans = mooresFind(arr);
        System.out.println("The Majority Element is : "+ans);
    }
    public static int mooresFind(int[] arr) {
        int candidate=-1;
        int count=0;
        for(int key:arr){
            if(count==0){
                candidate=key;
                count=1;
            }
            else if(key==candidate){
                count++;
            }
            else {
                count--;
            }
        }
        count=0;
        for(int key:arr){
            if(key==candidate){
                count++;
            }
        }

        if(count<=arr.length/2){
            return -1;
        }

        return candidate;
    }
}
