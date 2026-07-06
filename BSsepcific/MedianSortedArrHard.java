import java.util.Arrays;

public class MedianSortedArrHard {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 7, 10, 12};
        int[] arr2 = {2, 3, 6, 15};

        double   median = findMedian1(arr1, arr2);
        System.out.println("The median is: " + median);
    }

    public static double findMedian(int[] arr1, int[] arr2) {

        int n = arr1.length;
        int m = arr2.length;

        int[] merged = new int[n + m];

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        while (i < n)
            merged[k++] = arr1[i++];

        while (j < m)
            merged[k++] = arr2[j++];

        int total = n + m;

        if (total % 2 == 0) {
            return (merged[total / 2 - 1] + merged[total / 2]) / 2.0;
        }

        return merged[total / 2];
    }

    public static double findMedian1(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int index2=(    m+n)/2;
        int index1 =index2-1;
        int i=0,j=0;
        int cntIndex=0;
        int elem1=-1,elem2=-1;
        while(i<n&&j<m){
            if(arr1[i]<=arr2[j]){
                if(cntIndex==index1){
                    elem1=arr1[i];
                }
                if(cntIndex==index2){
                    elem2=arr1[i];
                }
                cntIndex++;
                i++;
            }else{
                if(cntIndex==index1){
                    elem1=arr2[j];
                }
                if(cntIndex==index2){
                    elem2=arr2[j];
                }
                cntIndex++;
                j++;
            }

        }

        while(i<n){
            if(cntIndex==index1){
                elem1=arr1[i];
            }
            if(cntIndex==index2){
                elem2=arr1[i];
            }
            cntIndex++;
            i++;
        }
        while(j<m){
            if(cntIndex==index1){
                elem1=arr2[j];
            }
            if(cntIndex==index2){
                elem2=arr2[j];
            }
            cntIndex++;
            j++;
        }

        if((m+n)%2==0){
            return (elem1+elem2)/2.0;
        }
        return elem2;
    }
}

