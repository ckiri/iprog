package first;
/**
 * Filter
 * @author DMaric, DDeifel, DAgres, CKirakou
 * @version 1, 11.10.2021
 **/
import java.io.*;
import java.net.URL;

public class Filter {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr;
        BufferedReader keyboard;
        BufferedReader keyboard2;
        isr = new InputStreamReader(System.in);
        keyboard = new BufferedReader(isr);
        keyboard2 = new BufferedReader(isr);                                        //Input System


        String url;
        System.out.println("From which Website do you want to Filter?");
        url = keyboard.readLine();
        URL inputURL = new URL(url);                                                //Input URL

        FilterInputStream ins = (FilterInputStream) inputURL.openStream();
        InputStreamReader isr2 = new InputStreamReader(ins);
        BufferedReader website = new BufferedReader(isr2);
        String search = website.readLine();                                          // Website search tool

        String word;
        System.out.println("What is the Keyword you are searching for?");
        word = keyboard2.readLine();                                                 //Input Word

        while(search != null){                                                       //While Schleife
            if(search.contains(word)){
                System.out.println(search);
            }
                search = website.readLine();
        }
    }
}
