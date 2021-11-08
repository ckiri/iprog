package first;

/**
 * das Sterne in Form eines Dreiecks ausgibt. Der Anwender gibt nach Aufforderung die Zahl n für die Anzahl der Zeilen ein 
 * und das Programm gibt n Zeilen mit Sternen in Dreiecksform aus.
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 25.10.2021
 */

public class Triangle 
{
    public static void main(String[] args)
    {
        System.out.println("Wie viele Zeilen soll das Dreieck haben?");
        int n = MyIO.readInt("Zeilen = ");
        int anz = 0;
        
        for(int i = n; i > 0; i--)
        {
            for(int j = 0; j < n - i; j++)
            {
                System.out.print(" ");
            }

            for(int j = i; j > 0; j--)
            {
                System.out.print("* ");
                anz++;
            }

            System.out.println();
        }

        System.out.println(n + " Zeilen und " + anz + " Sterne.");
    }
}