import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] arr ={-1,1,2,3,4,1,-1,-2,0,0};
        int[][]ans=fourSum(arr,0);
        RotateMatrix.printMatrix(ans);
    }

    public static int[][] fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i+1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {

                    int sum = nums[i] + nums[j]+ nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(
                                nums[i],
                                nums[j],
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

                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }


        }

        return result.stream()
                .map(row -> row.stream()
                        .mapToInt(Integer::intValue)
                        .toArray())
                .toArray(int[][]::new);
    }
}
/*

| Component                   | Time       | Space    |
| --------------------------- | ---------- | -------- |
| Sorting                     | O(n log n) | O(1)     |
| Nested loops + two pointers | O(n³)      | O(1)     |
| List → int[][] conversion   | O(k)       | O(k)     |
| Overall                     | O(n³)      | O(k)     |

 */