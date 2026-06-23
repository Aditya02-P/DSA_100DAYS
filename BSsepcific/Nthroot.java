public class Nthroot {
    public static void main(String[] args) {

        nthRoot(28,3);
    }

    public static long exponent(int mid, int n) {
        long ans = 1;

        while (n > 0) {

            // If n is odd
            if (n % 2 == 1) {
                ans = ans * mid;
                n = n - 1;
            }
            // If n is even
            else {
                mid = mid * mid;
                n = n / 2;
            }
        }

        return ans;
    }

    public static void nthRoot( int m,int n) {
        int left=1,right=n;
        while(left<=right){
            int mid = left+(right-left)/2;
            long expo=exponent(mid,n);
            if(expo==m){
                System.out.println("Root is "+mid);
                return;
            }
            else if(expo<m){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }

        System.out.println("No Root Found");
    }


}
