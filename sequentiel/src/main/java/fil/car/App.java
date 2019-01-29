package fil.car;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        File f = new File(args[0]);
        try {
            BufferedReader bdr = new BufferedReader(new FileReader(f));
            List<String> str = bdr.lines().collect(Collectors.toList());
            StringBuilder tmp = new StringBuilder();
            for (String s :
                    str) {
                tmp.append(s).append("\n");
            }
            String[] result = tmp.toString().split("\\s");
            App a = new App();
            System.out.println(a.maxOccu(result) + " is present in the most occurence(s)");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String maxOccu(String[] result){
        Map<String, Integer> count = new HashMap<>();
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

        return maxEntry.getKey();
    }
}
