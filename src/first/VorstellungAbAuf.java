package first;

/**
 * Alle Namen der Mitglieder ausgeben, 
 * dabei sollen sich in den Texten an aufeinanderfolgenden Positionen große und kleine Buchstaben abwechseln.
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 04.10.2021
 */

public class VorstellungAbAuf 
{
	/**
	 * makes one letter uppercase and passes on the rest, if available
	 * @param x is the string of rest of the name that passed on
	 */
	public static String up (String x) 
	{
		return x.length() == 1 ? x.toUpperCase() :
		x.substring(0,1).toUpperCase() + down( x.substring(1) );
	}
	
	/**
	 * makes one letter lowercase and passes on the rest, if available
	 */
	public static String down (String x) 
	{
		return x.length() == 1 ? x.toLowerCase() :
		x.substring(0,1).toLowerCase() + up( x.substring(1) );
	}

	public static void main (String[] args) 
	{	
		String dennis = "DennisDeifel", denis = "DenisMaric", dominik = "DominikAgres", chris = "ChrisKiriakou";

		System.out.println( up(dennis) );
		System.out.println( up(denis) );
		System.out.println( up(dominik) );
		System.out.println( up(chris) );
	}
}