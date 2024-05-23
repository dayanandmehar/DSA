public class DeleteOneGCD {
    /*
    Given Arr[N]. Find maximum GCD after deleting one element of an array.
    gcd(i) = gcd (gcd(0 to i-1), gcd(i+1 to n-1)
    gcd is calculating at range for multiple times. This can be achieved using Prefix gcd and suffix gcd
    steps.
    1. Calculate prefix gcd and suffix gcd
    2. gcd after deleting i = gcd(pgcd(i-1), sgcd(i+1))
    3. ans = max(ans, step2)

     */
    public static void main(String[] args) {
        int[] A= {24,16,18,30,15};
        int n = A.length;
        int[] pgcd = new int[n];
        int[] sgcd = new int[n];
        pgcd[0] = A[0];
        for (int i=1; i<n; i++) {
            pgcd[i] = gcd(pgcd[i-1], A[i]);
        }
        sgcd[n-1] = A[n-1];
        for (int i=n-2; i>=0; i--) {
            sgcd[i] = gcd(sgcd[i+1], A[i]);
        }
        int ans = sgcd[1];
        for(int i=1; i<n; i++) {
            if (i==n-1) {
                ans = Math.max(ans,pgcd[i-1]);
            } else {
                ans = Math.max(ans, gcd(pgcd[i - 1], sgcd[i + 1]));
            }
        }
        System.out.println(ans);
    }

    /**
     * Method to generate GCD value for given two integers
     *
     * @param a
     * @param b
     * @return gcd
     */
    private static int gcd(int a, int b) {
        if (b==0)
            return a;
        return gcd(b, a%b);
    }
}

