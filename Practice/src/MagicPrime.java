import java.util.ArrayList;
import java.util.List;

public class MagicPrime {
    public static void main(String[] args) {
        int[] a = {3, 6,15,16};
        System.out.println(solve(a));
    }
        public static int solve(int[] A) {
            int n = A.length;
            int maxValue = A[0];
            for (int a : A) {
                maxValue = Math.max(maxValue, a);
                System.out.println("arr: " + a);
            }
            int[] spf = new int[maxValue+1];
            for (int i=0; i<=maxValue; i++) {
                spf[i] = i;
            }
            for (int i=2; i*i<=maxValue; i++) {
                if (spf[i] == i) {
                    for (int j = i*i; j<=maxValue; j+=i ) {
                        if (spf[j] == j) {
                            spf[j] = i;
                        }
                    }
                }
            }
            int ans = A[0];
            int currFact = 0;
            for (int a : A) {
                int factors = 0;
                int temp = a;
                while (temp!=1) {
                    int s = spf[temp];
                    while (temp%s==0) {
                        temp= temp/s;
                    }
                    factors++;
                }
                if (currFact < factors || (currFact == factors && ans < a)) {
                    ans = a;
                    currFact = factors;
                }
            }
            return ans;
        }
    }
