package first;

/**
 * das eine beliebige positive ganze Zahl n (long) einliest. 
 * Anschließend soll der folgende Wert (double) *Rechnung* (siehe Übung) berechnet und ausgegeben werden.
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 25.10.21
 */

public class Pi 
{
    public static void main(String[] args) 
    {
        System.out.println("Geben Sie eine positive Zahl (n) an um die Rechnung zu starten");
        long n = MyIO.readLong("n = ");

        double wert = 0;
        for(double i = n; 1 <= i; i--)
        {
            wert += 6/(i*i);
        }
        wert = Math.sqrt(wert);

        System.out.println("Das Ergebnis lautet " + wert);
    }   
}