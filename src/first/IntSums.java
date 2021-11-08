package first;

/**
 * Welches Methoden addAll besitzt, so dass damit die Summe von mindestens 10 ganzen Zahlen korrekt berechnet werden kann.
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 04.10.2021
 */

public class IntSums 
{
    public static int addAll(int[] a, int l)
    {
        return l <= 1 ? a[l-1] : a[l-1] + addAll(a, l-1);
    }

    public static void main (String[] args)
    {
        int[] Sequenz1 = {2,3,5,7,11,13,17,19,23,29};
        int[] Sequenz2 = {3,5,11,17,31,41,59,67,83,109};
        int[] Sequenz3 = {5,11,31,59,127,179,277,331,431,599};

        System.out.println( addAll(Sequenz1, Sequenz1.length) );
        System.out.println( addAll(Sequenz2, Sequenz2.length) );
        System.out.println( addAll(Sequenz3, Sequenz3.length) );
    }
}
