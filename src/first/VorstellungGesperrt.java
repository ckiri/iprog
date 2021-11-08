package first;

/**
 * Alle Namen der Mitglieder ausgeben, dabei sollen aufeinanderfolgende Buchstaben durch ein Leerzeichen getrennt sein.
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 04.10.2021
 */

public class VorstellungGesperrt 
{
    /**
	 * @param x are the remaining letters that are passed on.
	 */
    public static String split (String x) 
    {
        return x.length() <= 1 ? x : x.substring(0,1) + " " + split( x.substring(1) );
    }

    public static void main (String[] args) 
    {
        String dennis = "DennisDeifel", denis = "DenisMaric", dominik = "DominikAgres", chris = "ChrisKiriakou";

        System.out.println( split(dennis) );
		System.out.println( split(denis) );
		System.out.println( split(dominik) );
		System.out.println( split(chris) );
    }
}