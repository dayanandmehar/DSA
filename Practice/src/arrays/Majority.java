package arrays;

import java.util.ArrayList;
import java.util.List;

public class Majority {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(5);
        a.add(7);
        int ans = Majority.repeatedNumber(a);
        System.out.println(ans);
    }
    // DO NOT MODIFY THE LIST
    public static int repeatedNumber(final List<Integer> a) {
        int majorityIndex = -1;
        int count =0;
        int n= a.size();
        for (int i=0; i<n; i++) {
            if(count==0) {
                majorityIndex = i;
                count++;
            } else {
                if (a.get(i).equals(a.get(majorityIndex))) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        System.out.println("majorityIndex: " + majorityIndex);
        if(count == 0) {
            return -1;
        }
        int freq=0;
        for (int i=0; i<n; i++) {
            if(a.get(i).equals(a.get(majorityIndex))) {
                freq++;
            }
        }
        if(freq > n/3) {
            return a.get(majorityIndex);
        } else {
            return -1;
        }
    }
}
