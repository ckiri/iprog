package first;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EsreverLister {

    public static String invert (String x)
    {
        return x.length() <= 1 ? x :
                invert( x.substring(1) ) + x.substring(0,1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Ende mit potS.");
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String array[];
        for (int i = 0;i<100;i++){
            System.out.println("> ");
            // String s = keyboard.readLine();
            array[i] = keyboard.readLine();
            if (array[i] == null || array[i].equalsIgnoreCase("potS")){
                break;
            }
            // array[i] = keyboard.readLine();

        }
        System.out.println(invert(Arrays.toString(array)));
        keyboard.close();
    }
}
