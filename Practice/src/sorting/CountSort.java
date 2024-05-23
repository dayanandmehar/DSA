package sorting;

import java.util.ArrayList;
import java.util.List;

public class CountSort {
    public static void main(String[] args) {
        int[] A= {2,0,0,1,0,0,2,2,1,1,0,0,1,0,2,1,1,0,1,0,1,2,2,2,0,0,1,0,2,1,1,2,1,2,2,1,0,2,2,1,1,1,0,1,0,1,0,2,1,2,0,2,0,1,1,0,2,2,1,2,0,2,1,1,1,2,0,1,0,2,2,1,0,0,1,0,1,0,0,0,1,2,1,1,0,2,1,2,0,0,0,2,2,2,2,0,0,0,1,1,0,2,1,2,2,2,1,2,2,0,1,0,1,2,1,1,0,1,2,0,1,0,2,2,1,2,1,0,2,2,1,1,0,2,1,2,};
        List<Integer> out = sortColors(A);
        System.out.println(out);
    }
    public static ArrayList<Integer> sortColors(int[] A) {
        //Collections.sort(A);
        // Implementing using count sort
        int[] far = new int[3];
        for (Integer a : A) {
            far[a]++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i=0; i<far.length; i++) {
            for (int j=0; j<far[i]; j++) {
                ans.add(i);
            }
        }
        return ans;
    }
}
