package arrays;

import java.util.*;

public class MaxConsecutiveCount {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
    public static int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int n : nums) {
            numsSet.add(n);
        }
        int maxCons = 1;
        for (int n : nums) {
            if (!numsSet.contains(n-1)) {
                int count = 1;
                while(numsSet.contains(n+count)) {
                    count++;
                }
                maxCons = Math.max(count, maxCons);
            }
        }
        return maxCons;
    }
}
