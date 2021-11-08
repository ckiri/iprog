package first;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class EsreverLister {

    public static String invert (String x)
    {
        return x.length() <= 1 ? x :
                invert( x.substring(1) ) + x.substring(0,1);            //Invert einer Line/Zeile
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Ende mit potS oder ^Z.");                                        //Message beim aufruf
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));      //Input reader
        List<String> WordList = new ArrayList<String>();                                     //ArrayList (s.38 - 43)
        for (;;){                                                                            //Always True for-schleife
            System.out.println("-> ");
            String s = keyboard.readLine();                                                  //Read Line String
            if (s == null || s.equalsIgnoreCase("potS")){
                break;                                                                       //If Null dann beenden
            }
            WordList.add(invert(s));                                                         //Hier wird die Invertierte String S zur WorteListe geaddet
            }

            ListIterator<String> x = WordList.listIterator(WordList.size());                 //nuer Iterator x mit worterliste
            while(x.hasPrevious()){
                System.out.println(x.previous());
            }                                                                                //While x noch zeilen hat dann drückt er sie

        System.out.println("Ende.");                                                         //Schluss ende
        keyboard.close();
    }
}
