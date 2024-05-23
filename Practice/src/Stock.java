public class Stock {
    /*
    Given an prices[] of length N, representing the prices of the stocks on
    different days, the task is to find the maximum profit possible by buying and selling
    the stocks on different days when at most one transaction is allowed.
     */
    public static void main(String[] args) {
        int[] st = {1,2,4,7,9,8};
        int n = st.length;
        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n;j++) {
                ans =  Math.max(ans, st[j]-st[i]);
            }
        }
        System.out.println(ans);
    }
}
