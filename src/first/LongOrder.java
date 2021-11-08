package first;

/**
 * das 3 Zahlen (long) einliest und in aufsteigender Reihenfolge wieder ausgibt, die kleinste Zahl zuerst, die größte zuletzt. 
 * Können Sie das Programm auch so verändern, dass vier Zahlen korrekt sortiert werden?
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 08.11.2021
 */

public class LongOrder 
{
    public static void main(String[] args) 
    {
        System.out.println("Zu sortierende Zahlen eingeben.");
        long[] x = new long[4];
        x[0] = MyIO.readLong("Erste Zahl: ");
        x[1] = MyIO.readLong("Zweite Zahl: ");
        x[2] = MyIO.readLong("Dritte Zahl: ");
        x[3] = MyIO.readLong("Vierte Zahl: ");
        long tausch;
        
        for(int i = 1; i < 4; i++)
        {
            for(int j = 0; j < 4-i; j++)
            {
                if( x[j] > x[j+1])
                {
                    tausch = x[j];
                    x[j] = x[j+1];
                    x[j+1] = tausch;
                }
            }
        }

        System.out.println("Sortierte Zahlen: " + x[0] + ", " + x[1] + ", " + x[2] + ", " + x[3]);
    }
}