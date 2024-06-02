package arrays;

/**
 * For given array find the pair of i, j such that (A[i] + A[j]) % m = 0
 *
 * Approach:
 * (A[i] + A[j]) % m
 * = (A[i]%m + A[j]%m) %m
 * range= 0 to m-1, 0 to m-1
 * range= min= 0 max=2m-2
 *  for range 0 to 2m-2, % m can be zero for 0 or m value
 *
 *  pairs can be
 *  i   j
 *  0   0
 *  1   m-1
 *  2   m-2
 *  3   m-3
 *  i   m-i
 *
 *  pairs will be cartesian product of i and j values, 0 and m/2 to be handled separately
 *
 */
public class CountPairModulo {
    public static void main(String[] args) {
        //int[] A = {4,7,6,5,3,8};
        int[] A = {2,3,4,8,6,15,5,12,17,7,18,10,9,16,21};
        int m = 6;
        int[] freq = new int[m];
        for(int a : A) {
            freq[a%m]++;
        }
        int ans=freq[0]*(freq[0]-1)/2;
        if (m%2==0) {
            ans+=freq[m/2]*(freq[m/2]-1)/2;
        }
        int l=1, r=m-1;
        while(l<r) {
            ans+=freq[l] * freq[r];
            l++;
            r--;
        }
        System.out.println(ans);
    }
}
