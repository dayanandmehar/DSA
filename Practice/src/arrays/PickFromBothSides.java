package arrays;

class PickFromBothSides {
    public static void main(String[] args) {
        int[] A = {2, 3, 4, 3,4,4,1 };
        int B = 6;
        PickFromBothSides s = new PickFromBothSides();
        int ans = s.solve(A,B);
        System.out.println(ans);

    }
    public int solve(int[] A, int B) {
        int n = A.length;
        int[] PF = new int[n];
        PF[0] = A[0];
        for (int i = 1; i < n; i++) {
            PF[i] = PF[i - 1] + A[i];
        }
        if (B == n) {
            return PF[n - 1];
        }
        int ans = PF[n - 1] - PF[n - B - 1];
        for (int i = 1; i <= B; i++) {
            int sum = PF[i - 1] + PF[n - 1] - PF[n - (B - i) - 1];
            if (sum > ans) {
                ans = sum;
            }
        }
        return ans;
    }
}