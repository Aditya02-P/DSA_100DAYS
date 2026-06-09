import java.util.ArrayList;
import java.util.Arrays;

public class MergeOverInter {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3},{2, 6},{8, 10},{15, 18}};
        int [][] intervals2={{1,3},{2,6},{8,9},{9,11},{8,10},{2,4},{15,18},{16,17}};

        int[][] result= mergeIntervals(intervals2);

        for (int[] interval : result) {
            System.out.print(Arrays.toString(interval));
        }
    }

    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        int left = intervals[0][0];
        int right = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] <= right) {
                right = Math.max(right, intervals[i][1]);
            } else {
                list.add(new ArrayList<>(Arrays.asList(left, right)));

                left = intervals[i][0];
                right = intervals[i][1];
            }
        }

        list.add(new ArrayList<>(Arrays.asList(left, right)));

        return list.stream()
                .map(inner -> inner.stream()
                        .mapToInt(Integer::intValue)
                        .toArray())
                .toArray(int[][]::new);
    }
}
