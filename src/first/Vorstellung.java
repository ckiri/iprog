package first;

/**
 * Alle Namen der Mitglieder ihrer Übungsgruppe ausgeben, 
 * dann sollen alle Namen nochmal ausgegeben werden, diesmal invertiert (gespiegelt).
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 04.10.2021
 */

public class Vorstellung 
{
	/**
	 * Inverts the given name and give it back
	 * @param x the string to invert the name
	 */
	public static String invert (String x) 
	{
		return x.length() <= 1 ? x :
		invert( x.substring(1) ) + x.substring(0,1);	//Operation runs itself recursive
	}

	public static void main (String[] args) 
	{
		String dennis = "Dennis Deifel", denis = "Denis Maric", dominik = "Dominik Agres", chris = "Chris Kiriakou";

		System.out.println(dennis);
		System.out.println(denis);
		System.out.println(dominik);
		System.out.println(chris);
		System.out.println();
		System.out.println( invert(dennis) );
		System.out.println( invert(denis) );
		System.out.println( invert(dominik) );
		System.out.println( invert(chris) );
	}
}