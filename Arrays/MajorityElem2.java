import java.util.HashMap;
import java.util.HashSet;

public class MajorityElem2 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 3, 3, 2, 2, 2};
        findMajority3(arr);
    }


    /*
    The below is extreme naive brute force approach of finding the majority element occurring more than
    n/3 times.
    It has a time complexity of BigOh(n2) and for not to check a same majority element a set is used to skip iteration if the
    current element is a majority element.
     */
    public static void findMajority(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        int count;
        int req = arr.length / 3;

        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            count = 0;
            if (set.contains(arr[i])) {
                continue;
            }
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > req) {
                System.out.println("Majority Element: " + arr[i]);
                set.add(arr[i]);
            }
        }
    }

    /*
    The below implementation is a better approach with a time complexity of BigOh(n)
    For scanning the array to count each element
    Another scan of the hashmap to count element count greater than n/3 times
    Space complexity - BigOh(n) if all elements are distinct
     */

    public static void findMajority2(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int req = arr.length / 3;
        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) > req) {
                System.out.println("Majority Element: " + key);
            }
        }
    }

    /*
    Another approach with time complexity of BigOh(n) with space complexity is
    by modifying the Moore's voting algo
     */

    public static void findMajority3(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        int c1 = 0;
        int c2 = 0;
        int e1 = -1, e2 = -2;
        for (int i = 0; i < arr.length; i++) {
            if (c1 == 0 && arr[i] != e2) {
                e1 = arr[i];
                c1 = 1;
            } else if (c2 == 0 && arr[i] != e1) {
                e2 = arr[i];
                c2 = 1;
            } else if (e1 == arr[i]) {
                c1++;
            } else if (e2 == arr[i]) {
                c2++;
            } else {
                c1--;
                c2--;
            }

        }

        int count1 = 0;
        int count2 = 0;
        for (int key : arr) {
            if (e1 == key) {
                count1++;
            }
            if (e2 == key) {
                count2++;
            }
        }
        if (count1 > arr.length / 3) {
            System.out.println("Majority Element: " + e1);
        }
        if (count2 > arr.length / 3) {
            System.out.println("Majority Element: " + e2);
        }

    }
}
