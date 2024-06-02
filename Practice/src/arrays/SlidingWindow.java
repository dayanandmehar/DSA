package arrays;

import java.util.ArrayList;
public class SlidingWindow {
    // Find minimum number of swaps required to get all numbers less than B
    // adjuscent to each other
    // Given Array A and integer B
    /*First, count the number of elements <= B. Let the count comes out to be X.

    Create a window of first X elements. To find the number of swaps to bring all elements <= B together in the first window,
    you just need to find count of elements > B in first window.
    So, count of swaps required in 1 window = count of elements greater than B in that window.

    For every window, find the count of elements greater than B, using sliding window technique.

    Time Complexity: O(N)
    Space Complexity: O(1)

     */
    public int solve(ArrayList<Integer> A, int B) {
        int count = 0;

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) <= B) {
                count++;
            }
        }
        int minSwaps = count;

        if (count <= 1) {
            minSwaps = 0;
        } else {
            int l = 0, r = 0, elementsToBeReplaced = 0;
            while (r < count) {
                if (A.get(r) > B) {
                    elementsToBeReplaced++;
                }
                r++;
            }
            while (r < A.size()) {
                if (A.get(l) > B) {
                    elementsToBeReplaced--;
                }
                if (A.get(r) > B) {
                    elementsToBeReplaced++;
                }
                if (elementsToBeReplaced < minSwaps) {
                    minSwaps = elementsToBeReplaced;
                }
                r++;
                l++;
            }
        }
        return minSwaps;
    }
}
