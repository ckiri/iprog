package first;

/**
 * Alle Namen der Mitglieder ausgeben, dabei sollen in den Texten die Distanzen der Buchstaben abwechselnd eins und zwei betragen.
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 04.10.2021
 */

public class VorstellungDistanz12 
{    
    /**
     * puts a space between the letters.
	 * @param x are the remaining letters that are passed on.
	 */
    public static String split (String x) 
    {
        return x.length() <= 1 ? x : x.substring(0,1) + " " + splitsplit( x.substring(1) );
    }

    /** 
     * puts two spaces between the letters.
     */
    public static String splitsplit (String x) 
    {
        return x.length() <= 1 ? x : x.substring(0,1) + "  " + split( x.substring(1) );
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