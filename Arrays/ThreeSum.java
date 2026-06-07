import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, -1, 2, -1, -4};
        int target = 0;
        threeSum(arr, target);
    }

    //This is a naive brute force approach with a time complexity of BigOh(n3)
    public static void threeSum(int[] arr, int target) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == target) {
                        System.out.println("Triplet: " + arr[i] + " : " + arr[j] + " : " + arr[k]);
                    }
                }
            }
        }
    }

    public static void threeSum1(int[] arr, int target) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(
                            nums[i],
                            nums[left],
                            nums[right]
                    ));

                    left++;
                    right--;

                    // Skip duplicates
                    while (left < right &&
                            nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right &&
                            nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
