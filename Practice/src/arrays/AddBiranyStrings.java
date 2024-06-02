package arrays;

public class AddBiranyStrings {
    public static void main(String[] args) {
        String ans = AddBiranyStrings.addBinary("1010110111001101101000", "1000011011000000111100110");
        System.out.println(ans);
        // 0001010110111001101101000 - A
        // 1000011011000000111100110 - B
        // 1001110001111010101001110 - Expected ans
        // 1001110001111010101001110 - our ans
    }
    public static String addBinary(String A, String B) {
        int aSize = A.length();
        int bSize = B.length();
        if(aSize > bSize) {
            B = appendZero((aSize-bSize), B);
            System.out.println("Updated B: " + B);
        } else if(bSize > aSize) {
            A = appendZero((bSize-aSize), A);
            System.out.println("Updated A: " + A);
        }

        int carryForward = 0;
        String ans = "";
        for (int i=A.length()-1; i>=0; i--) {
            int sum = Integer.parseInt(String.valueOf(A.charAt(i))) + Integer.parseInt(String.valueOf(B.charAt(i))) + carryForward;
            System.out.println(i + " " + sum);
            ans = (sum % 2) + ans;
            carryForward = sum / 2;
            System.out.println("ans: " + ans + " carry: " + carryForward);
        }
        if (carryForward > 0) {
            ans = carryForward + ans;
        }
        return ans;
    }

    private static String appendZero(int count, String str) {
        while(count > 0) {
            str =  "0" + str;
            count--;
        }
        return str;
    }
}
