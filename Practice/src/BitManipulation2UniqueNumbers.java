public class BitManipulation2UniqueNumbers {

    // All numbers are repeating except 2 numbers. Find those.
    public static void main(String []args) {
        int[] A = {4, 5, 4, 1, 6, 6, 5, 2};
        int num1 = 0;
        int num2 = 0;

        int n = A.length;
        int xorAll = 0;
        for (int i = 0; i < n; i++) {
            xorAll = xorAll ^ A[i];
        }
        int pos = 0;
        for (int i = 0; i < 32; i++) {
            if (checkBit(xorAll, i)) {
                pos = i;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (checkBit(A[i], pos)) {
                num1 = num1 ^ A[i];
            } else {
                num2 = num2 ^ A[i];
            }
        }
        System.out.println(num1 + " " + num2);
    }

    private static boolean checkBit(int a, int i) {
        return (a & (1 << i)) > 0;
    }
}
