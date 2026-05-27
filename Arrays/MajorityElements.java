import java.util.HashMap;
import java.util.Map;

public class MajorityElements {
    public static void main(String[] args) {
        int[]arr={2,2,3,3,1,4,4};
        int ans = findMajority2(arr);
        System.out.println("The Majority Element is : "+ans);
    }

    public static int findMajority(int[] arr) {
        int count=0;
        int len=arr.length;
        for (int j : arr) {
            for (int k : arr) {
                if (k == j) {
                    count++;
                }
            }
            if (count > len/2) {
                return j;
            }
        }

        return -1;
    }

    public static int findMajority1(int[] arr) {
        int len=arr.length;
        Map<Integer, Integer> map=new HashMap<>();
        for (int i : arr) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int key:map.keySet()){
            if(map.get(key)>len/2){
                return key;
            }
        }

        return -1;
    }

    /*
        The below is the Moore's voting algorithm where we try to find the potential candidate for the majority element.
        The idea is about cancellation of elements as we iterate , and find the potential element which dominates.
        It does not guarantee if the element is majority or not , we need to verify in the second pass.
        But if majority exists it's guaranteed to return it.
        The intuition is that if an elements is Majority , it will survive the candidate count and won't become zero.
     */
    public static int findMajority2(int[] arr) {
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

