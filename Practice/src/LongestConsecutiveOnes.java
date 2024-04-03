//Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.
public class LongestConsecutiveOnes {
    public static void main(String []args) {
        int ans = LongestConsecutiveOnes.solve("0000000000000000");
        System.out.println("ans: " + ans);
    }
    public static int solve(String A) {
        int totalOnes =0, n=A.length(), ans=0;
        for (int i=0; i<n; i++) {
            if (A.charAt(i) == '1') {
                totalOnes++;
            }
        }
        System.out.println("totalOnes: " + totalOnes);
        if (totalOnes == n) {
            return n;
        }
        for (int i=0; i<n; i++) {
            if (A.charAt(i) == '0') {
                int lcount=0, rcount=0;
                int l = i-1, r=i+1;
                while (l >= 0) {
                    if (A.charAt(l) =='0') {
                        break;
                    }
                    lcount++;
                    l--;
                }
                while (r < n) {
                    if (A.charAt(r) =='0') {
                        break;
                    }
                    rcount++;
                    r++;
                }
                int sum=0;
                if((rcount+lcount) == totalOnes) {
                    sum = rcount+lcount;
                } else {
                    sum = rcount+lcount+1;
                }
                if (sum > ans) {
                    ans = sum;
                }
            }
        }
        return ans;
    }
}
