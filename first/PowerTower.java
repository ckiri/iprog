package first;

/**
 * PowerTower, MyIO wurde erweitert mit der Methode ".readDouble":

    public static double readDouble (String prompt) {
      System.out.print(prompt);
      return Double.parseDouble(sc.nextLine().trim());
    }

 * @author DMaric, DDeifel, DAgres, CKiriakou
 * @version 1, 18.10.2021
 */

public class PowerTower {
    public static void main(String[] args) {
        double x = MyIO.readDouble("wert für x: ");
        int n = MyIO.readInt( "Wert für n: ");
        int a = 0; // Zählvariable
        double i = 0;
        System.out.println(PowTow(x, n, i, a));
    }
    public static double PowTow(double x, int n, double i, int a) {
        i = Math.pow(x,n);
        a++;
        return  a == n ? i = Math.pow(n,i) :
                PowTow(x, n, i, a);
    }
}
