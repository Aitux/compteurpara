package fil.car;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        args[0] = "This is a text with a word in two occurences, well actually 3 ! a";
        if(args[0] == null || args[0].isEmpty()){
            System.err.println("Argument needed: absolute_path_to_file");
            System.exit(-1);
        }
        Map<String, Integer> count = new HashMap<>();
        String[] result = args[0].split("\\s");
        for(int i = 0 ; i < result.length;i++){
            if(count.containsKey(result[i]))
            {
                int val = count.get(result[i]);
                count.put(result[i], ++val);
            }

            
        }
    }
}
