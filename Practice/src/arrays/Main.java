package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<Integer> test = new ArrayList<Integer>();
        test.add(1);
        test.add(9);
        test.add(3);
        test.add(20);
        test.add(15);
        test.add(10);

        List<Integer> s = test.stream()
                .filter((element) -> { return element % 5 == 0;})
                .limit(5)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(s);
    }
}