package streams;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequency {
    public static void main(String[] args) {
        List<String> wordsList = Lists.newArrayList("hello", "bye", "ciao", "bye", "ciao");
        Map<String,Long> collect = wordsList.stream()
                .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ));
        System.out.println(collect);
    }
}
