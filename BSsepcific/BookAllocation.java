public class BookAllocation {
//It is the same logic for painter partition problem also
    public static void main(String[] args) {
//        int[] pages = {25, 46, 28, 49, 24};
        int[] pages={10,20,30,40};
        int students = 2;

        int ans = allocateBooks(pages, students);
        System.out.println("Minimum possible maximum pages: " + ans);
    }

    public static int allocateBooks(int[] pages, int students) {

        if (students > pages.length) {
            return -1;
        }

        int low = findMax(pages);
        int high = findSum(pages);
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canAllocate(pages, students, mid)) {
                ans = mid;
                high = mid - 1; // Try for a smaller maximum
            } else {
                low = mid + 1; // Increase the limit
            }
        }

        return ans;
    }

    public static boolean canAllocate(int[] pages, int students, int maxPages) {

        int studentCount = 1;
        int pageSum = 0;

        for (int page : pages) {

            if (pageSum + page <= maxPages) {
                pageSum += page;
            } else {
                studentCount++;
                pageSum = page;

                if (studentCount > students) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int findMax(int[] pages) {
        int max = pages[0];

        for (int page : pages) {
            if (page > max) {
                max = page;
            }
        }

        return max;
    }

    public static int findSum(int[] pages) {
        int sum = 0;

        for (int page : pages) {
            sum += page;
        }

        return sum;
    }
}