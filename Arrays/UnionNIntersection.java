import java.util.ArrayList;

public class UnionNIntersection {
    public static void main(String[] args) {
        int[] arr1 = {1,1, 2, 3, 4, 5};
        int[] arr2 = { 2, 3, 4,4, 5};

       ArrayList<Integer>list= intersection(arr1,arr2);
        System.out.println(list);
    }

    public static ArrayList<Integer> unionArr(int[] arr1, int[] arr2) {

        int i = 0, j = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] <= arr2[j]) {

                if (list.isEmpty() || arr1[i] != list.getLast()) {
                    list.add(arr1[i]);
                }
                i++;

            } else {

                if (list.isEmpty() || arr2[j] != list.getLast()) {
                    list.add(arr2[j]);
                }
                j++;
            }
        }

        while (i < arr1.length) {
            if (list.isEmpty() || arr1[i] != list.getLast()) {
                list.add(arr1[i]);
            }
            i++;
        }

        while (j < arr2.length) {
            if (list.isEmpty() || arr2[j] != list.getLast()) {
                list.add(arr2[j]);
            }
            j++;
        }

        return list;
    }

    public static ArrayList<Integer> intersection(int[] arr1, int[] arr2) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                if(list.isEmpty() || arr1[i] != list.getLast()) {
                    list.add(arr1[i]);
                }
                i++;
                j++;
            }
            else if(arr1[i] > arr2[j]) {
                j++;
            }else if(arr1[i] < arr2[j]) {
                i++;
            }
        }

        return list;
    }
}
