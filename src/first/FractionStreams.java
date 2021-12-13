package first;

import java.util.*;

public class FractionStreams
{
    public static void main(String[] args) 
    {
        Comparable fractionList;

        long[] arrayA = new long[29];
        long[] arrayB = new long[29];
        
        for (int i = -14; i <= 14 ; i++) 
        {
            for (int j = -14; j <= 14; j++) 
            {
                fractionList.add(new Fraction(arrayA[i], arrayB[j]));             
            }    
        }

        fractionList.stream().distinct().forEach(System.out::println);
        bubbleSort(fractionList[]);
    }

    public static void bubbleSort(ArrayList[] p) 
    {
        boolean sorted;
        do 
        {
            sorted = true;
            for (int i = 0; i < p.length-1; i++) 
            {
                if (p[i].compareTo(p[i+1]) > 0)
                {
                    Fraction tmp = p[i];
                    p[i] = p[i+1];
                    p[i+1] = tmp;
                    sorted = false;
                }
            }
        } while (!sorted);   
    }
}