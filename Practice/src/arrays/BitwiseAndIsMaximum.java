package arrays;

public class BitwiseAndIsMaximum {
    public static void main(String[] args) {
        int[] A = {5,4,6,8,5};
        int ans = 0;
        for (int i=31; i>=0; i--) {
            int count =0;
            for (int k : A) {
                if (checkBit(k, i)) {
                    count++;
                }
            }
            if (count>=2) {
                ans = ans | (1<<i);
                for(int j =0; j<A.length; j++) {
                    if(!checkBit(A[j], i)) {
                        A[j] = 0;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static boolean checkBit(int a, int i) {
        return (a & (1<<i)) > 0;
    }
}
