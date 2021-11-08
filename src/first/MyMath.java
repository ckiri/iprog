package first;

/**
 * Mathe Programm
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 3, 08.11.2021
 */

public class MyMath 
{    
    public static String catAll(int... x) 
    {
        String s = x.length == 0 ? "[" : "[" + x[0];
        for (int i = 1; i < x.length; i++) { s += "," + x[i]; }
        return s + "]";
    }

    public static String catAll(long... x) 
    {
        String s = x.length == 0 ? "[" : "[" + x[0];
        for (int i = 1; i < x.length; i++) { s += "," + x[i]; }
        return s + "]";
    }

    public static String catAll(float... x) 
    {
        String s = x.length == 0 ? "[" : "[" + x[0];
        for (int i = 1; i < x.length; i++) { s += "," + x[i]; }
        return s + "]";
    }

    public static String catAll(double... x) 
    {
        String s = x.length == 0 ? "[" : "[" + x[0];
        for (int i = 1; i < x.length; i++) { s += "," + x[i]; }
        return s + "]";
    }

    public static int addAll(int... x) 
    {
        int a = 0;
        for (int i:x) { a += i;}
        return a;
    }

    public static long addAll(long... x) 
    {
        long a = 0;
        for (long i:x) { a += i;}
        return a;
    }

    public static double addAll(double... x) 
    {
        double a = 0;
        for (double i:x) { a += i;}
        return a;
    }

    public static int multiplyAll(int... x) 
    {
        int m = 1;
        for (int i:x) { m = m * i;}
        return m;
    }

    public static long multiplyAll(long... x) 
    {
        long m = 1;
        for (long i:x) { m = m * i;}
        return m;
    }

    public static double multiplyAll(double... x) 
    {
        double m = 1;
        for (double i:x) { m = m * i;}
        return m;
    }

    public static int max(int... x)
    {
        int max = Integer.MIN_VALUE;
        for(int i : x) { max = max <= i ? i : max; }
        return max;
    }

    public static long max(long... x)
    {
        long max = Long.MIN_VALUE;
        for(long i : x) { max = max <= i ? i : max; }
        return max;
    }

    public static float max(float... x)
    {
        float max = Float.MIN_VALUE;
        for(float i : x) { max = max <= i ? i : max; }
        return max;
    }

    public static double max(double... x)
    {
        double max = Double.MIN_VALUE;
        for(double i : x) { max = max <= i ? i : max; }
        return max;
    }

    public static int min(int... x)
    {
        int min = Integer.MAX_VALUE;
        for(int i : x) { min = min >= i ? i : min; }
        return min;
    }

    public static long min(long... x)
    {
        long min = Long.MAX_VALUE;
        for(long i : x) { min = min >= i ? i : min; }
        return min;
    }

    public static float min(float... x)
    {
        float min = Float.MAX_VALUE;
        for(float i : x) { min = min >= i ? i : min; }
        return min;
    }

    public static double min(double... x)
    {
        double min = Double.MAX_VALUE;
        for(double i : x) { min = min >= i ? i : min; }
        return min;
    }

    public static boolean isPrime(long n)
    {
        if( n < 2 )
        {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) 
        {
            if( n % i == 0 ) 
            { 
                return false;
            }     
        }
        
        return true;
    }

    public static long nextPrime(long n) 
    {
        n++;
        while(!isPrime(n))
        {
            n++;
        }
        return n;
    }

    public static void main (String[] args) 
    {
        int[] aryInt = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
        long[] aryLong = {1L,2L,3L,4L,5L,6L,7L,8L,9L,10L,11L,12L,13L,14L,15L,16L,17L,18L,19L,20L,21L};
        double[] aryDouble = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};

        //int[] aryInt2 = {12, 5, 789, 99, -120, -4, 67, 69, 420};
        //long[] aryLong2 = {12L, 5L, 789L, 99L, -120L, -4L, 67L, 69L, 420L, 3678678345L, -2945546375L};
        //double[] aryDouble2 = {12, 34, 678.78, 78, 89, 78, 33.324, 89,44, -120.45};

        System.out.println("Wir berechnen Summen und Produkte in verschiedenen Datentypen");
        System.out.println("und geben zusätzlich die größte und kleinste Zahl aus.");

        System.out.println("\nint");
        System.out.println( "Die Summe von " + catAll(aryInt) + " ist " + addAll(aryInt) + "." );
        System.out.println( "Das Produkt von " + catAll(aryInt) + " ist " + multiplyAll(aryInt) + "." );
        System.out.println( "Die größte Zahl von " + catAll(aryInt) + " ist " + max(aryInt) + ".");
        System.out.println( "Die kleinste Zahl von " + catAll(aryInt) + " ist " + min(aryInt) + ".");
        //System.out.println( "+Die größte Zahl von " + catAll(aryInt2) + " ist " + max(aryInt2) + ".");
        //System.out.println( "+Die kleinste Zahl von " + catAll(aryInt2) + " ist " + min(aryInt2) + ".");

        System.out.println("\nlong");
        System.out.println( "Die Summe von " + catAll(aryLong) + " ist " + addAll(aryLong) + "." );
        System.out.println( "Das Produkt von " + catAll(aryLong) + " ist " + multiplyAll(aryLong) + "." );
        System.out.println( "Die größte Zahl von " + catAll(aryLong) + " ist " + max(aryLong) + ".");
        System.out.println( "Die kleinste Zahl von " + catAll(aryLong) + " ist " + min(aryLong) + ".");
        //System.out.println( "+Die größte Zahl von " + catAll(aryLong2) + " ist " + max(aryLong2) + ".");
        //System.out.println( "+Die kleinste Zahl von " + catAll(aryLong2) + " ist " + min(aryLong2) + ".");

        System.out.println("\ndouble");
        System.out.println( "Die Summe von " + catAll(aryDouble) + " ist " + addAll(aryDouble) + "." );
        System.out.println( "Das Produkt von " + catAll(aryDouble) + " ist " + multiplyAll(aryDouble) + "." );
        System.out.println( "Die größte Zahl von " + catAll(aryDouble) + " ist " + max(aryDouble) + ".");
        System.out.println( "Die kleinste Zahl von " + catAll(aryDouble) + " ist " + min(aryDouble) + ".");
        //System.out.println( "+Die größte Zahl von " + catAll(aryDouble2) + " ist " + max(aryDouble2) + ".");
        //System.out.println( "+Die kleinste Zahl von " + catAll(aryDouble2) + " ist " + min(aryDouble2) + ".");

        float[] aryFloat = {1f,2f,3f,4f,5f,6f,7f,8f,9f,10f,11f,12f,13f,14f,15f,16f,17f,18f,19f,20f,21f};
        //float[] aryFloat2 = {12f, 34f, 678.78f, 78f, 89f, 78f, 33.324f, 89,44f, -120.45f};
        System.out.println("\nfloat");
        System.out.println( "Die größte Zahl von " + catAll(aryFloat) + " ist " + max(aryFloat) + ".");
        System.out.println( "Die kleinste Zahl von " + catAll(aryFloat) + " ist " + min(aryFloat) + ".");
        //System.out.println( "+Die größte Zahl von " + catAll(aryFloat2) + " ist " + max(aryFloat2) + ".");
        //System.out.println( "+Die kleinste Zahl von " + catAll(aryFloat2) + " ist " + min(aryFloat2) + ".");

        System.out.println();
        for(long i = 1; i <= 8; i++)
        {
            if( isPrime(i)) { System.out.println( i + " ist eine Primzahl.");}
            else { System.out.println( i + " ist keine Primzahl.");}
        }

        System.out.println();
        String eingabe = MyIO.promtAndRead("Nächst größte Primzahl bestimmen: ");
        while( eingabe.length() > 0)
        {
            long n = Long.parseLong(eingabe);
            System.out.println("Die nächst größte Primzahl nach " + n + " ist " + nextPrime(n));
            System.out.println();
            eingabe = MyIO.promtAndRead("Nächst größte Primzahl bestimmen: ");
        }
        System.out.println("Ende");
    }
}