package streams;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List number = Arrays.asList(2,3,5,4);
        //List sort = (List)number.stream().sorted().collect(Collectors.toList());
        number.stream().sorted().forEach((x -> System.out.println(x)));

        //List square = (List)number.stream().map(x->(int)x*(int)x).collect(Collectors.toList());
        number.stream().map(x->(int)x*(int)x).forEach(y -> System.out.println(y));

        //int even = number.stream().filter(x -> (int)x % 2 == 0).reduce(0, (ans, i) -> ans + i);
    }
}
