package first;

/**
 * die Namen der Mitglieder ihrer Übungsgruppe ausgibt (alle in einer Zeile). 
 * Dabei soll eine Methode zum Verketten beliebig vieler (mindestens 10) Strings zum Einsatz kommen.
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 04.10.2021
 */

public class VorstellungEinzeilig 
{
    public static String verketten(String[] n, int l)
    {
        return l <= 1 ? n[l-1] : verketten(n, l-1).concat(" ").concat( n[l-1] );
    }

    public static void main (String[] args)
    {
        String[] name = {"DennisDeifel", "DenisMaric", "DominikAgres", "ChrisKiriakou"};
		System.out.println( verketten(name, name.length) );
    }
}
