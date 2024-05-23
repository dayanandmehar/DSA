import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MapTest {
    /*
    Input:: List of Strings values like

Registration1:api1
Registration1:api2
Registration1:api3
Registration1:api4
Registration2:api1
Registration2:api2
Registration2:api5


Map
Registration1, [api1, api2,api3,api4]
Registration2, [api1, api2,api5]
     */

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>();
        input.add("Registration1:api1");
        input.add("Registration1:api2");
        input.add("Registration1:api3");
        input.add("Registration1:api4");
        input.add("Registration2:api1");
        input.add("Registration2:api2");
        input.add("Registration2:api5");
        input.add("Registration3:api6");
        input.add("Registration1:api5");


        HashMap<String, ArrayList<String>> out = new HashMap<String, ArrayList<String>>();
        for (String str : input) {
            String[] strArray = str.split(":");
            String key = strArray[0];
            String value = strArray[1];
            if (out.containsKey(key)) {
                ArrayList<String> v = out.get(key);
                v.add(value);
                out.put(key, v);
            } else {
                ArrayList<String> v = new ArrayList<>();
                v.add(value);
                out.put(key, v);
            }
        }

        System.out.println(out);
    }
}
