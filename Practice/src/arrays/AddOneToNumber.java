package arrays;

import java.util.ArrayList;

public class AddOneToNumber {
    public static void main(String[] args) {
        ArrayList<Integer> in = new ArrayList<Integer>();
        in.add(0);
        ArrayList<Integer> out = AddOneToNumber.plusOne(in);
        for (Integer a : out) {
            System.out.println(a);
        }
    }
    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int n = A.size();
        while(A.get(0)==0 && n>1){
            A.remove(0);
        }
        n = A.size();
        int carry=1;
        for (int i=n-1; i>=0; i--) {
            int sum = A.get(i) + carry;
            System.out.println("Element: " + sum % 10);
            A.set(i, sum % 10);
            carry = sum / 10;
            System.out.println("Carry: " + carry);
        }
        if (carry > 0) {
            A.add(0, carry);
        }
        return A;
    }
}

