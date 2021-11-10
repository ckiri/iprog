package first;

/**
 * das die sin-Funktion für einen eingelesenen x-Wert entsprechend dieser Summe approximiert und ausgibt:
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 08.11.2021
 */

public class Sinus 
{
    public static double sin(long x)
    {
        int k = 1;      //k Variable
        int n = 0;      //Zähler Iteration
        double maxIterations = 10000;   //Parameter maxIteration
        double maxError = 1e-10;        //Parameter max error
        double xn = x;                  //(long) redundant, x ist long
        double xnPlus1 = x;

        int i = 0;  //Zähler

        //Hier: xn und xnPlus1 haben den Wert x

        do{
            xn = xnPlus1;
            xnPlus1 = xn + ( (-1) * x * x / (2*k) / ((2 * k) +1));     //xnPlus1 = formel ?  x ist long / Zahlen und k sind int
            n++; k++;

            System.out.println(i); i++;         //Zähler, später löschen

        } while(Math.abs(xnPlus1-xn) >= maxError && n < maxIterations);

        return xnPlus1;     //return ???
    }

    public static void main(String[] args) 
    {
        long x = MyIO.readLong("x = ");
        System.out.println(sin(x));

    }   
}