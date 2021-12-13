package first;

/**
 * Der Benutzer wird aufgefordert, eine nichtnegative Zahl n (Typ int) einzugeben. 
 * Das Programm gibt dann alle Zahlen von 1 bis n hintereinander auf den Bildschirm aus, 
 * doch bei Vielfachen von 2 wird statt der Zahl Hen und bei Vielfachen von 5 wird statt der Zahl Dia 
 * und bei Vielfachen von 7 wird statt der Zahl Dyoin ausgegeben. 
 * Doch bei Zahlen, die ein Vielfaches von genau zwei der drei Zahlen 2, 5, 7 sind, wird statt der Zahl Corinna ausgegeben, 
 * und bei Vielfachen aller drei wird Booster ausgegeben. 
 * (Beginn einer Ausgabe ist dann etwa: 1 Hen 3 Hen Dia Hen Dyoin Hen 9 Corinna 11 Hen 13 Corinna Dia Hen 17 …)
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 06.12.2021
 */

public class Corinna 
{
    public static void main(String[] args) 
    {
        int n = MyIO.readInt("Eingabe einer positiven Zahl n = ");
        while( n < 1)
        {
            System.out.println("Fehler. Bitte versuche es nochmal.");
            n = MyIO.readInt("Eingabe einer positiven Zahl n = ");
        }
        
        System.out.println();
        for (int i = 1; i <= n; i++) 
        {
            if (i % 2 == 0 && i % 5 == 0 && i % 7 == 0) {System.out.print("Booster ");}    
            else if (i % 2 == 0 && i % 5 == 0) {System.out.print("Corinna ");}
            else if (i % 2 == 0 && i % 7 == 0) {System.out.print("Corinna ");}
            else if (i % 5 == 0 && i % 7 == 0) {System.out.print("Corinna ");}
            else if (i % 2 == 0) {System.out.print("Hen ");}
            else if (i % 5 == 0) {System.out.print("Dia ");}
            else if (i % 7 == 0) {System.out.print("Dyoin ");}
            else {System.out.print(i +" ");}
        }
    }
}