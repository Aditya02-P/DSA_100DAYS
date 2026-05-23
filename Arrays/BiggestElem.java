public class BiggestElem {
    public static void main(String[] args) {
        int[]arr={3,54,2,34,45,12,5,32,1};
//        int big = Integer.MIN_VALUE;
//        for (int i : arr) {
//            if (i > big) {
//                big = i;
//            }
//        }
//        System.out.println(big);
//        secondBig(arr);
//        secondSmallest(arr);

    }

    public static void secondBig(int[]arr){
        int big = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > big) {
                big = i;
            }
        }
        int big2 = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > big2 && i!=big) {
                big2 = i;
            }
        }
        System.out.println("First Biggest Element is: "+big);
        System.out.println("Second Biggest Element is: "+big2);
    }

    public static void secondSmallest(int[]arr){
      int smallest = arr[0];
      int smallest2 = Integer.MAX_VALUE;
      for (int num : arr) {
          if (num < smallest) {
              smallest2 = smallest;
              smallest = num;
          }
          else if (num != smallest && num < smallest2) {
              smallest2 = num;
          }
      }
        System.out.println("First Smallest Element is: "+smallest);
        System.out.println("Second Smallest Element is: "+smallest2);
    }

}
