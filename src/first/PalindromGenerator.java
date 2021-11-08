package first;

import java.io.*;

/**
 *
 * @author Dennis Deifel, Denis Maric, Dominik Agres, Chris Kiriakou
 * @version 1, 12.10.2021
 **/

public class PalindromGenerator{

    public static String invert(String h){

        return h.length()<= 1 ? h :
                invert(h.substring(1)) + h.substring(0, 1);                                 //invert method
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader isr;
        BufferedReader keyboard;
        BufferedReader keyboard2;
        isr = new InputStreamReader(System.in);
        keyboard = new BufferedReader(isr);
        keyboard2 = new BufferedReader(isr);                                                // Input for 2 texts

        System.out.println("Text 1:");
        String text1 = keyboard.readLine();
        System.out.println("Text 2:");
        String text2 = keyboard2.readLine();                                                // Text Input and question

        String[] array;                                                                     //arrays
        array = new String[7];
        array[0] = text1;
        array[1] = text2;

        array[2] = array[0]+array[1] + invert(array[1])+invert(array[0]);
        array[3] = array[1]+array[0] + invert(array[0]) + invert(array[1]);
        array[4] = invert(array[0]) + invert(array[1]) + array[1] + array[0];
        array[5] = invert(array[1]) + invert(array[0]) + array[0] + array[1];
        array[6] = invert(array[0]) + array[1] + invert(array[1]) + array[0];

        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
        System.out.println(array[5]);
        System.out.println(array[6]);                                                       //Palindrom generator

        File f = new File("src/first/palindrom.txt");
        PrintStream target = new PrintStream(new FileOutputStream(f));
        target.println(array[2]);
        target.println(array[3]);
        target.println(array[4]);
        target.println(array[5]);
        target.println(array[6]);                                                           //input file
    }

}
