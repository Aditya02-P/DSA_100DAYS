package SpecialAlgos;

public class BoyerMoore {

    //The algorithm is the modification of the Moore voting algorithm where 2 variables are used to keep track of the majority elements.
    public static void findMajority(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        int e1 = -1, e2 = -2;
        int c1 = 0, c2 = 0;

        for (int num : arr) {
            if (e1 == num) {
                c1++;
            }
            else if (e2 == num) {
                c2++;
            }
            else if (c1 == 0) {
                e1 = num;
                c1 = 1;
            }
            else if (c2 == 0) {
                e2 = num;
                c2 = 1;
            }
            else {
                c1--;
                c2--;
            }
        }

        int count1 = 0, count2 = 0;

        for (int num : arr) {
            if (num == e1) count1++;
            if (num == e2) count2++;
        }

        if (count1 > arr.length / 3) {
            System.out.println("Majority Element: " + e1);
        }

        if (count2 > arr.length / 3) {
            System.out.println("Majority Element: " + e2);
        }
    }

    public static void main(String[] args) {
        int[]arr={1,1,1,3,3,2,2,2};
        findMajority(arr);
    }
}
