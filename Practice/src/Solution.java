public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        //int [] arr = {1, 2, 3, 7, 1, 2, 3};
        //System.out.println(sol.solve(arr));

        int[] A = {7, 3, 1, 5, 5, 5, 1, 2, 4, 5};
        int[][] B = {{6,9}, {2,9}, {2, 4}, {0, 9}};
        long[] out = sol.rangeSum(A, B);
        for(long i:out) {
            System.out.println(i);
        }
    }

    public long[] rangeSum(int[] A, int[][] B) {
        int n = A.length;
        int[] ps = new int[n];
        ps[0] = A[0];
        for (int i=1; i<n; i++) {
            ps[i] = ps[i-1] + A[i];
        }
        long[] sum = new long[B.length];
        for (int i =0; i<B.length; i++) {
            int l = B[i][0];
            int r = B[i][1];
            if (l == 0) {
                sum[i] = ps[r];
            } else {
                sum[i] = ps[r] - ps[l-1];
            }
        }
        return sum;
    }

    public int solve(int[] A) {

        int[] PSe = prefixSumEven(A);
        System.out.println("prefixSumEven: " + PSe);
        for(int i:PSe) {
            System.out.println(i);
        }
        int[] PSo = prefixSumOdd(A);
        System.out.println("prefixSumEven: " + PSo);
        for(int i:PSo) {
            System.out.println(i);
        }
        int n = A.length;
        int count = 0;
        for (int i=0; i < n; i++) {
            int sumEven=0, sumOdd=0;
            if (i==0) {
                sumEven = PSo[n-1] - PSo[0];
                sumOdd = PSe[n-1] - PSe[0];
            } else {
                sumEven = PSe[i-1] + PSo[n-1] - PSo[i];
                sumOdd = PSo[i-1] + PSe[n-1] - PSe[i];
            }
            System.out.println(i + " " + sumEven + " " + sumOdd);
            if (sumEven == sumOdd) {
                count++;
            }
        }
        return count;
    }
    private int[] prefixSumEven(int[] A) {
        int[] ps = new int[A.length];
        ps[0] = A[0];
        for (int i=1; i < A.length; i++) {
            if (i%2 == 0) {
                ps[i] = A[i] + ps[i-1];
            } else {
                ps[i] = ps[i-1];
            }
        }
        return ps;
    }
    private int[] prefixSumOdd(int[] A) {
        int[] ps = new int[A.length];
        ps[0] = 0;
        for (int i=1; i < A.length; i++) {
            if (i%2 == 1) {
                ps[i] = A[i] + ps[i-1];
            } else {
                ps[i] = ps[i-1];
            }
        }
        return ps;
    }
}