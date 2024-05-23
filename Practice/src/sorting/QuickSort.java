package sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2,4,6,2,8,3,0,4};
        //int[] arr = {1,1,3,4,4,8,8,9,9};
        quickSort(arr, 0,arr.length-1);
        for (int a : arr)
            System.out.println(a);

    }
     static void quickSort(int[] arr, int lo, int hi) {
        if (lo<hi) {
            int pi=partition(arr, lo, hi);
            quickSort(arr, lo, pi-1);
            quickSort(arr,pi+1, hi);
        }
    }
     static int partition(int[] arr, int lo, int hi) {
        int pi=arr[lo];
        int l=lo+1;
        int r=hi;
        while(l<=r) {
            if (arr[l]<=pi) {
                l++;
            } else if(arr[r]>pi) {
                r--;
            } else {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        int temp = arr[lo];
        arr[lo] = arr[r];
        arr[r] = temp;
        return r;
    }
}
