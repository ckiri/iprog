package first;

/**
 * dass die sin-Funktion für einen eingelesenen x-Wert entsprechend dieser Summe approximiert und ausgibt:
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 08.11.2021
 */

public class Sinus 
{
	public static double Pi(double eErg) {
		long n = 1000000;
		long i = 1L;
		double j = 1;
		double formel;
		double zErg = 0;
		
		// Beginn der While-Schleife
		while(i <= n) {
			formel = 6/(j*j);
			i++;
			j++;			
			zErg = zErg + formel;  
		}
		return  eErg = Math.sqrt(zErg);
		
	}

    public static double sin(double x)
    {
        int k = 0;      //k Variable
        int maxIterations = 10000;   //Parameter maxIteration
        double maxError = 1e-10;        //Parameter max error
        double xn = x;                  
        double xnPlus1 = 0;
        
        double eErg = 0;
		x = x - Pi(eErg )*2 * ((long)(x/(Pi(eErg)*2)));

        do {  xnPlus1 +=xn;
            k++;
            xn = -xn * x * x / (2.0 * k * (2.0 * k + 1.0));     //xnPlus1 = formel ?  x ist long / Zahlen und k sind int
        }
         while(Math.abs(xn) >= maxError && k <= maxIterations); 
        return xnPlus1 + xn;     //return 
    }

    public static void main(String[] args) 
    {
        long x = MyIO.readLong("x = ");
        System.out.println("Lösung: " + sin(x));
    
    }   
}
