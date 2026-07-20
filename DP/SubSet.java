import java.util.ArrayList;
import java.util.Arrays;

public class SubSet {
    public static void main(String[] args) {
        int[]arr={1,2,3};
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        ArrayList<Integer> ss=new ArrayList<>();
        findSubSet(arr,0,list,ss);
        System.out.println(list);

    }

    private static void findSubSet(int[] arr,int start,ArrayList<ArrayList<Integer>> list,ArrayList<Integer> subSet) {
        if(start==arr.length){
            list.add(new ArrayList<>(subSet));
            return;
        }
        subSet.add(arr[start]);
        findSubSet(arr,start+1,list,subSet);
        subSet.removeLast();
        findSubSet(arr,start+1,list,subSet);

    }

    //This can't be solved using dp , because there is no overlapping subproblems , each state will lead to a
    //complete new answer so can't be done using dp
}
