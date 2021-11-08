package first;

/**
 * das beliebig viele Zahlwörter (also Strings) - eins, zwei, drei, vier, ..., neunundzwanzig - lesen kann 
 * und nach Eingabe des leeren Strings ihr kgV korrekt als Zahl ausgibt.
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 08.11.2021
 */

public class WordLcm 
{
    public static long getGgt (long x, long y) 
    {
        if( x == y || y == 0 ) return x;
        else return getGgt(y, x%y);
    }

    public static void main(String[] args) 
    {
        String eingabe = MyIO.promtAndRead("Erstes Zahlenwort: ").trim(); 
        long zahl = 1, kgv = 1;

        while(eingabe.length() > 0)
        {
            switch(eingabe)
            {
                case "eins": zahl = 1; break;
                case "zwei": zahl = 2; break;
                case "drei": zahl = 3; break;
                case "vier": zahl = 4; break;
                case "fuenf": zahl = 5; break;
                case "sechs": zahl = 6; break;
                case "sieben": zahl = 7; break;
                case "acht": zahl = 8; break;
                case "neun": zahl = 9; break;
                case "zehn": zahl = 10; break;
                case "elf": zahl = 11; break;
                case "zwoelf": zahl = 12; break;
                case "dreizehn": zahl = 13; break;
                case "vierzehn": zahl = 14; break;
                case "fuenfzehn": zahl = 15; break;
                case "sechzehn": zahl = 16; break;
                case "siebzehn": zahl = 17; break;
                case "achtzehn": zahl = 18; break;
                case "neunzehn": zahl = 19; break;
                case "zwanzig": zahl = 20; break;
                case "einundzwanzig": zahl = 21; break;
                case "zweiundzwanzig": zahl = 22; break;
                case "dreiundzwanzig": zahl = 23; break;
                case "vierundzwanzig": zahl = 24; break;
                case "fuenfundzwanzig": zahl = 25; break;
                case "sechsundzwanzig": zahl = 26; break;
                case "siebenundzwanzig": zahl = 27; break;
                case "achtundzwanzig": zahl = 28; break;
                case "neunundzwanzig": zahl = 29; break;
                default: System.out.println("Ungültige Zahl nur 1 bis 29");
            }
            kgv = kgv * zahl / getGgt(kgv, zahl);

            eingabe = MyIO.promtAndRead("Nächstes Zahlenwort: ").trim();
        }

        System.out.println("Das KgV der eingegebenen Zahlen ist: " + kgv);
    }
}