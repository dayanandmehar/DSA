package arrays;

import java.util.ArrayList;

public class KthSmallestElement {
    public static void main(String [] args) {
        final ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(2);
        A.add(1);
        A.add(4);
        A.add(3);
        A.add(2);
        A.add(5);
        int B = 3;
        int ans = KthSmallestElement.kthsmallest(A, B);

    }
    static public int kthsmallest(final ArrayList<Integer> A, int B) {
        for (int i=0; i<B; i++) {
            int minInd = i;
            for (int j = i+1; j< A.size(); j++) {
                if (A.get(minInd) > A.get(j)) {
                    minInd = j;
                }
            }
            if (minInd != i) {
                A.add(i, A.get(i)+A.get(minInd));
                A.add(minInd, + A.get(i)-A.get(minInd));
                A.add(i, A.get(i) - A.get(minInd));
            }
        }
        return A.get(B-1);
    }
}
