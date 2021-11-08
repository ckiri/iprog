package first;

/**
 * welches den größten gemeinsamen Teiler (ggT) zweier eingelesener positiver Zahlen x und y bestimmt und kommentiert ausgibt. 
 * Dies soll wiederholt werden, bis eine leere Eingabe erfolgt.
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 18.10.2021
 */

public class Ggt 
{
    public static int getGgt (int x, int y)
    {
        if( x == y || y == 0 ) return x;
        else return getGgt(y, x%y);
    } 

    public static void main (String[] args)
    {
        String eingabe = MyIO.promtAndRead("Erste Zahl: ");

        while( eingabe.length() > 0)
        {
            int x = Integer.parseInt(eingabe);
            int y = MyIO.readInt("Zweite Zahl: ");
            System.out.println( "Der größte gemeinsame Teiler von " + x + " und "+ y + " ist " + getGgt(x, y) );
            eingabe = MyIO.promtAndRead("Erste Zahl: ");
        }
        System.out.println("Ende");
    }
}