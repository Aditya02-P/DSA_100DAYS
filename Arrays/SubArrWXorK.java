import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubArrWXorK {
    public static void main(String[] args) {
        int[]arr={4,2,2,6,4};
        int k=6;

        findSAKOptimized(arr,k);
//        RotateMatrix.printMatrix(ans);

    }

    public static int[][] findSAK(int[] arr,int k){
        if(arr.length==0){
            return new int[0][0];
        }
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        int ans=0;

        for(int i=0;i<arr.length;i++){
            ans=0;
            for(int j=i;j<arr.length;j++){
                ans=ans^arr[j];
                if(ans==k){
                    ArrayList<Integer> temp=new ArrayList<>();
                    for(int j1=i;j1<=j;j1++){
                        temp.add(arr[j1]);
                    }
                    list.add(temp);
                }
            }
        }

        return list.stream()
                .map(inner -> inner.stream()
                        .mapToInt(Integer::intValue)
                        .toArray())
                .toArray(int[][]::new);
    }

    public static void findSAKOptimized(int[] arr, int k) {

        /*
        Time Complexity: O(n)
        Space Complexity: O(n)
         */

        if (arr.length == 0) {
            return;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;
        int XOR = 0;

        for (int i = 0; i < arr.length; i++) {
            XOR ^= arr[i];

            int toFind = XOR ^ k;

            if (map.containsKey(toFind)) {
                count += map.get(toFind);
            }

            map.put(XOR, map.getOrDefault(XOR, 0) + 1);
        }

        System.out.println("Number Of Subarray: " + count);
    }
}
