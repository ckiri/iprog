package first;

/**
 * Berechnung der 5. Wurzel von x
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 08.11.2021
 */

public class FifthRoot {
    public static double fifthRoot(double x) {
        int n = 1;
        int maxIterations = 10000;
        double maxError = 1e-10;
        double xn = 2.0;
        double xnPlus1 = 1;
        while (Math.abs((xnPlus1 - xn)) >= maxError && n < maxIterations) {
            xn = xnPlus1;
            xnPlus1 = xn - (xn*xn*xn*xn*xn-x) / (5*xn*xn*xn*xn); //Berechnung abgeändert zu ThirdRoot: xnPlus1 = xn - (x^5-x)/(5x^4)
            MyIO.writeln("n = " + n + ", xnPlus1 = " + xnPlus1); //Kontrollausgabe
            n = n+1;
        }
        return xnPlus1;
    }
    public static void main(String[] args) {
        double x = MyIO.readDouble("Wert von x: ");
        System.out.println(fifthRoot(x));
    }
}
