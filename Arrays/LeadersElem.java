import java.util.ArrayList;

public class LeadersElem {
    public static void main(String[] args) {
        int[] arr = {10, 22, 12, 3, 0, 6};
        findLeaderElems(arr);
    }

    //This is brute force with time complexity of BigOh(n2)

    public static void findLeaderElems(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        boolean flag;
        for (int i = 0; i < arr.length; i++) {
            flag = true;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(arr[i]);
            }
        }

        System.out.println(list);
    }

    //This is the optimal solution with time complexity of BigOh(n)
    public static void findLeaderElems2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        ArrayList<Integer> list = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > max) {
                list.add(arr[i]);
                max = arr[i];
            }
        }

        System.out.println(list);
    }
}
