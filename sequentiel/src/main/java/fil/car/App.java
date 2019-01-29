package fil.car;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // String arg = "This is a text with a word in two occurences, well actually 3 ! a";
        if (args == null || args.length == 0) {
            System.err.println("Argument needed: absolute_path_to_file");
            System.exit(-1);
        }
        if (args[0].isEmpty()) {
            System.err.println("Argument needed: absolute_path_to_file");
            System.exit(-1);
        }
        Map<String, Integer> count = new HashMap<>();
        String[] result = args[0].split("\\s");
        for (int i = 0; i < result.length; i++) {
            if (count.containsKey(result[i])) {
                int val = count.get(result[i]);
                count.put(result[i], ++val);
            } else {
                count.put(result[i], 1);
            }
        }
        Map.Entry<String, Integer> maxEntry = null;

        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        String maxi = maxEntry.getKey();
        System.out.println(maxi + " is present in " + maxEntry.getValue() + " occurence(s)");
    }
}
