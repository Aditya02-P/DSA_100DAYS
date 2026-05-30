import java.util.Arrays;
import java.util.HashSet;

public class LongConseSeq {
    public static void main(String[] args) {
        int[]arr={102,4,100,1,101,3,3,3,2,2,2,2,2,1,1};
        findLongCoseSeq(arr);
    }

    public static void findLongCoseSeq(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int max = 1;
        int count = 1;
        int lastSmaller=Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {

            if(arr[i+1]==lastSmaller){
                continue;
            }

            if (arr[i + 1] == lastSmaller+1) {
                count++;
                lastSmaller=arr[i+1];
            }

            if(arr[i+1]!=lastSmaller){
                max=Math.max(max,count);
                lastSmaller=arr[i+1];
                count=1;
            }
        }

        max = Math.max(max, count);

        System.out.println("max = " + max);
    }

    public static int findLongestConsecutive(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        int maxLen = 0;

        for (int num : set) {

            if (!set.contains(num - 1)) {

                int current = num;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                maxLen = Math.max(maxLen, count);
            }
        }

        return maxLen;
    }

}
