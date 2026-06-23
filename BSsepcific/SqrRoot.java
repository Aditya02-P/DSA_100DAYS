public class SqrRoot {

    public static void main(String[] args) {
        int sqr =26;

        findSqrRoot2(sqr);
    }

    public static void findSqrRoot(int sqr){
        int rt=1;
        for(int i=1;i<=sqr;i++){
            if(i*i<=sqr){
                rt=i;
            }else{
                break;
            }
        }

        System.out.println("Square Root Floor Value: "+rt);
    }

    public static void findSqrRoot2(int sqr){
        int rt=1;
        int left=1,right=sqr;
        while(left<=right){
            int mid=(left+right)/2;
            int val = mid*mid;
            if(val  <=sqr){
                rt=mid;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }

        System.out.println("Square Root Floor Value: "+rt);
    }


}
