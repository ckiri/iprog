package first;

/**
 * das mit einer ganzen Zahl n zwischen 0 und 45 als Aufrufparameter gestartet werden kann 
 * und Ihren Namen wiederholt und gewunden wie bei einer Schnecke in einer Matrix der Größe n×n 
 * wie in den folgenden Beispielen für n=6 , n=11 und n=14 ausgibt: (siehe Übungsaufgabe)
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 15.11.2021
 */

public class Schnecke
{
    public static void main(String[] args) 
    {
        int n = MyIO.readInt("Wählen Sie eine Zahl zwischen 0 und 45: ");
        
        //Inkremente fuer Richtung: Zeile, Spalte
        int[][] inc = {
                { -1, 0 },  //hoch
                { 0, 1 },   //rechts
                { 1, 0 },   //runter
                { 0, -1 }   //links
        };

        String[][] matrix = new String[n][n];       //Matrix von Strings, erst mal leer
        String name = "Dennis_Deifel_";
        int ni = 0;                     //Index der nächsten Zeichens in name
        int dir = 0;                    //Richtung 0:hoch 1:rechts 2:runter 3:links
        int actlen = n;                 //aktuelle Laenge einees zu schreibenden Stirngs
        int diff = -1;                  //Differenz zur nächsten Laenge
        int i = n, j = 0;               //i:Zeilenindex j:Spaltenindex in matrix; Startposition

        while(true)
        {
            //Schreibt eine Kante der Schnecke in die Matrix
            for (int k = 1; k <= actlen; k++, ni = (ni + 1) % name.length())
            {
                matrix[i += inc[dir][0]][j += inc[dir][1]] = name.substring(ni, ni + 1);
            }
            if (actlen <= 1)
            {
                break;      //letzte Laenge ist 1 oder 2, dann fertig
            }
            dir = (dir + 1) % 4;            //Richtungsaenderung
            actlen += diff;                 //neue Laenge
            diff = diff == 0 ? -2 : 0;      //Naechste Differenz: abwechselnd 0, -2
        }

        System.out.println("  ");
        for (int k = 0; k < n; k++) //Ausgabe der Matrix auf Konsole ...
        {
            System.out.print("  ");
            for (int l = 0; l < n; l++)
            {
                System.out.print(matrix[k][l] == null ? " " : matrix[k][l]);
            }
            System.out.println();
        }

        /**                             //Eigener Versuch
        int z = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if( z >= name.length) { z = 0;}
                matrix[i][j] = String.valueOf(name[z++]);
            }
        }

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        */
    }    
}