package searching;

import java.util.Arrays;
import java.util.List;

public class FindMedian {
    public static void main(String[] args) {
        //Integer[] A = {-50, -41, -40, -19, 5, 21, 28 };
        //Integer[] B = {-50, -21, -10 };
        Integer[] A = { -19 };
        Integer[] B = { -47, -43, 26, 27, 32 };
        double ans = FindMedian.findMedianSortedArrays(Arrays.asList(A), Arrays.asList(B));
        System.out.println(ans);
    }
    // DO NOT MODIFY BOTH THE LISTS
    public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int n = a.size();
        int m = b.size();
        if (n==0) {
            return findSingleMedian(b, m);
        }
        if (m==0) {
            return findSingleMedian(a, n);
        }
        if (n<m) {
            return findMedian(a, b, n, m);
        } else {
            return findMedian(b, a, m, n);
        }
    }

    static double findSingleMedian(List<Integer> a, int n) {
        if (n%2==1) {
            return a.get(n/2);
        } else {
            return (a.get(n/2)+a.get((n-1)/2))/2.0;
        }
    }

    static double findMedian(List<Integer> a, List<Integer> b, int n, int m) {
        int x = (n+m)/2;
        int l=0, r=x;
        while (l<=r) {
            int mid = l+(r-l)/2;
            int l1 = (mid>=1) ? a.get(mid-1):Integer.MIN_VALUE;
            int l2 = (x-mid>=1) ? b.get(x-mid-1):Integer.MIN_VALUE;
            int r1 = mid<n ? a.get(mid):Integer.MAX_VALUE;
            int r2 = x-mid<m ? b.get(x-mid):Integer.MAX_VALUE;
            if(l1<=r2 && l2<=r1) {
                if ((n+m)%2==1) {
                    return Math.min(r1,r2);
                } else {
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
            } else if (l1>r2) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return 0.0;
    }
}
