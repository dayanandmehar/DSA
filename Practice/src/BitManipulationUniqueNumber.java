public class BitManipulationUniqueNumber {

    // All numbers are repeating except 1. Find it
    public static void main(String []args) {
        int[] A = {1,2,4,2,1,4, 6};
        int ans = 0;
        // By doing XOR on all elements we can get the no repeating element
        // Duplicate element will become zero
        /*for (int i =0; i< A.length; i++) {
           ans = ans ^ A[i];
        }
        System.out.println(ans);*/

        // Another way

        for (int i=0; i<32; i++) {
            int count=0;

            for (int j=0; j<A.length;j++) {
                if (checkBit(A[j], i)) {
                    count++;
                }
            }

            if ((count & 1) == 1) {
                ans = ans | (1<<i);
            }
        }
        System.out.println(ans);
    }

    private static boolean checkBit(int a, int i) {
        return (a & (1 << i)) > 0;
    }
}
