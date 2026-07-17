import java.util.ArrayList;
import java.util.Collections;

public class FibSeries {
    public static void main(String[] args) {
        int n=6;

        System.out.println(fib3(n));
    }

    public static int fib(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        return fib(n-1)+fib(n-2);
    }

    public static int fib2(int n){
        int sum=0;
        int fn=0,sn=1;
        for(int i=2;i<=n;i++){
            sum=fn+sn;
            fn=sn;
            sn=sum;
        }

        return sum;
    }

    //A way i tried to solve before looking at dp solution , only applying the concept of dp
    public static int fib3(int n){
        ArrayList<Integer> list=new ArrayList<>(Collections.nCopies(n+1,-1));
        return fibDp(n,list);

    }

    private static int fibDp(int n, ArrayList<Integer> list) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(list.get(n) !=-1){
            return list.get(n);
        }

        list.set(n, fibDp(n - 1, list) + fibDp(n - 2, list));
        return list.get(n);
    }

    public static int fib4DP(int n){
        ArrayList<Integer> list=new ArrayList<>(Collections.nCopies(n+1,-1));
        list.set(0,0);
        list.set(1,1);

        for(int i=2;i<=n;i++){
            int sum=list.get(i-1)+list.get(i-2);
            list.set(i,sum);
        }

        return list.get(n);
    }
}
