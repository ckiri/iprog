package first;

/**
 * Berechnung der 3. Wurzel von x
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 08.11.2021
 */

public class ThirdRoot {
    public static double thirdRoot(double x) {
        int n = 1;
        int maxIterations = 10000;
        double maxError = 1e-10;
        double xn = 2.0;
        double xnPlus1 = 1;
        while (Math.abs((xnPlus1 - xn)) >= maxError && n < maxIterations) {
            xn = xnPlus1;
            xnPlus1 = xn - (xn*xn*xn-x) / (3*xn*xn);
            MyIO.writeln("n = " + n + ", xnPlus1 = " + xnPlus1); //Kontrollausgabe
            n = n+1;
        }
        return xnPlus1;
    }

    public static void main(String[] args) {
        double x = MyIO.readDouble("Wert für x: ");
        System.out.println(thirdRoot(x));
    }
    
}